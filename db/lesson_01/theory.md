## Ссылки

- [песочница (интернет-магазин)](https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all)

## Базовый состав типового проекта

- `FE` - интерфейс
    - веб-сайты - человеко-чит.
    - приложения - человеко-чит.
    - `API` (`JSON`/`XML`) - машино-чит.
    - чат-боты
- `BE` - бизнес-логика
- `**DB` - хранилище**
- `Deployment` - развертывание

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/49849b39-9d67-488f-a6fe-b6bb9f04aa5a/Untitled.png)

## Базы данных (Data Bases, DB)

**БД (DB)** - **структурированный** набор данных, предназначенный для автоматизированной обработки

- фактически, представляет собой **данные**
- цифровая копия сущностей (объектов) реального мира

**СУБД (DBMS, Data Base Management Software)** - прикладное ПО (приложение)

- Система Управления Базой Данных

## Схема работы с БД (СУБД)

`BE - > DBMS → DB`

## Типы СУБД

- Первичная (primary) - напр., `MySQL`, `MongoDB`
- Вторичная (secondary) - напр., `Redis`

## Модели данных (БД)

- Способ описания (хранения, структурирования) данных
1. Реляционная (табличная) - напр., `MySQL`
2. Документная - напр., `MongoDB`
3. Графовая (теория графов) - напр., `OrientDB`
4. Плоская - напр., `Redis`

## Степени абстракции данных

- **данные (то, что дано):** `150`, `‘hello’`, `-200.5`
- **информация (фактология):** Товар имеет стоимость `150` EUR за единицу
- **сведения (заключение):** Товар имеет стоимость `150` EUR за единицу - для нашей компании это очень дорого

## Способы подключения к СУБД

1. Из программного кода (`BE`) - целевой (основной) способ
2. Из `GUI`/`CLI`-клиентов - вспомогательный способ

## Типы операций в СУБД

- Чтение
- Запись

## Категории операций в СУБД

1. `CRUD` (Create Read Update Delete) - более простые
2. Aggregation (аналитика, итоги, статистика) - вычисленных данных

![Screenshot from 2023-10-09 12-09-19.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/83f1885a-2492-4400-99c0-31c03689ca19/Screenshot_from_2023-10-09_12-09-19.png)

## SQL: CRUD

- `SQL` - язык структурованных запросов
- Как правило, используется в реляционных СУБД

## Проекция полей (в  БД)

- инструмент оптимизации запросов (на чтение)
    - уменьшение времени выполнения запроса
    - снижение нагрузки на выч/ресурсы

## Самая распространенная архитектура хранения данных

- ОДИН ОБЪЕКТ (СУЩНОСТЬ) == ОДНА ЗАПИСЬ

## Базовые структуры данных

- скаляр (скалярное значение)
- массив
- карта (ассоц/массив)
- множество

## SQL: READ

- `SELECT`
- `SELECT DISTINCT` (только уникальные значения)

**Примеры**

```sql
-- вывести всех клиентов
SELECT *
FROM Customers

SELECT
		Country, -- проекция (полей)
    City
FROM Customers
```

```sql
-- вывести страны клиентов (только уникальные значения - без дублей)
SELECT DISTINCT
	Country -- проекция
FROM Customers
```

**Задача. Вывести данные о поставщиках**

(проекция: `название_компании`, `страна`)

```sql
SELECT
		SupplierName, -- проекция
    Country
FROM Suppliers
```

## Фильтрация в SQL / Оператор `WHERE`

**Пример. Вывести клиентов из `Germany`**

```sql
SELECT *
FROM Customers
WHERE
	Country='Germany'
```

**Задача. Вывести город и почтовый индекс клиентов из `France`**

```sql
SELECT
		City,
    PostalCode -- проекция
FROM Customers
WHERE
	Country='France' -- фильтрация
```

## Операторы сравнения

- `=` равно
- `!=` `<>` не равно
- `>`больше
- `<`меньше
- `>=` больше или равно
- `<=` меньше или равно

## Логические операторы (приоритет - сверху вниз)

- `NOT` логическое отрицание (унарный)
- `AND` логическое И (бинарный)
- `OR` логическое ИЛИ (бинарный)

**Пример. Вывести клиентов из `Germany` (`Berlin`)**

```sql
SELECT *
FROM Customers

WHERE
		Country='Germany'
    AND
    City='Berlin'
```

**Пример. Вывести клиентов не из `Germany`**

```sql
SELECT *
FROM Customers

WHERE
	NOT Country = 'Germany'
  -- Country != 'Germany'
  -- Country <> 'Germany'
```

**Задача. Вывести товары с ценой от `50` до `100` EUR**

