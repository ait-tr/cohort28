package dao;

import model.Person;

import java.util.Comparator;
import java.util.List;

public class CitizensImpl implements Citizens{
    // поля
    private List<Person> idList; // список граждан по id

    private List<Person> lastNameList; // список граждан по фамилиям

    private List<Person> ageList; // список граждан по годам

    private static Comparator<Person> lastNameComparator;
    private static Comparator<Person> ageComparator;

    // конструкторы
    // пустой конструктор
    public CitizensImpl() {
    }

    public CitizensImpl(List<Person> citizens) {

    }

    // методы
    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
