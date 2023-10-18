## MongoDB GUI Client

[Download Studio 3T for MongoDB | Windows, macOS & Linux](https://studio3t.com/download/)

## `URI` для подключения

```sql
mongodb+srv://ab:Os9yUOqHKfxhKO0M@cluster0.u54vil2.mongodb.net/admin?retryWrites=true&replicaSet=atlas-qut493-shard-0&readPreference=primary&srvServiceName=mongodb&connectTimeoutMS=10000&authSource=admin&authMechanism=SCRAM-SHA-1&3t.uriVersion=3&3t.connection.name=atlas-qut493-shard-0&3t.databases=admin&3t.alwaysShowAuthDB=true&3t.alwaysShowDBFromUserRole=true&3t.sslTlsVersion=TLS
```

## Принципиальные отличия MongoDB от RDBMS

1. Другой язык для выполнения запросов (`NoSQL - QUERY API`)
2. Модель данных - **ДОКУМЕНТНАЯ** (документ - ассоц/массив, карта)
3. Использует `JSON` и Binary `JSON` (`BSON`)
4. Динамическая схема данных (без схемы, `schemaless`) - каждый документ может иметь свой набор полей
5. Позволяет хранить вложенные структуры данных

## Базовые структуры данных

1. Скаляр (скалярное значение)
2. Массив (список значений)
3. Ассоц/массив (карта, документ, объект - пары ключ/значения)
4. Множество (список **уникальных** элементов)

```jsx
// пример
users = [
	{username: 'hacker', email: '123@example.org', is_blocked: true},
	{username: 'user1', email: 'hello@example.org', phone: '+0000000000'}
]
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/768b6029-3665-497e-8814-89a8e20257c2/Untitled.png)

## Масштабирование

- горизонтальное (количество)
- вертикальное (качество)

## Категории запросов

1. `CRUD` - более простые запросы
2. Aggregation - получение вычисленных данных

## MongoDB: CRUD

**Create**

- `insertOne()` добавить один документ
    - один аргумент
        - ассоц/массив (объект)
- `insertMany()` добавить несколько документов
    - один аргумент
        - массив ассоц/массивов

**Read**

- `findOne()`  найти (выбрать) один документ
- `find()` найти (выбрать) несколько документов
    - аргументы
        - `filter`
        - `projection`
- `countDocuments()` ко-во совпадений
    - аргументы
        - `filter`

**Update**

- `updateOne()` изменить один документ
- `updateMany()` изменить несколько документов
    - аргументы
        - `filter`
        - `action`

**Delete**

- `deleteOne()` удалить один документ
- `deleteMany()` удалить несколько документов
    - аргументы
        - `filter`
    
    ![Screenshot from 2023-10-18 12-28-07.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/7963035e-f362-493f-ac22-58d69c7da5e0/Screenshot_from_2023-10-18_12-28-07.png)
    

## БД `music` - сервис онлайн-музыки

**Основные сущности**

- `users`
- `tracks`

**Пример. Добавление юзеров**

```jsx
db.users.insertMany([
    { _id: 1, fullname: 'Ivan Ivanov', country: 'Germany' },
    { _id: 2, fullname: 'Petr Ivanov', country: 'USA' },
    { _id: 3, fullname: 'Sidr Ivanov', country: 'Germany' },
    { _id: 4, fullname: 'hacker', country: 'USA' },
    { _id: 5, fullname: 'noname', country: 'France' }
])
```

**Пример. Вывести всех юзеров**

```jsx
db.users.find()
```

**Пример. Вывести юзеров из `Germany`**

```jsx
db.users.find(
    { country: 'Germany' }, // filter
)

// с проекцией
// вывести имена юзеров из Germany
db.users.find(
    { country: 'Germany' }, // filter
    { fullname: 1, _id: 0 } // projection
)
```

**Примеры. Вывести страны юзеров**

```jsx
db.users.find(
    {}, // filter
    { country: 1, _id: 0 } // projection
)
```

**Задача. Вывести страну юзера `1`**

```jsx
db.users.findOne(
    { _id: 1 }, // filter
    { country: 1, _id: 0 } // projection
)
```

**Задача. Вывести всех юзеров (без поля `_id`)**

```jsx
db.users.find(
    {},
    { _id: 0 }
)
```

**Задача. Добавить пять треков (`tracks`)**

```jsx
db.tracks.insertMany([
    { _id: 1, title: 'Track 1', duration_secs: 5 * 60, author_id: 1 },
    { _id: 2, title: 'Track 2', duration_secs: 4 * 60, author_id: 2 },
    { _id: 3, title: 'Track 3', duration_secs: 6 * 60, author_id: 3 },
    { _id: 4, title: 'Track 4', duration_secs: 7 * 60, author_id: 4 },
    { _id: 5, title: 'Track 5', duration_secs: 9 * 60, author_id: 5 }
])
```

**Задача. Вывести название и продолжительность трека `4`**

```jsx
db.tracks.findOne(
    { _id: 4 },
    { title: 1, duration_secs: 1, _id: 0 }
)
```

**Задача. Вывести все треки юзера `2` (кроме поля `author_id`)**

```jsx
db.tracks.find(
    { author_id: 2 },
    { author_id: 0, _id: 0 }
)
```

## Операторы сравнения

`$eq` равно (equal)

`$ne` не равно (not equal)

`$gt` больше (greater than)

`$gte` больше или равно (greater than or equal)

`$lt` меньше (less than)

`$lte` меньше или равно (less than or equal)

`$in` проверка принадлежности к списку значений

`$nin` не принадлежит списку значений

**Пример. Вывести треки с продолжительностью от `5` мин**

```jsx
db.tracks.find(
    { duration_secs: { $gte: 5 * 60 } }
)
```

**Задача. Вывести треки продолжительностью до одного часа (включительно)**

(проекция: `название`, `продолжительность`)

```jsx
db.tracks.find(
    { duration_secs: { $lte: 60 * 60 } },
    { title: 1, duration_secs: 1, _id: 0 }
)
```

**Задача. Вывести названия треков продолжительностью от `2` до `10` мин**

```jsx
db.tracks.find(
    { duration_secs: { $gte: 2 * 60, $lte: 10 * 60 } },
    { title: 1, _id: 0 }
)
```

## Метаданные любой сущности (технические характеристики)

- первичный ключ (`id`, `user_id`, `userID`)
- дата/время добавления записи (`datetime`, `timestamp`, `created`, `created_at`)

## Пример БД “онлайн-музыка”

**Основные сущности**

- `users`
- `tracks`
- `reactions` (шкала от `1` до `5`, реакция на треки)
- реализовать плейлисты (список воспроизведения)