```sql
SELECT *
FROM Products

WHERE
	Price >= 50
	AND
	Price <= 100
```

**Задача. Вывести клиентов из `Germany` и `France`**

```sql
SELECT *
FROM Customers

WHERE
		Country='Germany'
    OR
    Country='France'
```

**Задача. Вывести клиентов, кроме тех, что из `UK` и `USA`**

```sql
SELECT *
FROM Customers

WHERE
	NOT Country='UK'
	AND
	NOT Country='USA'
```

**Задача. Вывести номера телефонов поставщиков из `UK` и `Brazil`**

```sql
SELECT
	Phone
FROM Suppliers

WHERE
		Country = 'UK'
    OR
    Country = 'Brazil'
```

## Оператор `IN`

- проверка принадлежности к списку значений

```sql
SELECT *
FROM Customers
WHERE
	Country='Germany'
	OR
	Country='France'
--

SELECT *
FROM Customers
WHERE
	Country IN ('Germany', 'France')
```

```sql
SELECT *
FROM Customers

WHERE
	NOT Country='UK'
	AND
	NOT Country='USA'

--
SELECT *
FROM Customers
WHERE
	NOT Country IN ('UK', 'USA')
-- Country NOT IN ('UK', 'USA')
```

**Задача. Вывести название и стоимость товаров из категорий `1` и `3` со стоимостью до `50` EUR**

```sql
SELECT
		ProductName,
    Price
FROM Products
WHERE
		Price <= 50
    AND
    CategoryID IN (1, 3)
--

SELECT
		ProductName,
    Price
FROM Products
WHERE
		Price <= 50
    AND
    (CategoryID = 1 OR CategoryID = 3)
```

**Задачи. Вывести товары с ценой от `80` до `190` EUR не из категории `5`**

```sql
SELECT *
FROM Products

WHERE
		Price >= 80 AND Price <= 190
    AND
    NOT CategoryID=5
```

## Оператор диапазона `BETWEEN`

**Пример**

```sql
SELECT *
FROM Products
WHERE
		Price BETWEEN 80 AND 190
    AND
    NOT CategoryID=5
```

**Задача. Вывести товары с ценой от `10` до `50` EUR из категорий `1, 2, 3`**

```sql
SELECT *
FROM Products

WHERE
		Price BETWEEN 10 AND 50
    AND
    CategoryID IN (1, 2, 3)
```

## Сортировка в SQL / Оператор `ORDER BY`

**Пример**

```sql
SELECT *
FROM Products
ORDER BY Price DESC
	-- DESC - по убыванию
	-- ASC - по возрастанию (по умолчанию)
```

**Задача. Вывести товары из `5` категории по возрастанию цены**

```sql
SELECT *
FROM Products

WHERE
	CategoryID=5

ORDER BY Price ASC
```

## Лимитирование вывода / Оператор `LIMIT`

- Как правило, применяется для:
    - постраничного (порционного) вывода (напр., товаров в каталоге)
    - вывода блока рекомендаций

**Пример. Вывести три самых дорогих товара**

```sql
SELECT *
FROM Products
ORDER BY Price DESC

LIMIT 3 OFFSET 0 -- стр. 1
-- LIMIT 3 OFFSET 3 -- стр. 2
-- LIMIT 3 OFFSET 6 -- стр. 3
```

```sql
-- пример формулы смещения (OFFSET)
PAGE = 1
LIMIT = 3
OFFSET = LIMIT * (PAGE - 1)
```

**Задача. Вывести название и стоимость одного самого дорогого товара из категории `1`**

```sql
SELECT
		ProductName, -- проекция
   	Price        -- полей
FROM Products

WHERE
	CategoryID=1  -- фильтрация

ORDER BY Price DESC -- сортировка
LIMIT 1 -- лимитирование
```

**Задача. Вывести товар, который находится на третьем месте среди самых дорогих**

```sql
SELECT *
FROM Products
ORDER BY Price DESC
LIMIT 1 OFFSET 2
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

## Псевдонимы в SQL / Оператор `AS`

**Примеры**

```sql
SELECT
		ProductName,
    Price AS Price_eur,
    Price * 1.05 AS Price_usd
FROM Products
```

```sql
SELECT *,
	Price * 1.05 AS Price_usd
FROM Products
```

```sql
SELECT *,
	Price * .95 AS Price_down
FROM Products
```

**Задача. Вывести названия товаров, а также их стоимость:**

- полную
- со скидкой в `25%`
- с наценкой в `15%`

```sql
SELECT
		ProductName,
    Price AS Price_full,
    Price * .75 AS Price_low,
    Price * 1.15 AS Price_up
FROM Products
```