### Принципы программирования на практике: AOP

## Обработка исключений при валидации

Исключения валидации обычно обрабатываются глобально с помощью `@ControllerAdvice` или локально в каждом контроллере. Ниже приведен пример глобальной обработки исключений:

```java
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
```

В этом примере, когда возникает исключение `MethodArgumentNotValidException` (обычно вызванное нарушением ограничений валидации), метод `handleValidationExceptions` собирает все ошибки валидации и возвращает их в виде карты, где ключ — это имя поля, а значение — сообщение об ошибке.

### Использование Валидации в Контроллере

Для активации валидации в контроллере используется аннотация `@Valid`:

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/users")
    public String addUser(@Valid @RequestBody User user) {
        // Логика добавления пользователя
        return "User added successfully";
    }
}
```

В этом примере, если объект `User` не соответствует заданным валидационным ограничениям, будет автоматически выброшено исключение `MethodArgumentNotValidException`, которое затем обрабатывается в `GlobalExceptionHandler`.

### Обработка `ConstraintViolationException

`ConstraintViolationException` — это исключение, выбрасываемое Hibernate Validator, когда ограничения валидации нарушаются на уровне базы данных или сервиса, а не на уровне входных данных контроллера (как `MethodArgumentNotValidException`). Это чаще всего происходит при работе с операциями на уровне базы данных или когда валидация применяется к методам сервиса.

Для обработки `ConstraintViolationException`, можно использовать похожий подход с `@ControllerAdvice`. Пример:

```java
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyPath, message);
        });
        return errors;
    }
}
```

В этом примере, `ConstraintViolationException` перехватывается, и детали нарушений валидации собираются в карту, которая затем возвращается в ответе.

### Применение Валидации на Уровне Сервиса

Вы можете применить валидацию непосредственно к методам в вашем сервисном слое, используя аннотацию `@Validated`. Пример:

```java
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

@Service
@Validated
public class UserService {

    public void createUser(@Valid User user) {
        // логика создания пользователя
    }
}
```

В этом примере, если объект `User` не соответствует заданным ограничениям валидации при вызове метода `createUser`, будет выброшено исключение `ConstraintViolationException`, которое затем можно обработать, как описано выше.

`ConstraintViolationException` обычно возникает на более низком уровне, чем `MethodArgumentNotValidException`, и требует дополнительного уровня обработки исключений. 
Его обработка похожа на обработку других исключений в Spring, и она обеспечивает гибкость в управлении ошибками валидации на уровне сервисов и репозиториев.

### Исключение `MethodArgumentNotValidException`

Исключение `MethodArgumentNotValidException` в Spring Boot обычно выбрасывается при валидации входных данных в контроллере, когда эти данные не соответствуют ограничениям, определённым аннотациями валидации. Вот основные моменты, когда и как это исключение может быть выброшено:

### Когда Пробрасывается `MethodArgumentNotValidException`

1. **В контроллерах Spring MVC или REST**: Это исключение обычно возникает в контроллерах, когда обрабатываются HTTP запросы. Если входные данные (например, объекты, переданные через `@RequestBody` или `@ModelAttribute`) не соответствуют ограничениям валидации, определённым с помощью аннотаций из спецификации JSR 380 (например, `@NotNull`, `@Size`, `@Email` и т.д.), Spring автоматически выбрасывает это исключение.

### Как Пробрасывается

1. **Использование Аннотации `@Valid` или `@Validated`**: Чтобы активировать валидацию, вы должны пометить параметр метода аннотацией `@Valid` (стандарт JSR 380) или `@Validated` (специфичная для Spring). Эти аннотации указывают Spring проверять соответствие объекта ограничениям валидации.

2. **Определение ограничений валидации в классах**: Ограничения валидации определяются в классах, которые используются как параметры методов контроллера. Аннотации валидации могут быть размещены непосредственно на полях класса или на геттерах.

### Пример

Вот пример метода контроллера, где может быть выброшено `MethodArgumentNotValidException`:

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/users")
    public String addUser(@Valid @RequestBody User user) {
        // Логика добавления пользователя
        return "User added successfully";
    }
}
```

В этом примере:

- `@Valid @RequestBody User user`: Аннотация `@Valid` активирует валидацию для объекта `User`. Если какое-либо из полей `User` не соответствует ограничениям валидации, Spring выбросит `MethodArgumentNotValidException`.
- Ошибка обработки: Если `MethodArgumentNotValidException` выброшено, его можно обработать глобально с помощью `@ControllerAdvice` или локально в контроллере.

### Заключение

`MethodArgumentNotValidException` является ключевым механизмом для обработки ошибок валидации входных данных в Spring Boot и используется для обеспечения корректности и целостности данных, передаваемых в приложение.

------------------------------------------------

## AOP

Aspect-Oriented Programming (AOP) в Java представляет собой парадигму программирования, которая дополняет традиционное объектно-ориентированное программирование (ООП) путём добавления "аспектов". Это позволяет инкапсулировать функциональность, которая не является основной для бизнес-логики, но необходима для поддержки системы, такую как логирование, безопасность, транзакционность и кэширование.

Основные концепции АОП в Java:

1. **Аспект (Aspect)**: Модуль, инкапсулирующий поведение (advice) и точки присоединения (pointcuts) в одном месте вне определения класса, на который это поведение влияет.

2. **Advice**: Код, который выполняется в определенных точках программы. Существует несколько типов advice:
    - **Before**: Выполняется до вызова метода.
    - **After**: Выполняется после вызова метода.
    - **After-returning**: Выполняется после успешного завершения метода.
    - **After-throwing**: Выполняется, если метод вызывает исключение.
    - **Around**: Заменяет метод, обеспечивая возможность выполнения дополнительного кода до и после вызова метода.

3. **Pointcut**: Выражение, определяющее моменты в программе, когда должны применяться advices. Pointcuts определяют "где" и "когда" в программе будет выполняться advice.

4. **Join Point**: Конкретная точка в программе, такая как вызов метода или обращение к переменной.

5. **Target Object**: Объект, к которому применяется аспект.

6. **Weaving**: Процесс, в котором аспекты интегрируются в целевую программу.

### Примеры:

1. **Логирование**:
    - **Aspect**:
      ```java
      @Aspect
      public class LoggingAspect {
          @Before("execution(* com.example.service.*.*(..))")
          public void logBefore(JoinPoint joinPoint) {
              System.out.println("Before method: " + joinPoint.getSignature().getName());
          }
      }
      ```

2. **Безопасность**:
    - **Aspect**:
      ```java
      @Aspect
      public class SecurityAspect {
          @Before("execution(* com.example.service.*.*(..))")
          public void checkAuthentication() {
              // проверка аутентификации пользователя
          }
      }
      ```

3. **Транзакционность**:
    - **Aspect**:
      ```java
      @Aspect
      public class TransactionAspect {
          @Around("execution(* com.example.service.*.*(..))")
          public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
              try {
                  // начало транзакции
                  Object result = joinPoint.proceed();
                  // завершение транзакции
                  return result;
              } catch (Exception e) {
                  // откат транзакции
                  throw e;
              }
          }
      }
      ```

В этих примерах аспекты используют аннотации Spring AOP для определения advices и pointcuts. 
AOP позволяет разработчикам более чётко разделять основную логику приложения от перекрестных проблем (cross-cutting concerns), таких как: логирование или безопасность, что упрощает поддержку и развитие программного обеспечения.