## Unit Test
Unit Tests are written for test the smallest unit of our software possible, usually just a single method within a class. 
 

### Benefits of Unit Testing / Польза от Unit Testing

- Facilitates Code Maintenance and Refactoring   
- Error Detection at Early Stages     
- Improved Software Design  
- Enhanced Collaboration and Communication among Developers 
- Helps to clearly defined and understand functional requirements for unit 

<br/>

- Облегчает обслуживание и рефакторинг кода.  
- Помогает обнаружить ошибоки на ранних стадиях  
- Улучшенный дизайн программного обеспечения  
- Способствкет взаимодецствию между разработчиками.
- Помогает четко определить и осознать функциональные требования к модулю  


### Principles of Unit Testing / Принципы модульного тестирования  
 
- Isolation of Components     
- Test Small Parts of the Codebase  
- Repeatable and Consistent Results

<br/>

- Изоляция компонентов   
- Тестирование небольших частей кода, обычно методов  
- Повторяемые и стабильные результаты  



### Structure of Unit Test / Структура Unit теста

Every Unit Test has the same and very simple structure:  

- set up (arrange)    
- execute the tested method (act)   
- check assertions (assertions)  

In the first section the testing data are prepared, the dependencies are mocked, and seated up the context of the test. 
In the second section the tested method is called with the data that was prepared. 
In the last section Unit Test asserts hard-coded expected value against the actual one.
When talking about Unit Test structure often use AAA abbreviation: arrange, act, assertions.   

<br/>

Каждый модульный тест имеет одинаковую и очень простую структуру:

- поднотовка (arrange)    
- выполнение тестового иетода (act)   
- сравнение реального результата с ожидаемым (assertions)  

В первом разделе подготавливаются данные для тестирования, зависимости щаменяются заглушками, настраивается контекст теста.
Следующим шагом, вызываем метод, который хотим протестировать, с зарание подготовленными данными.
Последний шаг: сравнивает жестко запрограммированное ожидаемое значение с фактическим, т.е. тем, что вернул метод.
Говоря о структуре модульного теста, часто используют аббревиатуру ААА: arrange, act, assertions.


### Essential Junit 5 Annotation / основные аннотации Junit 5

|                  |                                             |                                    |
|------------------|---------------------------------------------|------------------------------------|
|@Test             |Denotes that a method is a test method       | Определяет метод, который тестируем|
|@ParameterizedTest|Denotes that a method is a parameterized test| Определяет параметризованный тест|
|@DisplayName      |Declares a custom display name for the test class or test method|Определяет, как отображается тест в логе|
|@BeforeEach       |Denotes that the annotated method should be executed before each @Test |Обозначает, что аннотированный метод должен выполняться перед каждым @Test|
|@AfterEach        |Denotes that the annotated method should be executed after each @Test  |Обозначает, что аннотированный метод должен выполняться после каждого @Test|
|@BeforeAll        |Denotes that the annotated method should be executed before all @Test  |Обозначает, что аннотированный метод должен выполняться перед выподнением тестов|
|@AfterAll         |Denotes that the annotated method should be executed after all @Test   |Обозначает, что аннотированный метод должен выполняться после того, как все тесты будут выполнены|
|@Nested           |Denotes that the annotated class is a non-static nested test class.   |Обозначает, вложенный тестовый класс|


 
 

