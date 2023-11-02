### Lombok
`Lombok` - библиотека, которая берет на себя генерацию "шаблонного кода" т.е. геттеров, сеттеров, конструкторов и т.д. 
Необходимость генерации того или иного кода в классе указывается с помощью аннотаций.   
Наиболее распространенные аннотации Lombok:
* `@Getter` - генерирует геттеры. Может быть указана как для класса, так и для отдельного поля.
* `@Setter` - генерирует сеттеры. Может быть указана как для класса, так и для отдельного поля.
* `@NoArgsConstructor` - генерирует конструктор без аргументов.
* `@AllArgsConstructor` - генерирует конструктор со всеми полями.
* `@RequiredArgsConstructor` - генерирует конструктор с обязательными аргументами.
* `@ToString` - генерирует метод toString().
* `@EqualsAndHashCode` - генерирует метод Генерирует методы equals() и hashCode(), которые используют все или определенные поля объекта для сравнения и хеширования.
* `@Builder` - генерирует паттерн "строитель" для создания объектов.
* `@Data` - @ToString, @EqualsAndHashCode, @Getter/@Setter ко всем полям класса.

**Для использования в IDEA необходим специальный плагин (обычно, предустановлен) и необходимо включить настройку "Enable annotation processing"**   
(В IntelliJ IDEA  "File" > "Sittings" > "Build,Execution,Deployment" > "Compiler" > "Enable annotation processing" )

* @ToString с определенными полями:  
Вы можете использовать аннотацию `@ToString` с параметром *of* или *exclude* для настройки, какие поля должны включаться в метод toString().
Наприсер, в примере ниже будут использованы только поля "name","country", названия полей не будут вкльчены в итоговую строку

```java 
@ToString(of = {"name","country"},includeFieldNames = false)
```


* @EqualsAndHashCode с определенными полями:  
Вы можете использовать аннотацию @EqualsAndHashCode с параметрами of или exclude для настройки, какие поля должны участвовать в генерации методов equals() и hashCode(). 
Так исключить поле "population" можно:
```java 
@EqualsAndHashCode(exclude = {"population"})
```

Пример:
```java 
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = {"name","country"},includeFieldNames = false)
@EqualsAndHashCode(exclude = {"population"})
public class City {
    private Long id;
    private String name;
    private String country;
    private @Setter int population;
}
```


### OpenAPI (Swagger)

OpenAPI Swagger значительно упрощает создание, тестирование и документирование RESTful API

В pom.xml
```xml
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-ui</artifactId>
            <version>1.7.0</version>
        </dependency>

 
```

Завуск
```
http://localhost:8080/swagger-ui/index.html 
```






### RestController  


`@RequestBody` - это аннотация, которая используется в параметрах метода контроллера, чтобы указать, что метод должен читать тело HTTP-запроса и преобразовать его в объект Java. 
Используется при создании, например, POST-запросов, когда вы отправляете данные на сервер в теле запроса.

`@ResponseBody` - это аннотация, которая указывает, что метод контроллера должен возвращать результат в теле HTTP-ответа. 
Это означает, что результат метода будет автоматически сериализован в JSON или другой формат и отправлен обратно клиенту.


@RestController - это аннотация, которая объединяет @Controller и @ResponseBody. Она используется для создания контроллера, который обрабатывает 
HTTP-запросы и возвращает данные в виде объектов, которые автоматически сериализуются в формат JSON  и отправляются в ответ на запрос






