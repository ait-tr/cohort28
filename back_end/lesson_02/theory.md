
## архитектура приложения  (Controller-Service-Repository)

Классическая архитектура приложения Controller-Service-Repository включает следующие слои:    
   - Слой "контроллеров" (Controller) - отвечают за конечное взаимодействие с клиентом (в нашем случае т.е. WEB приложение этот слой отвечает за обработку HTTP)
   - Слой "сервисов" (Service) - отвечает за бизнес-логику приложения
   - Слой "репозиториев" (Repository) - отвечает за взаимодействие с хранилищем данных

<img src="https://docs.google.com/drawings/d/e/2PACX-1vSXFlybHnCBAGwSmlJ13XTXopg41oBSjLtKdl0SU217Gs6zKwqQ0yCNkuBx76zaH-2Lt4EhJCUC_9Xd/pub?w=717&amp;h=466">

The Controller-Service-Repository pattern is prevalent in a lot of applications especially Spring Boot applications. One of the big reasons is that it does a great job of a separation of concerns: 
The Controller layer, at the top of this picture, is solely responsible for exposing the functionality so that it can be consumed by external entities (including, perhaps, a UI
component). The Repository layer, at the bottom of this picture, is responsible for storing and retrieving some set of data. The Service layer is where all the business logic should go. 
If the business logic requires fetching/saving data, it wires in a Repository. If someone wants to access this business logic, they go through a Controller to get there. 
If code is related to storage/retrieval, it should go in the Repository. If its dealing with exposing functionality, it goes in the Controller. Anything unique in the
business logic would go in the Service layer. The Repository doesn’t care which component is invoking it; it blindly does what it is asked. The Service layer doesn’t care how it gets accessed, 
it just does its work, using a Repository where required. And the Controller is just passing the work down to the Service layer, so it can stay nice and lean. 
It’s a pretty simple separation of concerns.

We create an additional, separate layer model or entity (models of the business area, entities that will be saved in the repository)
ё

Шаблон *«Controller-Service-Repository»* часто используется в приложениях, в том числе Spring Boot. Одна из главных причин, заключается в том, что он отлично справляется с разделением задач: 
уровень контроллера несет полную ответственность за предоставление функциональности, чтобы ее могли использовать внешние объекты ( включая, возможно, компонент пользовательского интерфейса). 
Уровень репозитория  отвечает за хранение и извлечение некоторого набора данных. Уровень сервиса — это место, где должна находиться вся бизнес-логика. Если бизнес-логика требует
выборки/сохранения данных, она подключается к репозиторию. Если кто-то хочет получить доступ к этой бизнес-логике, он проходит через контроллер. 
Если код связан с хранением/извлечением, он должен находиться в репозитории. Если
речь идет о предоставление функциональности, это происходит в контроллере. Все уникальное в бизнес-логике будет помещено на уровень сервиса. 

Репозиторию  не важно, какой компонент его вызывает; он слепо делает то, что его просят. 
Уровень сервиса не заботится о том, как к нему осуществляется доступ, он просто выполняет свою работу, используя репозиторий, где это необходимо. 
Контроллер просто передает запросы на уровень сервиса.  Это довольно простое разделение задач.


Кроме того, создаем лополнительный, отдельный слой model или entity  (модели предметной области, сущности, которые будем сохранять в хранилище)

Важно:

- Для обеспечения гибкости приложений следует применять подход, при котором один класс не зависит от другого напрямую. Вместо этого мы создаем интерфейсы и прописываем зависимости через них.
- Для обеспечения гибкости приложений все взаимодействия в приложение осцествляются между соседними слоями т.е. котнроллер не может вызывать репозиторий напрямую. Репозиторий не обращается у контроллеру. 
  Вместо этого еонтроллер вызывает методы сервис-слоя, а сервис слой вызывает методы репозитория. 





Дополнительно   

[Dependency Injection (DI) и Inversion of Control (IoC)](https://www.ait-tr.de/post/dependency-injection-di-%D0%B8-inversion-of-control-ioc)
