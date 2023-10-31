

### MVC

* **MVC** (Model, View, Controller) - — паттерн программирования, разделяющий архитектуру приложения на три
  модуля: модель (Model), представление (View), контроллер (Controller).

  * Model - данные и бизнес логика
  * View - представление результата
  * Controller - обработчик запросов, задача которого связать между собой данные и представление

Подход, реализованный во многих языках программирования и фреймворках в частности в Spring MVC.
Несмотря на то, что подход имеет ряд очевидных минусов, он хорошо подходит для реализации небольших приложений

В классической реализации Spring MVC предполагает генерацию готовых веб-страниц на стороне backend, для чего используются "шаблонизаторы", в нашем случае Thymeleaf.
Обрабатывая запрос, сервер создает готовую html страницу, подставляя данные в зарание подготовленный шаблон, и отправляет ее на frontend.

### Spring Web

Spring Web - проект Spring, которай содержит библиотеки и классы для простой реализации Web-приложений


### Controllers
Контроллеры (Controllers) - особые бины Spring Web, которые занимаются обработкой HTTP-запросов. Как правило контроллеры помечпються аннотацией `@Controller`.

Контроллер содержит методы-обработчики HTTP запросов, т.е. методы, которые вызываются в случаее, если на наш сервер пришел HTTP завпрос ('HTTP Request'). 
Для оьработки запроса, контроллер взаимодействует с сервисом. В результате обработки запроса контроллер возвращает спрингу имя прдеставления (view name), а спринг, в свою очередь, 
формирует на основе указанного view готовый html и отправляет его на front-end в качестве ответа.  
Обработчик HTTP запроса, настроеннай на конкретный URL иногда называют end point.


### Создание end points

Методы-обработчики в контроллере помечаются специальными аннотациями:
* `@GetMapping` - данный метод будет вызван при обработки GET запроса 
* `@PostMapping` - данный метод будет вызван при обработки POST запроса
*  @DeleteMapping` - данный метод будет вызван при обработки DELETE запроса  
и т.д. В каждой из этих аннотации необходимо указать адресс, на который должен прийти запрос, для срабаьывания данного обработчика. 
Так,  если сервер запущен на http://localhost:8080
  
```java
public class UserControllerWeb {
    @GetMapping("/users")
    public String listUsers(Model model){
           .......
    }
}

```
сработает при GET запросе на URL http://localhost:8080/users  

Запрос:
```java
public class UserControllerWeb {
    @PostMapping("/students")
    public String createStudent(@RequestParam("student_name") String name, @RequestParam String email){
           .......
    }
}

```
сработает при POST запросе на URL http://localhost:8080/students  


### Thymleaf  

Thymeleaf - это популярный шаблонизатор (template engine) для языка Java,
предназначенный для создания динамических веб-страниц. Он широко
используется во многих Java-приложениях, особенно в веб-приложениях,
поскольку он интегрируется с фреймворками, такими как Spring, и позволяет
разработчикам легко создавать веб-интерфейсы.
Аналоги: JSP (JavaServer Pages), Apache Velocity, Mustache, FreeMarker и т.д.

Шаблонизатор позволяет создать готовую HTML странице, на основе зарание созданного шаблона и дрнныз, поднотовленныз вашим приложением. Нароимер следующий шабл онThymeleaf:
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
 <h1>Users</h1>
 <table>
   <tbody>
   <tr th:each="user:${users}">
     <td th:text="${user.id}"></td>
     <td th:text="${user.name}"></td>
     <td th:text="${user.email}"></td>
   </tr>
   </tbody>
 </table>

</body>
</html>

```
* получает коллекцию с именем users. Переьирает элементы этой коллекции (user) и для каждого генерирует строку таблицы
```html
   <tr th:each="user:${users}">
```
Для доступа к значениям одного пользователя используется следуюшая конструкция (на примере user.id):
```html
     <td th:text="${user.id}"></td>
```

### Передача данных в представление (view)  
Для передачи данных с сервера на веб-страницу, Spring MVC использует специальный объект класса Model.  
Model - можно представить ка map<String, Object>  
Добавление данных в модель осущесьвляется в контроллере в обработчике с помощью вызова  model.addAttribute 

Например:
  
```java
@Controller
public class UserControllerWeb {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String listUsers(Model model){
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("users", allUsers);
        return "all_uses_view";
    }
}

```

