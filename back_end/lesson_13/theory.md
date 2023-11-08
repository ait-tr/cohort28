### Принципы программирования

1. DRY - основополагающий принцип разработки
   Don't repeat yourself - НЕ ПОВТОРЯЙСЯ!

SSOT - single source of truth

2. KISS -
- Keep it simple, stupid!
- Keep it stupid simple!

3. SOLID

•	Single responsibility principle (принцип единственной ответственности).
•	Open-closed principle (принцип открытости/закрытости).
•	Liskov substitution principle (принцип подстановки Лисков).
•	Interface segregation principle (принцип разделения интерфейса).
•	Dependency inversion principle (принцип инверсии зависимостей).

SRP:
- getUserAndRelatedBooks -> getUser и getUserBooks
  getUserBooks(getUser)


OCP:

public fromTown(){
String[] towns = {"Berlin", "London", "Paris"};
... осуществляет поиск города по критериям из массива
} - ТАК НЕ ДЕЛАТЬ!!!!

DIP:

    Module View    <  ----------     Module Model


YAGNI - You ain't gonna need it - Вам это не понадобится

Agile-методология

BDUF - Big design up front






