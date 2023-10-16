**Задача. Вывести данные о товарах с ценой от `10` до `150` EUR**

(проекция: `ср_цена`, `ко-во_товаров`)

```sql
SELECT 
	AVG(Price) AS avg_price,
	COUNT(*) AS products_count
FROM Products

WHERE
 Price BETWEEN 10 AND 150
```

**Задача. Вывести заказы менеджера `5`**

(проекция: `имя_менеджера`, `фамилия_менеджера`, `номер_заказа`)

```sql
SELECT 
	Orders.OrderID,
	Employees.FirstName,
	Employees.LastName
FROM Orders

JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID

WHERE 
	Employees.EmployeeID = 5
```

## **Группировка в SQL (механизм агрегации) / оператор `GROUP BY`**

**Группировка** - объединение записей на основе общего признака с целью получения обобщеных данных

**Пример. Вывести страны покупателей**

```sql
SELECT DISTINCT
	Country
FROM Customers

SELECT
    COUNT(*) AS total_customers
FROM Customers

-- конечное решение
SELECT
		Country,
    COUNT(*) AS total_customers
FROM Customers

GROUP BY Country

ORDER BY total_customers DESC
```

**Пример. Вывести кол/распределение товаров по категориям**

```sql
SELECT
		CategoryID,
    COUNT(*) AS total_products
FROM Products

GROUP BY CategoryID

ORDER BY total_products DESC
```

**Задача. Вывести кол/распределение товаров по поставщикам (без `JOIN`)**

```sql
SELECT
		SupplierID,
    COUNT(*) AS total_products
FROM Products

GROUP BY SupplierID

ORDER BY total_products DESC
```

**Задача. Вывести кол/распределение товаров по поставщикам**

(проекция: `название_поставщика`, `ко-во_поставленных_товаров`)

```sql
SELECT
		Suppliers.SupplierName,
    COUNT(*) AS total_products
FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

GROUP BY Suppliers.SupplierID

ORDER BY total_products DESC
```

**Задача. Вывести кол/распределение заказов по клиентам**

(проекция: `имя_клиента`, `ко-во_заказов`)

```sql
SELECT
		Customers.CustomerName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

GROUP BY Customers.CustomerID

ORDER BY total_orders DESC
```

**Задача. Вывести статистику по заказам для менеджеров `1, 2, 5` (для каждого отдельно)**

проекция: `фамилия_менеджера`, `ко-во_заказов`

```sql
SELECT 
	Employees.LastName, 
	COUNT(Orders.OrderID) AS count_orders 
FROM Orders

JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID

WHERE
	Orders.EmployeeID IN (1, 2, 5)

GROUP BY Orders.EmployeeID

ORDER BY count_orders DESC
```

**Задача. Вывести ТОП-1 компанию-перевозчика (и ко-во заказов) по количеству доставок**

(проекция: `название_компании`, `ко-во_заказов`)

```sql
SELECT
		Shippers.ShipperName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID

GROUP BY Orders.ShipperID

ORDER BY total_orders DESC
LIMIT 1
```

**Задача. Вывести ТОП-3 самых продаваемых товаров**

(проекция: `название_товара`, `ко_во_проданных_единиц`)

```sql
SELECT
	Products.ProductName,
	SUM(OrderDetails.Quantity) AS sold_count
	
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID = Products.ProductID

GROUP BY OrderDetails.ProductID

ORDER BY sold_count DESC
LIMIT 3
```

**Задача. Вывести стоимость каждого заказа в упорядоченном виде**

(проекция: `номер_заказа`, `сумма_заказа`)

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost

FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID

ORDER BY order_cost DESC
```

## Оператор `HAVING`

- аналог `WHERE`, который позволяет отфильтровать агрегированные данные

**Пример. Вывести заказы со стоимостью от `10000` (EUR)**

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost

FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID

HAVING
	order_cost >= 10000

ORDER BY order_cost DESC
```

**Задача. Вывести поставщиков, у которых средняя стоимость товара выше `40` EUR**

(проекция: `название_компании_поставщика`, `сред_стоимость`)

```sql
SELECT 
		Suppliers.SupplierName,
		AVG(Products.Price) AS avg_price
FROM Products

JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID

GROUP BY Products.SupplierID
HAVING
	avg_price > 40

ORDER BY avg_price DESC
```

**Задача. Вывести страны, в которые было отправлено `3` и более заказов**

(проекция: `страна`, `ко-во заказов`)

```sql
SELECT
		Customers.Country,
    COUNT(*) AS total_orders
FROM Orders

JOIN Customers ON Orders.CustomerID = Customers.CustomerID

GROUP BY Customers.Country
HAVING
	total_orders >= 3

ORDER BY total_orders DESC
```

## Основные типы данных в MySQL

- каждый столбец (поле) таблицы должен иметь указание на тип данных

### Числовые

- `int` / `integer`
- `float`

### Строковые

- `varchar(x)`
    - `x` - макс. ко-во символов
- `text(x)`
    - `x` - макс. ко-во символов

### Логические

- `bool`

### Дата / время

- `datetime` / `**timestamp**`
- `date`
- `time`

## Схема БД “онлайн-шахматы”

**Сущности**

- `players`
- `matches`
- `chats`
- `messages`
- `maps`

## Ссылки

- [пример схемы онлайн-школы](https://dbdiagram.io/d/online_school-652921d3ffbf5169f0a0e4d9)
- [инструмент онлайн-проектирования БД](https://dbdiagram.io/d/)
- [песочница](https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all)