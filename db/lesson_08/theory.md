## Оператор `$unwind`

**Пример**

**ДО (применения `$unwind`)**

```jsx
{
	_id: 1,
	fullname: 'hacker',
	array: [1, 2]
}
```

**ПОСЛЕ (применения `$unwind`)**

```jsx
{
	_id: 1,
	fullname: 'hacker',
	**array: 1**
},
{
	_id: 1,
	fullname: 'hacker',
	**array: 2**
}
```

**Пример фильтрации**

```jsx
$match: { tracks: { $ne: [] } }
```

**Пример. Добавить несколько реакций (на треки)**

```jsx
db.reactions.insertMany([
    { track_id: 1, author_id: 1, value: 5 },
    { track_id: 2, author_id: 2, value: 2 },
    { track_id: 3, author_id: 3, value: 1 },
    { track_id: 4, author_id: 4, value: 5 },
    { track_id: 5, author_id: 5, value: 3 },
    { track_id: 2, author_id: 1, value: 5 },
    { track_id: 2, author_id: 1, value: 4 },
    { track_id: 4, author_id: 2, value: 4 },
    { track_id: 4, author_id: 4, value: 2 },
    { track_id: 1, author_id: 4, value: 3 },
    { track_id: 1, author_id: 3, value: 3 }
])
```

**Задача. Вывести ко-во реакций у юзеров `1` и `4`, используя `aggregate()`**

```jsx
db.reactions.aggregate([
    { $match: { author_id: { $in: [1, 4] } } },
    { $count: 'reactions' }
])
```

**Задача. Вывести данные о реакциях**

(проекция: `имя_юзера`, `оценка`)

```jsx
db.reactions.aggregate([
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'author'
        }
    },
    { $unwind: '$author' },
    {
        $project: {
            _id: 0,
            value: 1,
            author_fullname: '$author.fullname'
        }
    }
])
```

**Задача. Вывести данные о реакциях юзера `1`**

(проекция: `имя_юзера`, `оценка`, `название_трека`)

```jsx
db.reactions.aggregate([
    { $match: { author_id: 1 } },
    {
        $lookup: {
            from: "users",
            localField: "author_id",
            foreignField: "_id",
            as: "author"
        }
    },
    { $unwind: "$author" },
    {
        $lookup: {
            from: "tracks",
            localField: "track_id",
            foreignField: "_id",
            as: "track"
        }
    },
    { $unwind: "$track" },
    {
        $project: {
            _id: 0,
            author_name: "$author.fullname",
            track_title: "$track.title",
            value: 1
        }
    }
])
```

## Группировка / оператор `$group`

- получает на входе документы
- объединяет их в группы по заданному **полю (или полям)** группировки
- на выходе - один документ равен одному уникальному значению **поля группировки**

**Базовые операторы группировки (аккумуляторы)**

- `$sum`
- `$avg`
- `$min`
- `$max`
- `$count`

**Пример. Количественное распределение юзеров по странам**

```jsx
db.users.aggregate([
    {
        $group: {
            _id: '$country', // поле группировки
            total_user: { $count: {} }
        }
    }
])
```

**Пример. Вывести статистику по всем юзерам**

```jsx
db.users.aggregate([
    {
        $group: {
            _id: null, // поле группировки
            total_user: { $count: {} },
            avg_balance: { $avg: '$balance' }
        }
    }
])
```

**Задача. Вывести среднюю продолжительность треков по каждому автору**

(без применения `$lookup`)

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    }
])
```

**Задача. Вывести среднюю продолжительность всех треков**

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: null,
            avg_duration: { $avg: '$duration_secs' }
        }
    }
])
```

**Задача. Вывести среднюю продолжительность треков по каждому автору**

(проекция: `имя_автора`, `сред_продолжительность`)

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    },
    {
        $lookup: {
            from: 'users',
            localField: '_id',
            foreignField: '_id',
            as: 'author'
        }
    },
    { $unwind: '$author' },
    {
        $project: {
            _id: 0,
            avg_duration: 1,
            author_fullname: '$author.fullname'
        }
    }
])
```

**Задача. Вывести `имя` одного автора треков, у которого самая высокая средняя продолжительность**

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    },
    { $sort: { avg_duration: -1 } },
    { $limit: 1 },
    {
        $lookup: {
            from: 'users',
            localField: '_id',
            foreignField: '_id',
            as: 'author'
        }
    },
    { $unwind: '$author' },
    {
        $project: {
            _id: 0,
            author_fullname: '$author.fullname'
        }
    }
])
```

**Задача. Вывести среднее значение по всем реакциям**

```jsx
db.reactions.aggregate([
    {
        $group: {
            _id: null,
            avg_reaction: { $avg: '$value' }
        }
    }
])
```

**Задача. Вывести данные о треках**

(проекция: `название_трека`, `рейтинг_трека`)

```jsx
db.reactions.aggregate([
    {
        $group: {
            _id: '$track_id',
            rating: { $avg: '$value' }
        }
    },
    {
        $lookup: {
            from: 'tracks',
            localField: '_id',
            foreignField: '_id',
            as: 'track'
        }
    },
    { $unwind: '$track' },
    {
        $project: {
            _id: 0,
            rating: 1,
            track_title: '$track.title'
        }
    }
])
```

**Задача. Вывести страну, в которой самый высокий рейтинг треков**

(проекция: `страна`, `ср_оценка`)

```jsx
db.reactions.aggregate([
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'user'
        }
    },
    {
        $unwind: '$user'
    },
    {
        $group: {
            _id: '$user.country',
            rating: { $avg: '$value' }
        }
    },
    {
        $sort: { rating: -1 }
    },
    {
        $limit: 1
    },
    {
        $project: {
            country: '$_id',
            rating: 1,
            _id: 0
        }
    }
])
```

## Основные сущности БД “поликлиника”

- `сотрудники`
- `клиенты`
- `услуги`
- `заказы`
- `расписание`