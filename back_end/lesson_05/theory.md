## Mocito

(Mockito и как его готовить)[https://habr.com/ru/articles/444982/]


##  @ParameterizedTest

This annotation is allowed to create test method with argument. This annotation always used with other one, that the source of argument define. As a source of argument can be used

Эта аннотация позволяет создать тестовый метод с аргументом. Эта аннотация всегда используется вместе с другой аннотацией, определяемой источником аргумента. В качестве аргумента можно использовать

1  array (@ValueSource):

```java
@ParameterizedTest(name="test 1: {arguments}")
    @ValueSource(strings = {"1a","2a","3a"})
    void test1_endWith(String str){
        Assertions.assertTrue(str.endsWith("a"));
    }
```


2  CSV File (@CsvFileSource):

```java
@ParameterizedTest(name="test 1: {arguments}")
    @CsvFileSource(resources = "/data.csv")
    void test2_parseInt(int i, String str){
        Assertions.assertEquals(i, Integer.parseInt(str));
    }
```


3  CSV Literals (@CsvSource):

```java
@ParameterizedTest(name="test 1: int: {0} str:{1}")
    @CsvSource({"1,qwe","2,qwe1","2,2"})
    void test_parseInt(int i, String str){
        Assertions.assertEquals(i, Integer.parseInt(str));
    }
```
 

4  Methods (@CsvSource):

```java
@ParameterizedTest(name="test 1: int: {0} str:{1}")
    @MethodSource("argsProviderMethod")
    void test_parseInt(int i, String str){
        Assertions.assertEquals(i, Integer.parseInt(str));
    }

    public static Stream<Arguments>  argsProviderMethod() {
        return Stream.of(
                Arguments.of(1,"ret"),
                Arguments.of(1,"1"),
                Arguments.of(2,"2")
        );
    }
```

etc.


## Maven (Управление зависимостями и Maven)

1. Разработка с зависимостями
2. Автоматизация задач в процессе сборки проекта


## Общий алгоритм добавления библиотеки

1. Определение задачи (например: обработка JSON). Поиск подходящих библиотек (Google, Maven Repository, помощь коллег и т.д.)
3. Выбор. Критерии: знание, функционал, популярность, наличие документации и примеров, сложность использования, лицензия. 
Взять самую популярную - часто походит, но не всегда
4. Подключение библиотеки в проект
5. использование в вашем коде

## Как добавить зависимость в Maven


### Вариант 2. Вручную. Работает для любых IDE и даже без них

1. Ищем библитеку по названию в [https://mvnrepository.com/](https://mvnrepository.com/)
2. Копируем сниппет для Maven в pom.xml  межлу тегами   \<dependencies> ...  \</dependencies>

```xml
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.5.0</version>
    <scope>test</scope>
</dependency>
```

Maven может быть установлен как отдельная утилита или можно исполтзовать maven предустанвленный в IDEA. 
Альтернативой Maven может быть Gradle
 
 

