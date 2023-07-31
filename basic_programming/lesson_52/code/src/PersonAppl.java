package ait.set.person.model;

import java.util.HashSet;
import java.util.Set;

public class PersonAppl {
    public static void main(String[] args) {
        Person john = new Person(1,"John", "Smith");
        Person mary = new Person(2, "Mary", "Jackson");
        System.out.println(mary.hashCode());
        Set<Person> persons = new HashSet<>();
        persons.add(john);
        persons.add(mary);
        System.out.println(persons.contains(john));
        System.out.println(persons.contains(mary));
        System.out.println("=========");
        mary.setLastName("Smith");
        System.out.println(mary.hashCode());
        System.out.println(persons.contains(john));
        System.out.println(persons.contains(mary));
        System.out.println(persons.size());
        persons.forEach(s -> System.out.println(s));
    }
}
