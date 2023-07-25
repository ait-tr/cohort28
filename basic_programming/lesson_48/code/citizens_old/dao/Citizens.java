package dao;

import model.Person;

public interface Citizens {

    //добавляем персону
    boolean add(Person person);
    //удаляем персону по id
    boolean remove(int id);
    //ищем персону по id
    Person find(int id);
    // поиск списка в диапазоне возраста
    Iterable<Person> find(int minAge, int maxAge);
    // поиск по фамилии
    Iterable<Person> find(String lastName);
    // выгрузка всех граждан, отсортированных по id
    Iterable<Person> getAllPersonsSortedById ();
    // выгрузка всех граждан, отсортированных по возрасту
    Iterable<Person> getAllPersonsSortedByAge ();
    // выгрузка всех граждан, отсортированных по фамилии по алфавиту
    Iterable<Person> getAllPersonsSortedByLastName ();
    // определяет кол-во граждан
    int size();
}
