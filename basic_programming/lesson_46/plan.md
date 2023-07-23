# План урока

1. Актуальные вопросы

Задача о поиске дубликата.
Заполните массив последовательными натуральными числами от 1 до 100.
Задумайте случайное натуральное число в интервале от 1 до 100 и вставьте его в массив
на случайное место. Теперь в массиве есть пара дубликатов.
Найдите дубликат наименее затратным по вычислениям способом.

Задача про поиск уникального дубликата
- 1, 2, 3, 4, 5, .. , 97, 98, 99, 100 

Вар. 1:
индекс совпадает с самим элементом или отличается от него на 1 
можно найти элемент, у которого индекс не совпадает с самим элементом.

Вар. 2:
1 + 99 = 100
2 + 98 = 100 
3 + 97 = 100 

100 * 50 = 5 000 

Шаг 1.
Узнаем сумму элементов "старого" массива от 1 до 100, циклом for ИЛИ
(1 + 100) * lenght / 2 (решение имени Эйлера )

Шаг 2. 
Узнаем сумму нового массива, в котором на 1 элемент (задуманный) больше циклом for

Шаг 3. 
вычитаем из суммы старого массива сумму нового.
Разница = дубликат.

Вар. 3 
Исключающее ИЛИ 

2. Повторение и накопление знаний
- диаграммы 
- список ТИПОВЫХ тестов для CRUD-операций
- типовые мини-алгоритмы для CRUD - операций

3. Закончить имплементацию Company на ArrayList
