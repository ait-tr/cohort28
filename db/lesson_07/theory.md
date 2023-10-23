**Примеры запросов**

```jsx
// Авторизация (аутентификация) юзера
db.users.countDocuments(
    {
        email: email,
        password: password,
        is_blocked: { $ne: true }
    }
)

// Вывести ко-во заблокированных юзеров не из China
db.users.countDocuments(
    {
        country: { $ne: 'China' },
        is_blocked: true
    }
)

// Вывести юзеров из `Germany`, `France`
db.users.find(
    {
        country: { $in: ['Germany', 'France'] }
    }
)

// Заблокировать юзеров из France
db.users.updateMany(
    { country: 'France' }, // filter
    { // action
        $set: {
            is_blocked: true
        }
    }
)

// Удалить тег из треков
db.tracks.updateMany(
    {}, // filter
    { // action
        $pull: { tags: 'super' }
    }
)

// Добавить несколько элементов в множество
db.tracks.updateMany(
    {},
    {
        $addToSet: {
            tags: { $each: ['mega', 'new'] }
        }
    }
)
```

**Операторы модификации**

- `$set`
- `$unset`
- `$inc`
- `$mul`
- `$addToSet`
- `$each`
- `$push`
- `$pull`
- `$pullAll`

## Удаление в MongoDB / Методы `deleteOne()` / `deleteMany()`

- аргументы
    - `filter`

**Задача. Добавить три юзера из `China`**

```jsx
db.users.insertMany([
    { fullname: 'China User 1', country: 'China' },
    { fullname: 'China User 2', country: 'China' },
    { fullname: 'China User 3', country: 'China' },
])
```

**Пример. Удалить всех юзеров из `China`**

```jsx
db.users.deleteMany(
    { country: 'China' }
)
```

## MongoDB Aggregation Framework

- позволяет получить вычисленные данные
- инструмент для анализа, обработки данных
- реализуется методом `aggregate()`
- представляет конвеер (`pipeline`), который содержит определенные этапы обработки (`stages`)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/6f9da238-35a6-485f-80b9-ddd25dab8622/Untitled.png)

## Метод `aggregate()`

- аргументы
    - (1) массив этапов обработки (`pipeline`, конвеер)

```jsx
[
	{}, // этап 1
	{}, // этап 2
	{}, // этап 3
	{}, // этап 4
]
```

**Пример. Вывести все треки**

```jsx
db.tracks.aggregate()
```

## Основные стадии (этапы, stages) обработки - операторы

- `$match` фильтрация
- `$sort` сортировка
    - `-1` по убыванию
    - `1` по возрастанию
- `$project` проекция
- `$limit` лимитирование
- `$skip` пропустить (документы)
- `$group` группировка
- `$lookup` объединение коллекций
- `$addFields` добавить поля
- `$sample` получить произвольные документы
- `$count` возвращает ко-во документов
- `$unwind` развернуть массив

**Пример. Работа с юзерами**

```jsx
// вывести всех юзеров
db.users.aggregate()

// вывести юзеров с балансом от 20 (EUR)
db.users.aggregate([
    { // фильтрация
        $match: {
            balance: { $gte: 20 }
        }
    }
])

// вывести незаблокир. юзеров
db.users.aggregate([
    { // фильтрация
        $match: {
            is_blocked: { $ne: true }
        }
    }
])

// вывести всех юзеров по убыванию баланса
db.users.aggregate([
    { // сортировка
        $sort: { balance: -1 }
    }
])

// вывести ТОП-3 юзеров по макс. балансу
db.users.aggregate([
    { // сортировка
        $sort: { balance: -1 }
    },
    { $limit: 3 } // лимитирование
])
```

**Задача. Вывести одного незаблокированного юзера с минимальным балансом**

```jsx
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } }, // фильтрация
    { $sort: { balance: 1 } }, // сортировка (по возраст.)
    { $limit: 1 } // лимитирование
])
```

**Пример. Вывести ко-во незаблокированных юзеров**

```jsx
// вар. 1
db.users.countDocuments(
    { is_blocked: { $ne: true } }
)

// вар. 2
db.users.aggregate(
    { $match: { is_blocked: { $ne: true } } },
    { $count: 'unblocked_users' }
)
```

