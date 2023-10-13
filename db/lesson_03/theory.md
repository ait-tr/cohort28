## Ссылки

- [UUID](https://ru.wikipedia.org/wiki/UUID)
- [инструмент онлайн-проектирования](https://dbdiagram.io/d/)
- [сетевые порты](https://vc.ru/u/1193668-fenixhost/473172-setevye-porty-chto-eto-takoe)

## IPO-модель

- Input
- Processing
- Output

**Задача. Вывести имена клиентов не из `Germany` и не из `France`**

```sql
SELECT 
	CustomerName
FROM Customers

WHERE
	NOT Country IN ('Germany','France')
```

**Задача. Вывести данные о трех последних заказах**

(проекция: `номер_заказа`, `фамилия_менеджера`)

```sql
SELECT 
	Orders.OrderID, 
	Employees.LastName

FROM Orders

JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID

ORDER BY Orders.OrderDate DESC
LIMIT 3
```

## Агрегация данных в SQL

**Базовые категории запросов**

1. **CRUD** - более простые запросы
2. **Aggregation** - получение вычисленных данных (итоги, статистика, аналитика)

**Базовые операторы (функции) агрегации**

- `COUNT()` расчет ко-ва строк
- `AVG()` расчет сред/ариф. знач.
- `MAX()` расчет макс. значения
- `MIN()` расчет мин. значения
- `SUM()` расчет суммы

**Пример. Вывести общее ко-во товаров**

```sql
SELECT
	COUNT(*) AS total_products
FROM Products
```

**Примеры. Работа с клиентами**

```sql
-- общее ко-во
SELECT
	COUNT(*)
FROM Customers

-- ко-во из Germany
SELECT
	COUNT(*) AS de_clients
FROM Customers
WHERE
	Country = 'Germany'
```

**Пример. Работа с товарами**

```sql
-- вывести ко-во товаров с ценой от 20 EUR
SELECT
	COUNT(*) total_products
FROM Products
WHERE
	Price >= 20

-- сред/цена по всем товарами
SELECT
	AVG(Price) AS avg_price
FROM Products
```

**Пример. Вывести статистику по товарам**

```sql
SELECT
	AVG(Price) AS avg_price,
	MIN(Price) AS min_price,
	MAX(Price) AS max_price,
	COUNT(*) AS total_products,
	SUM(Price) as products_sum
FROM Products
```

**Задача. Вывести ко-во поставщиков из `USA`**

```sql
SELECT
	COUNT(*) AS usa_suppliers
FROM Suppliers

WHERE
	Country='USA'
```

**Задача. Вывести ко-во клиентов из `USA`, `UK`, `France`**

```sql
SELECT
	COUNT(*) AS total_customers
FROM Customers

WHERE
	Country IN ('USA', 'UK', 'France')
```

**Задача. Вывести среднюю стоимость товаров до `150` EUR (вкл.)**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products

WHERE
	Price <= 150
```

**Задача. Вывести ко-во заказов у менеджера `5`**

```sql
SELECT
    COUNT(*) AS orders_count
FROM Orders

WHERE
    EmployeeID = 5
```

**Задача. Вывести сред/стоимость товаров из категорий `1, 2, 5`, у которых название начинается с `t`**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products

WHERE
	CategoryID IN (1, 2, 5)
	AND
	ProductName LIKE 't%'
```

**Задача. Посчитать стоимость заказа `10248`**

```sql
SELECT
	SUM(Products.Price * OrderDetails.Quantity) AS order_cost
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID = Products.ProductID

WHERE
	OrderDetails.OrderID = 10248
```

**Задача. Вывести `название` и `стоимость` самого дорогого товара в `1` категории, исп. агрегацию**

```sql
SELECT
	MAX(Price) AS Price,
	ProductName
FROM Products

WHERE
	CategoryID=1
```

**Задача. Вывести `название` и `стоимость` самого дешевого товара в ценовом диапазоне `10 - 150` EUR, исп. агрегацию**

```sql
SELECT
	MIN(Price) AS Price,
	ProductName
FROM Products

WHERE
	Price BETWEEN 10 AND 150
```

**Задача. Вывести `ко-во заказов`, которое оформил клиент `1`**

```sql
SELECT
	COUNT(*) AS total_orders
FROM Orders

WHERE
	CustomerID=1
```

**Задача. Вывести, сколько раз был продан (заказан) товар `72`**

```sql
SELECT
	COUNT(*) AS sold_count
FROM OrderDetails

WHERE
	ProductID=72
```

**Задача. Вывести `среднюю стоимость` напитка (`Beverages`) из `USA`**

```sql
SELECT 
	AVG(Products.Price) AS avg_price
-- ROUND(AVG(Products.Price), 4) AS avg_price

FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
JOIN Categories ON Products.CategoryID=Categories.CategoryID

WHERE
	Categories.CategoryName='Beverages'
	AND
	Suppliers.Country='USA'
```

**Задача. Вывести ко-во заказов, которое компания `Speedy Express` доставила в `Brazil`**

```sql
SELECT
	COUNT(*) AS total_shipped_to_brazil

FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
JOIN Customers ON Orders.CustomerID=Customers.CustomerID

WHERE
		Shippers.ShipperName='Speedy Express'
    AND
    Customers.Country='Brazil'
```

## Проектирование БД

**Общие тезисы**

1. На одном сервере могут находиться **СУБД (DBMS)**
- **сетевой порт** - сетевой идентификатор процесса (программы)
1. В одной **СУБД** может находиться несколько **БД**
2. В одной **БД** может храниться несколько типов сущностей (объектов)
3. Стандартный подход: **ОДНА БД == ОДИН ПРОЕКТ**
4. Стандартный подход: **ОДНА СУЩНОСТЬ == ОДНА ЗАПИСЬ**

## Общие этапы проектирования БД

1. Анализ предметной обасти (бизнес-процессов)
2. Выделение сущностей и их свойств (характеристик)
3. Связывание сущностей между собой (установление связей)
    1. с помощью ключевых полей (`первичный` и `внешний` ключи)
4. Проверка решения (гипотезы)

## Первичный ключ (primary key)

- Является идентификатором каждой сущности

**Свойства**

- уникальный
- неизменяемый
- ненулевой

**Стандартные подходы к определению значения**

1. Авто-инкремент
2. Случайные значения (`UUID`, `GUID`, `ULID`)

## Базовые виды связей между сущностями

- `1:1` (один к одному)
- `1:M` (один ко многим)
- `M:M` (многие ко многим)

## Схема БД “онлайн-магазин” (песочница)

**Связи**

```sql
Orders.CustomerID (M:1) Customers.CustomerID
Orders.EmployeeID (M:1) Employees.EmployeeID
Orders.ShipperID (M:1) Shippers.ShipperID

OrderDetails.OrderID (M:1) Orders.OrderID
OrderDetails.ProductID (M:1) Products.ProductID

Products.SupplierID (M:1) Suppliers.SupplierID
Products.CategoryID (M:1) Categories.CategoryID
```