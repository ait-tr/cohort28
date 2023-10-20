## Ссылки

- [пример схемы БД `online_music`](https://dbdiagram.io/d/653179bfffbf5169f00dbe75)

![Screenshot from 2023-10-20 11-46-42.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/d79368c2-51b2-4fdc-9bfd-b14778dac2ab/Screenshot_from_2023-10-20_11-46-42.png)

**Примеры запросов**

```jsx
// Вывести треки с продолжительностью от 5 мин
db.tracks.find(
    { duration_secs: { $gte: 5 * 60 } }
)

// Вывести юзеров из USA
db.users.find(
    { country: 'USA' } // filter
)

// Вывести страну юзера 1
db.users.findOne(
    { _id: 1 },
    { country: 1, _id: 0 }
)
```

## Подсчет ко-ва документов / метод `countDocuments()`

- один аргумент
    - `фильтр`
- возвращает `целое число` - ко-во совпадений

**Пример**

```jsx
db.users.countDocuments(
    { country: 'Germany' }
)
```

**Пример. Авторизация (аутентификация) юзера**

```jsx
db.users.countDocuments(
    {
        email: email,
        password: password,
        is_blocked: { $ne: true }
    }
)
```

**Задача. Вывести ко-во заблокированных юзеров не из `China`**

```jsx
db.users.countDocuments(
    {
        country: { $ne: 'China' },
        is_blocked: true
    }
)
```

**Задача. Вывести ко-во треков с продолжительностью до `30` мин (вкл.)**

```jsx
db.tracks.countDocuments(
    { duration_secs: { $lte: 30 * 60 } }
)
```

**Пример. Использование `$in`**

```jsx
// Вывести юзеров из `Germany`, `France`
db.users.find(
    {
        country: { $in: ['Germany', 'France'] }
    }
)
```

**Пример. Использование `$nin` (not in)**

```jsx
db.users.find(
    {
        country: { $nin: ['USA', 'China'] }
    }
)
```

**Задача. Вывести названия треков `1` и `3`**

```jsx
db.tracks.find(
    { _id: { $in: [1, 3] } },
    { title: 1, _id: 0 }
)
```

## Базовые операторы модификации (`updateOne` / `updateMany()`)

`$set` установить поля

`$unset` удалить (снять) поля

`$inc` инкремент полей (увеличить/уменьшить)

`$mul` умножение

**Пример. Заблокировать юзеров из `France`**

```jsx
db.users.updateMany(
    { country: 'France' }, // filter
    { // action
        $set: {
            is_blocked: true
        }
    }
)
```

**Пример. Вывести заблокированных юзеров**

```jsx
db.users.find(
    { is_blocked: true }
)
```

**Задача. Вывести имена всех заблокированных юзеров**

```jsx
db.users.find(
    { is_blocked: true }, // filter
    { fullname: 1, _id: 0 } // projection
)
```

**Задача. Вывести ко-во незаблокированных юзеров не из `Germany`**

```jsx
db.users.countDocuments(
    {
        is_blocked: { $ne: true },
        country: { $ne: 'Germany' }
    }
)
```

**Пример. Разблокировать всех юзеров**

```jsx
db.users.updateMany(
    {},
    {
        $unset: {
            is_blocked: null
        }
    }
)
```

**Пример. Запрос на модификацию**

```jsx
db.users.updateOne(
    { _id: 1 },
    { // action
        $set: { email: 'user@example.org' },
        $unset: { is_blocked: null }
    }
)
```

**Пример. Увеличить баланс всех юзеров на `20` EUR**

```jsx
db.users.updateMany(
    {},
    {
        $inc: { balance: 20 }
    }
)
```

**Задача. Уменьшить баланс юзеров из `France` на `20` EUR**

```jsx
db.users.updateMany(
    { country: 'France' },
    { $inc: { balance: -20 } }
)
```

**Задача. Для всех заблокированных юзеров из `USA` с балансом до `1000` EUR необходимо:**

- их разблокировать
- увеличить баланс на `100` EUR

```jsx
db.users.updateMany(
    {
        country: 'USA',
        is_blocked: true,
        balance: { $lte: 1000 }
    },
    {
        $unset: { is_blocked: null },
        $inc: { balance: 100 }
    }
)
```

**Пример. Увеличить баланс всех юзеров на `15%`**

```jsx
db.users.updateMany(
    {},
    {
        $mul: { balance: 1.15 }
    }
)
```

**Задача. Уменьшить баланс всех незаблокированных юзеров с положительным балансом на `1%`**

```jsx
db.users.updateMany(
    {
        is_blocked: { $ne: true },
        balance: { $gt: 0 }
    },
    {
        $mul: { balance: .99 }
    }
)
```

**Задача. Вывести имена и страны незаблокированных юзеров с балансом до `10000` EUR (вкл.)**

```jsx
db.users.find(
    {
        is_blocked: { $ne: true },
        balance: { $lte: 10000 }
    },
    {
        fullname: 1,
        country: 1,
        _id: 0
    }
)
```

**Задача. Разблокировать юзера `4` и уменьшить его баланс на `10` EUR**

```jsx
db.users.updateOne(
    { _id: 4 },
    {
        $unset: { is_blocked: null },
        $inc: { balance: -10 }
    }
)
```

## Работа с массивами в MongoDB

**Базовые операторы работы с массивами**

- `$push` добавить значение в **массив**
- `$pull` удалить значение из массива
- `$pullAll` удалить несколько значений из массива
- `$addToSet` добавить значение в **множество**
- `$each` добавить список значений в массив или множество

**Пример. Добавить тег всем трекам**

```jsx
db.tracks.updateMany(
    {}, // filter
    { // action
        $push: { tags: 'super' }
    }
)
```

**Пример. Удалить тег из треков**

```jsx
db.tracks.updateMany(
    {}, // filter
    { // action
        $pull: { tags: 'super' }
    }
)
```

**Пример. Добавить элемент в множество**

```jsx
db.tracks.updateMany(
    {},
    {
        $addToSet: { tags: 'super' }
    }
)
```

**Пример. Добавить несколько элементов в множество**

```jsx
db.tracks.updateMany(
    {},
    {
        $addToSet: {
            tags: { $each: ['mega', 'new'] }
        }
    }
)
```

**Пример. Удалить несколько тегов (элементов массива)**

```jsx
db.tracks.updateMany(
    {}, // filter
    { // action
        $pullAll: {
            tags: ['super', 'mega']
        }
    }
)
```

**Задача. Добавить к треку `2` тег `test`**

```jsx
db.tracks.updateOne(
    { _id: 2 },
    {
        $addToSet: {
            tags: 'test'
        }
    }
)
```

**Пример. Поиск документов по тегу (тегам)**

```jsx
db.tracks.find(
    {
        tags: 'test'
    }
)

db.tracks.find(
    {
        tags: { $in: ['test', 'new'] }
    }
)

db.tracks.find(
    {
        tags: { $all: ['test', 'new'] }
    }
)
```

**Задача. Вывести все треки с тегом `super` и продолжительностью до одного часа**

```jsx
db.tracks.find(
    {
        tags: 'super',
        duration_secs: { $lte: 60 * 60 }
    }
)
```

## Схема БД “чат-поддержки”

**Базовые сущности**

- `юзеры` (клиенты и сотрудники)
- `сообщения`
- `чаты`
- `реакции_на_сообщения` (шкала от `1` до `5`)