## Web protocols
модель клиент-сервер используется при построении системы обработки информации на основе СУБД, а также почтовые системы

The client-server model is used to build an information processing system based on a DBMS, as well as mail systems

**HTTP Hyper Text Transfer Protocol**

**HTTPs Hyper Text Transfer Protocol secured** - Данные передаются в засекреченном виде

**SSL/TLS** - протокол шифрования данных

**Public/Privat Key** - подпись цифровым сертификатом

**FTP File Transfer Protocol**

**POP3 SMTP** - почтовые протоколы для отправки и получение писем (POP3 - протокол для входящей почты; SMTP - для исходящей почты)

**IMAP** - почтовые протоколы для отправки

**UDP User Datagram Protocol** - данные уходят набором данных

##### Request (запрос)
клиента к серверу

Base Line/ Start line: method; URI; protocol

method - что хотим сделать?

URI где мы это хотим сделать

##### Response (ответ)

от сервера клиенту

Status code standard

HEADERS: param1: atr1,atr2,atr3 Content-type: image cookeis: last-modified: 14.01.2021 15:49:10 GMT

BODY

**Status code**

- 1хх Info (101 switching protocols)
- 2хх Success (200 OK)
- 3хх Redirect (304 Not Modified)
- 4хх Client error (404 Not Found)
- 5хх Server error (500 Internal server error)

**Methods**

- GET - получение ресурса
- POST - создание ресурса
- PUT - обновление ресурса
- DELETE - удаление ресурса

[Презентация](https://docs.google.com/presentation/d/1rWmGrN9HM-oam9BbYRaSiWTYcYh0O0lO/edit?usp=share_link&ouid=116447005932578256378&rtpof=true&sd=true)

## Postman
Основное предназначение приложения — создание коллекций с запросами к API

The main purpose of the application is to create collections with requests to the API

**Collection**

объединяет в себе все связанные запросы. Обычно API описывается в одной коллекции, но нет никаких ограничений сделать по-другому

combines all related queries. Usually the API is described in one collection, but there are no restrictions on doing it differently

**Folder**

используется для объединения запросов в одну группу внутри коллекции

used to combine queries into one group within a collection

**Request**

основная составляющая коллекции. Postman умеет выполнять запросы с помощью всех стандартных HTTP методов. У запроса есть свои скрипты

the main component of the collection. Postman can perform requests using all standard HTTP methods. The request has its own scripts

**Переменные**

Postman имеет несколько пространств и областей видимости для переменных:

- Переменные окружения
- Локальные переменные
- Переменные уровня данных

Переменные окружения существуют отдельно от коллекций. Локальные переменные создаются из выполняемых скриптов. Также существуют переменные уровня данных, но они доступны только из Runner

Postman has several spaces and scopes for variables:

- Environment Variables
- Local variables
- Data Layer Variables

Environment variables exist separately from collections. Local variables are created from executed scripts. There are also data level variables, but they are only accessible from the Runner

QA21 ilCarro collection https://api.postman.com/collections/8263422-491290a8-49df-4e0f-951a-526283cf121d?access_key=PMAT-01HKSKVDXCVPHBFS2PTWDRCRK0

[Swagger ilcarro](https://ilcarro-backend.herokuapp.com/swagger-ui/index.html#/)

[Презентация](https://docs.google.com/presentation/d/1MQScNG0ov11tGNFSFt5mDV-Gp5f-pQF8iiHMPTzBClk/edit?usp=share_link)
