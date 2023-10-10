## Client–server       

The client–server model is a distributed application structure that partitions tasks or workloads between the providers of a resource or service, called servers, and service requesters, called clients.
The "client-server" characteristic describes the relationship of cooperating programs in an application. The server component provides a function or service to one or many clients, which initiate requests 
for such services. Servers are classified by the services they provide (WWW server, File server, Mail server etc).

**Frontend**  - is a program that implements the client functionality. In most cases, the client is a browser, and the front-end technologies is:  HTML, CSS, JavaScript (TypeScript, React, Angular etc.) 

**Backend**  - is a server-side program (Java, C++, Golang, Python etc.)

<img src="https://blogger.googleusercontent.com/img/a/AVvXsEhoG86pcBF1VPHbUY7AXflXzAykTr7RlqeW8OTp18SJ0aOXGPuL9kFYy1uQO76aBD-B8B10GNkYY6s38FhilYP0johqQTpsBoXIiCQZDNkcS47FGLaErrdFr2OG7cgimikOyeCpUVRz5zHVbZG8JYJGCk5JPuPzX9E4WUYT1KHNqpcDr2eR2BME5Y4uOA=s16000" width=50% height=50%>


Клиент-сервер — это структура приложения, которая предполанает наличие двух взаимоотношения взаимодействующих программ в приложении: поставщика ресурсов или услуг (сервер), и службы-инициатора запроса (клиент).
Серверный компонент предоставляет функцию или услугу одному или нескольким клиентам, которые инициируют запросы.
Серверы классифицируются по предоставляемым ими услугам (WWW-сервер, файловый сервер, почтовый сервер и т. д.).

**Frontend** — программа, реализующая клиентский функционал, в большинстве выполняется в браузере, а фронтенд технологии:  HTML, CSS, JavaScript (TypeScript, React, Angular etc.)

**Backend**  - программа выполняемая на стороне сервера (Java, C++, Golang, Python etc.)



## HTTP - Hypertext Transfer Protocol

[HTTP en](https://developer.mozilla.org/en-US/docs/Web/HTTP)  

[HTTP ru](https://developer.mozilla.org/ru/docs/Web/HTTP)


HTTP работает по модели запрос-ответ. В общении участвуют клиент и сервер.
Клиент, например веб-браузер, иницирует запрос а ему отвечает сервер.


### Request

Типичный запрос содержит:

- HTTP version
- URL
- HTTP method
- HTTP request headers
- Optional HTTP body.

**Версия HTTP**. Просто версия HTTP. Мы будет использовать версию 1.1

**URL - Uniform Resource Locator**. В адресной строке именно URL.
Примеры:
  - https://www.example.com/index.html  https - протокол, www.example.com - host, /index.html - путь(path)
  - https://www.google.com/search?q=pizza https - протокол, www.google.com - host, /search - path, q=pizza - запрос (query)
  - https://en.wikipedia.org/wiki/URL#See_also  https - протокол, en.wikipedia.org - host, wiki/URL - path, See_also - fragment 

**Метод**(так же иногда называемый verb) - это действие которое клиент ожидает от сервера к которому он обращается.
Два наиболее популярных метода: GET и POST. Первый используется, чтобы получить какую-то информацию с сервера.
Например когда открывате браузер, то браузер делает GET запрос.

**Header**. В загововках передается дополнительная информация. например какой-клиент используется или какой-тип информации нужно вернуть. Данные в формате ключ-значение.

![](https://www.cloudflare.com/img/learning/ddos/glossary/hypertext-transfer-protocol-http/http-request-headers.png)

**Body** - "тело" запроса. Может содержать любые данные. В случае HTTP JSON API там будет JSON

### Response

Типичный ответ серверы содержит

1. HTTP status code - код ответа
2. HTTP response headers - заголовки в ответе
3. HTTP body - тело ответа(опционально)

**HTTP status code** код ответа(или код состояния)- число из 3х цифр.
В первую очередь используется для того, чтобы сообщить был ли запрос успешен или произошла ошибка.

Коды возврата можно разбить на 5 типов

1. 1xx Informational
2. 2xx Success
3. 3xx Redirection
4. 4xx Client Error
4. 5xx Server Error

Код возврата 200+ означает, что запрос выполнен успешно. Например в ответ за запрос
на получение страницы самый популярный и ожидаемый ответ это 200 OK, что означает
что страница найдена и успешно передана клиенту.

Если у нас код возврата от 400 до 599, то значит прозошла ошибка. Если 4XX, то значит ошибка
на стороне клиента. Это значит что клиент отправил что-то не то. Самый известный код ошибки
это 404 Not found. Это означает, что заданный адрес не найден.
Статус 500-599 означает, что ошибка произошла на сервере.
300-е - означают, что ресурс есть но по другому адресу и по нему нужно проследовать.

**HTTP response headers**

![](https://www.cloudflare.com/img/learning/ddos/glossary/hypertext-transfer-protocol-http/http-response-headers.png)

Любые данные в формате ключ-значение(аналогично HTTP request headers) только в ответе.

- Тип данных (content-type text/html; charset=UTF-8)
- Cookie

**HTTP Body**

Тело ответа, часто там будет или JSON или html страница.

### HTTPS и безопасносность

Hypertext Transfer Protocol **Secure** (HTTPS)

HTTPS - это HTTP работающий поверх защиненного соединения(с шифрованием и проверкой подлинности).

HTTPS использует криптографические алгоритмы для двух вещей:

- Проверки, что сайт настоящий и злоумышленний не мог подменить сайт 
- Шифрование данных


## Curl

Curl - это крайне полезная и удобная утилита коммандной строки для отправки HTTP-запросов.
Утилита поддерживается множется других протоколов, но нас будет интересовать только HTTP. 
Очень гибкая: можно настроить любой аспект http-запроса(URL, заголовки, тело) и увидеть ответ
со всеми подробностями.

Очень удобна для отладки веб-сервиса. Вы сможете отправлять запросы любого вида и видеть
как на них отвечает ваше приложение.


## Примеры

Отправить GET запрос:

```sh
curl -X GET https://www.google.com/
```

Отправить GET-запрос(-X GET) и показать подробности(-v):

```
curl -v --http1.1 -X GET -H 'accept: application/json' 'https://catfact.ninja/fact' 
```

Отправить GET-запрос(-X GET) и показать заголовки(-i):

```
curl -X GET -i https://catfact.ninja/fact
```

Пример запроса к https://rapidapi.com/roftcomp-laGmBwlWLm/api/hapi-books
```
curl -L --http1.1 -H "Content-Type: application/octet-stream" -H "X-Rapidapi-Key: INSERT_REAL_KEY" -H "X-Rapidapi-Host: hapi-books.p.rapidapi.com" -X GET "https://rapidapi.com/top_authors"
```

Пример POST-запроса:

```
curl -X POST -H "Content-Type: application/json" -d '{"name":"test","salary":"123","age":"23"}' https://dummy.restapiexample.com/api/v1/create
```

## Интеграция с браузерами

Chrome and Firefox

Menu -> More Tools -> Web Developer Tools -> Network -> Copy Value -> Copy as cURL

## Почитать про curl

- [What JavaScript Developers Should Know About Curl](http://thecodebarbarian.com/what-javascript-developers-should-know-about-curl.html)
- [Шпаргалка по curl](https://gist.github.com/subfuzion/08c5d85437d5d4f00e58)


