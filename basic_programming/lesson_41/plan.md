# Lesson plan
## Lesson 41, 14 of July 2023

### Let's remember the topics of the week

1. Java Time API, LocalDate, LocalDateTime
   Album Application, method getPhotoBetweenDate(From, To)
- what was difficult?

2. Exceptions, try-catch
   see theory

3.InterfaceIterator<T>
- why is it needed?
- the example that was with the string

4. Complexity - evaluation of the complexity of the algorithm
   What are the values for this difficulty?
   For which algorithms do we know the complexity estimate?

5.ArrayList
- what is it and why?
- what are the main features of ArrayList?
- ArrayList vs Array

__________________________

# План урока
## Урок 41, 14 июля 2023 г.

### Вспоминаем темы недели

1. Java Time API, LocalDate, LocalDateTime
Album Application, method getPhotoBetweenDate(From, To)
- что было сложного? - работа с датами, применяем бинарный для поиска необходимых индексов фотографий

2. Exceptions, try catch - исключения/непредвиденная ситуация, 
try catch = пытаться ловить 
см. теория

3. Interface Iterator<T> 
- зачем это нужно?

Итератор - это интерфейс, значит в нем есть методы. Для Итератора это три метода:
- has next возвращает тип boolean 
- next возвращает элемент коллекции и сдвигает "указатель, курсор"
- remove удаляет элемент коллекции и сдвигает "указатель, курсор"

"Коллекционер" смотрит коллекцию.
Очень востребовано тогда, когда в коллекции нет индексов, но есть предметы.

- пример, который был со строкой иллюстрирует, как можно перебирать в строке символы (Character) 
и мы удалили 'e' из коллекции.

4. Complexity - оценка сложности алгоритма
Какие бывают значения этой сложности?
Для каких алгоритмов мы знаем оценку сложности?

5. ArrayList 
- что это такое и для чего?
- какие основные фичи у ArrayList?
- ArrayList vs Array