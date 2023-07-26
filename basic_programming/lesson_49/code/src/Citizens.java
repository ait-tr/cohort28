package ait.citizens.dao;

import ait.citizens.model.Person;

public interface Citizens {
    boolean add(Person person);

    boolean remove(int id);

    Person find(int id);

    Iterable<Person> find(int minAge, int maxAge);

    Iterable<Person> find(String lastName);

    Iterable<Person> getAllPersonsSortedById();

    Iterable<Person> getAllPersonsSortedByLastName();

    Iterable<Person> getAllPersonsSortedByAge();

    int size();
}
