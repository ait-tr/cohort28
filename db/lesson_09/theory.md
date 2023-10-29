## Ссылки

- [пример схемы БД “поликлиника”](https://dbdiagram.io/d/6538eeadffbf5169f06b7624)
- [бесплатное облако MongoDB](https://www.mongodb.com/products/platform/cloud)
- [как установить MySQL на Windows](https://selectel.ru/blog/tutorials/how-to-install-mysql-on-windows/)
- [супер-песочница](https://sqliteonline.com/)
- [справочник по SQL](https://www.sqltutorial.org/)
- [справочник по MongoDB](https://www.mongodb.com/docs/manual/tutorial/getting-started/)

## Пример формулы расчета количества пропуска документов (`$skip` / `OFFSET`)

```sql
LIMIT = 10
PAGE = 1
OFFSET = LIMIT * (PAGE - 1)
```

**Примеры запросов**

```jsx
// Количественное распределение юзеров по странам
db.users.aggregate([
    {
        $group: {
            _id: '$country', // поле группировки
            total_users: { $count: {} }
        }
    }
])

// Вывести статистику по всем юзерам
db.users.aggregate([
    {
        $group: {
            _id: null, // поле группировки
            total_users: { $count: {} },
            avg_balance: { $avg: '$balance' }
        }
    }
])
```

![Screenshot from 2023-10-27 12-17-36.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/a80c43b7-2186-4b53-87bf-bb087071f92a/Screenshot_from_2023-10-27_12-17-36.png)

**Задача. Вывести страны поставщиков**

```sql
SELECT DISTINCT
	Country
FROM Suppliers
```

**Задача. Вывести название и стоимость в `USD` товаров от поставщиков `1` и `4`**

```sql
SELECT 
	ProductName,
	Price * 1.05 AS Price_usd
FROM Products

WHERE
	SupplierID IN (1, 4)
```

**Задача. Вывести заказы клиентов `90` и `81`**

(проекция: `номер_заказа`, `имя_клиента`)

```sql
SELECT
	Orders.OrderID,
	Customers.CustomerName
FROM Orders

JOIN Customers ON Orders.CustomerID = Customers.CustomerID

WHERE
	Orders.CustomerID IN (90, 81)
```

## Ключевое слово `USING()`

**Пример**

```sql
JOIN Customers USING(CustomerID)
```

```sql
SELECT
	Orders.OrderID,
	Customers.CustomerName
FROM Orders

JOIN Customers USING(CustomerID)
-- JOIN Customers ON Orders.CustomerID = Customers.CustomerID

WHERE
	Orders.CustomerID IN (90, 81)
```

**Задача. Вывести `названия` и `ID` товаров, которые не были заказаны ни разу**

```sql
SELECT
		Products.ProductID,
    Products.ProductName
FROM Products

LEFT JOIN OrderDetails ON Products.ProductID = OrderDetails.ProductID
-- LEFT JOIN OrderDetails USING(ProductID)

WHERE
	OrderDetails.ProductID IS NULL
```

![Screenshot from 2023-10-27 13-45-46.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/43b3adbe-b76a-4d49-b4d6-07f33cc25582/Screenshot_from_2023-10-27_13-45-46.png)

## Структура SQL

- `**DQL` (Data Query Language)**
    - `SELECT`
    - `SELECT DISTINCT`
- `**DDL` (Data Definition Language)**
    - `CREATE` - создать объект (напр., БД, таблица и т.д.)
    - `DROP` - удалить
    - `ALTER` - изменить
    - `RENAME` - переименовать
- `**DML` (Data Manipulation Language)**
    - `INSERT INTO` - добавить записи
    - `UPDATE` - изменить записи
    - `DELETE` - удалить записи
- **`DCL` (Data Control Language)**
- **`TCL` (Transaction Control Language)**

## Основные типы данных в MySQL

- каждый столбец (поле) таблицы должен иметь указание на тип данных

## SQL: DDL

### Создание БД

```sql
CREATE DATABASE db_name;
CREATE DATABASE IF NOT EXISTS db_name; -- с проверкой, что указанная БД не существует
```

## Создание таблиц

```sql
CREATE TABLE <название_таблицы> (<структура>);
CREATE TABLE IF NOT EXISTS <название_таблицы> (<структура>);

CREATE TABLE users (
	-- название_поля тип_данных доп_хар-ки
	user_id int
);
```

## Удалить таблицу

```sql
DROP TABLE <название_таблицы>;
```

## Создание таблиц. БД `видео_хостинг`

```sql
CREATE TABLE users (
	user_id int,
	created_at timestamp,
	username varchar(64),
	country varchar(64),
	is_blocked bool
);
```

**Задача. Создать таблицу `videos`**

```sql
CREATE TABLE videos (
  video_id int,
  created_at timestamp,
  title varchar(128),
  author_id int,
  duration_secs int
);
```

## Валидация данных в SQL / SQL Constraints

**Основные ограничения:**

- `primary key` (`unique + not null`)
- `unique` уникальное
- `not null` не пустое
- `foreign key` внешний ключ
- `check` проверка условий
- `default` установка значения по умолчанию

**Пример. Создать таблицу `products`**

```sql
CREATE TABLE IF NOT EXISTS products (
	product_id int primary key auto_increment,
	title varchar(128) not null,
	price float check (price > 0),
	created_at timestamp default current_timestamp,
	supplier_id int,
	FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id) -- добавить привязку (проверку) к suppliers
);
```

**Задача. Создать таблицу `users` с использованием механизма валидации данных**

```sql
CREATE TABLE users (
	user_id int primary key auto_increment,
	created_at timestamp default current_timestamp,
	username varchar(64) not null,
	country varchar(64) not null,
	is_blocked bool default false
);
```

**Задача. Добавить двух юзеров в таблицу `users`**

```sql
INSERT INTO users (username, country)
VALUES
		('hacker', 'USA'),
    ('ivan000', 'Germany');
```

## Подзапросы (вложенные запросы) / Sub Queries

**Пример. Вывести фамилии менеджеров без заказов**

```sql
SELECT
	LastName
FROM Employees

LEFT JOIN Orders USING(EmployeeID)

WHERE
	Orders.EmployeeID IS NULL
--

SELECT
	LastName
FROM Employees

WHERE
	NOT EmployeeID IN (SELECT DISTINCT EmployeeID FROM Orders)
```

**Пример. Вывести товары с ценой выше средней**

```sql
SELECT *
FROM Products
WHERE
	Price > (SELECT AVG(Price) FROM Products)
```

**Задача. Вывести `названия` и `ID` товаров, которые не были заказаны ни разу (с использованием подзапроса)**

```sql
SELECT
	ProductName,
	ProductID
FROM Products

WHERE
	ProductID NOT IN (
    SELECT DISTINCT ProductID
    FROM OrderDetails
	)
```