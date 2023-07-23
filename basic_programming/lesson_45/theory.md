# Моделирование предметной области

* Композиция/агрегирование/ассоциация - объекты одних классов связаны с объектами других классов
* Рассмотрим пример такой задачи:

```
Смоделировать предметную область "Автопарк"
Есть автобусы, водители, пассажиры
```

* У автобуса есть один водитель и множество пассажиров.
* Пассажир может быть в одном автобусе
* Водитель тоже может быть в одном автобусе
* Связь между автобусом и водителем `один-к-одному`/`one-to-one` (1:1), означает, что у одного автобуса один водитель и у водителя один автобус
* Связь между автобусом и пассажирами `один-ко-многим`/`one-to-many` (1:*), означает что у одного автобуса множество пассажиров

![image](https://raw.githubusercontent.com/ait-tr/cohort28/main/basic_programming/lesson_45/img/1.png)

## Заметки

* `Объектная переменная` - переменная ссылочного типа (класса), которая представляет собой указатель на объект. (содержит ссылку на объект в памяти)

![image](https://raw.githubusercontent.com/ait-tr/cohort28/main/basic_programming/lesson_45/img/2.png)