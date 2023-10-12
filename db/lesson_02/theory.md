**Задача. Вывести номер и дату предпоследнего заказа**

```sql
SELECT
		OrderID,
    OrderDate
FROM Orders

ORDER BY OrderDate DESC
LIMIT 1 OFFSET 1
```

**Задача. Вывести три самых дешевых товара из категории `4` с ценой до `500` EUR**

```sql
SELECT *
FROM Products

WHERE
		CategoryID = 4
    AND
    Price <= 500

ORDER BY Price ASC
LIMIT 3
```

**Задача. Вывести товары от поставщиков `1` и `3` с ценой от `10` до `150` EUR (вкл.)**

(проекция: `название_товара`, `цена_со_скидкой_в_0.5_процента`)

```sql
SELECT
		ProductName,
    Price * .995 AS Price_down
FROM Products

WHERE
		SupplierID IN (1, 3)
    AND
    Price BETWEEN 10 AND 150
```

## Поиск по шаблону / Оператор `LIKE`

- поиск по нестрогому соответствию

**Базовые подстановочные символы (знаки)**

- `%` нулевой, один или несколько символов
- `_` один символ

**Примеры**

```sql
SELECT *
FROM Customers
WHERE
	Country LIKE 'usa'
```

```sql
SELECT *
FROM Suppliers
WHERE
	Phone LIKE '%555%'
```

```sql
SELECT *
FROM Customers
WHERE
	CustomerName LIKE '%alf%'
```

**Задача. Вывести имена и фамилии сотрудников, у которых в имени или фамилии есть вхождение строки `lio`**

```sql
SELECT
		FirstName,
    LastName
FROM Employees

WHERE
		FirstName LIKE '%lio%'
    OR
    LastName LIKE '%lio%'
```

## SQL: CRUD

- **Create**
    - `INSERT INTO`
- **Read**
    - `SELECT`
    - `SELECT DISTINCT`
- **Update**
    - `UPDATE`
- **Delete**
    - `DELETE FROM`

## SQL CRUD: Delete / удаление записей / Оператор `DELETE FROM`

**Пример. Удалить указанных клиентов**

```sql
DELETE FROM Customers
WHERE
	CustomerID IN (1, 3)
```

**Задача. Удалить товары, которые дешевле `5` EUR**

```sql
DELETE FROM Products
WHERE
	Price < 5
```

## SQL CRUD: Update / модификация / Оператор `UPDATE`

**Пример**

```sql

-- очистить указанные поля у клиента 1
UPDATE Customers
SET
		CustomerName='',
    ContactName=''
WHERE
	CustomerID=1
```

**Задача. Для поставщиков из `Japan` и `Spain` изменить телефон и контактное имя на произвольные значения**

```sql
UPDATE Suppliers
SET
	ContactName='Ivan Ivanov',
	Phone='0000000000'
WHERE
	Country IN ('Japan', 'Spain')
```

**Задача. У всех товаров от `50` до `60` (EUR) очистить `название` и установить `категорию 2`**

```sql
UPDATE Products
SET
		ProductName='',
	  CategoryID=2
WHERE
	Price BETWEEN 50 AND 60
```

**Пример. Увеличить стоимость всех товаров на `10%`**

```sql
UPDATE Products
SET
	Price = Price * 1.1
```

## SQL CRUD: Create / добавление / Оператор `INSERT INTO`

**Пример**

```sql
-- добавить двух перевозчиков
INSERT INTO Shippers (ShipperName, Phone)
VALUES
		('Shipper X', '+00000000000'),
    ('Shipper Y', '+11111111111')
```

**Задача. Добавить произвольного поставщика из `China`**

```sql
INSERT INTO Suppliers (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
VALUES 
	('XYZ Company', NULL, NULL, NULL, NULL, 'China', NULL);
```

## Ключевые поля

- первичный ключ (`PRIMARY KEY`)
- внешний ключ (`FOREIGN KEY`)

## Горизонтальное объединение таблиц / Оператор `JOIN`

- синтаксис `JOIN`

```sql
SELECT <проекция>
FROM <таблица_1>
JOIN <таблица_2> ON <таблица_1.внешний_ключ>=<таблица_2.первичный_ключ>
```

**Пример**

```sql
SELECT *
FROM Products
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID
```

```sql
SELECT
		Products.ProductName,
    Products.Price,
    Suppliers.SupplierName

FROM Products
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID
```

```sql
SELECT *
FROM Orders

JOIN Customers ON Orders.CustomerID = Customers.CustomerID
JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
```

**Задача. Вывести данные о заказах клиентов из `Germany`**

(проекция: `номер_заказа`, `имя_клиента`, `контактное_имя_клинта`)

```sql
SELECT
		Orders.OrderID,
    Customers.CustomerName,
    Customers.ContactName
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

WHERE
	Customers.Country='Germany'
```

**Задача. Вывести данные о товарах**
(проекция: `название_товара`, `цена_товара`, `название_категории`)

```sql
SELECT
    Products.ProductName,
    Products.Price,
    Categories.CategoryName
FROM Products

JOIN Categories ON Products.CategoryID = Categories.CategoryID
```

**Задача. Вывести все заказы, которые повезет `Speedy Express`**

(проекция: `номер_заказа`, `название_компании_перевозчика`)

```sql
SELECT
		Orders.OrderID,
    Shippers.ShipperName
FROM Orders

JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID

WHERE
	Shippers.ShipperName='Speedy Express'
```

**Пример. Вывести фамилии менеджеров без заказов**

```sql
SELECT
	LastName
FROM Employees

LEFT JOIN Orders ON Employees.EmployeeID = Orders.EmployeeID

WHERE
	Orders.EmployeeID IS NULL
```

## Операторы `IS NULL` и `IS NOT NULL`

```sql
SELECT
	LastName
FROM Employees

LEFT JOIN Orders ON Employees.EmployeeID = Orders.EmployeeID

WHERE
	Orders.EmployeeID IS NULL -- проверить что неопределено
```

**Задача. Вывести товары, которые не были заказы ни разу**

```sql
SELECT
		Products.ProductID,
    Products.ProductName
FROM Products

LEFT JOIN OrderDetails ON Products.ProductID = OrderDetails.ProductID

WHERE
	OrderDetails.ProductID IS NULL
```

**Пример оформления Д/З**

```sql
-- файл homework.sql
--
-- Задача 1. Вывести ...
SELECT ...

-- Задача 2. Вывести ...
SELECT ...
```

## Ссылки

- [генератор UUID](https://www.uuidgenerator.net/version4)