**Пример. Вывести имена юзеров**

```jsx
db.users.aggregate([
    {
        $project: {
            fullname: 1,
            _id: 0
        }
    }
])
```

**Задача. Вывести баланс и имя юзера `1`**

```jsx
db.users.aggregate([
    { $match: { _id: 1 } },
    { $project: { fullname: 1, balance: 1, _id: 0 } }
])
```

**Задача. Вывести названия треков `1, 3, 5`**

```jsx
db.tracks.aggregate([
    { $match: { _id: { $in: [1, 3, 5] } } },
    { $project: { title: 1, _id: 0 } }
])
```

**Задача. Вывести имена юзеров с балансом от `10` до `1000` EUR**

```jsx
db.users.aggregate([
    { $match: { balance: { $gte: 10, $lte: 1000 } } },
    { $project: { fullname: 1, _id: 0 } }
])
```

**Пример. Вывести юзера, который находится на втором месте по балансу**

```jsx
db.users.aggregate([
    { $sort: { balance: -1 } },
    { $skip: 1 },
    { $limit: 1 }
])
```

**Задача. Вывести название и продолжительность трека, который находится на третьем месте по продолжительности**

```jsx
db.tracks.aggregate([
    { $sort: { duration_secs: -1 } },
    { $skip: 2 },
    { $limit: 1 },
    { $project: { title: 1, duration_secs: 1, _id: 0 } }
])
```

**Пример. Вывести один произвольный трек**

```jsx
db.tracks.aggregate([
    {
        $sample: { size: 1 }
    }
])
```

**Задача. Вывести имя одного произвольного незаблокированного юзера**

```jsx
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $sample: { size: 1 } },
    { $project: { fullname: 1, _id: 0 } }
])
```

**Пример. Вывести треки, включая данные об авторах**

```jsx
db.tracks.aggregate([
    {
        $lookup: {
            from: 'users', // название колл., откуда взять данные
            localField: 'author_id', // локальное поле
            foreignField: '_id', // внешнее поле
            as: 'author' // куда поместить результат
        }
    }
])
```

**Пример. Добавить юзера (без треков)**

```jsx
db.users.insertOne(
    {
        _id: 6,
        fullname: 'No Tracks User',
        country: 'France',
        balance: 10
    }
)
```

**Пример. Вывести юзеров, включая данные об их треках**

```jsx
db.users.aggregate([
    {
        $lookup: {
            from: 'tracks', // название колл., откуда взять данные
            localField: '_id', // локальное поле
            foreignField: 'author_id', // внешнее поле
            as: 'tracks' // куда поместить результат
        }
    }
])
```

**Задача. Вывести юзеров, у которых отсутствуют треки**

```jsx
db.users.aggregate([
    {
        $lookup: {
            from: 'tracks', // название колл., откуда взять данные
            localField: '_id', // локальное поле
            foreignField: 'author_id', // внешнее поле
            as: 'tracks' // куда поместить результат
        }
    },
    {
        $match: { tracks: [] }
				// $match: { tracks: { $size: 0 } }
    }
])
```

## Оператор агрегации `$unwind`

- позволяет “развернуть” массив (отказаться от массива)

```jsx
{ $unwind: '$author' }
```

**Пример**

```jsx
db.tracks.aggregate([
    {
        $lookup: {
            from: 'users', // название колл., откуда взять данные
            localField: 'author_id', // локальное поле
            foreignField: '_id', // внешнее поле
            as: 'author' // куда поместить результат
        }
    },
    { $unwind: '$author' }
])
```

**Пример. Вывести названия треков и имена авторов**

```jsx
db.tracks.aggregate([
    {
        $lookup: {
            from: 'users', // название колл., откуда взять данные
            localField: 'author_id', // локальное поле
            foreignField: '_id', // внешнее поле
            as: 'author' // куда поместить результат
        }
    },
    { $unwind: '$author' },
    {
        $project: {
            _id: 0,
            title: 1,
            author_fullname: '$author.fullname'
        }
    }
])
```