package ait.optional.person;

import ait.optional.person.model.Person;
import ait.optional.person.model.PersonNotFoundException;

import java.util.Optional;

public class PersonOptionalAppl {
    public static void main(String[] args) {
        Person[] persons = {new Person("John", 28), new Person("Mary", 19), new Person("Peter", 25)};
//        Person person = findPersonByAge(persons, 28);
//        if (person != null) {
//            System.out.println(person.getName());
//        }

        Optional<Person> optional = findPersonByAge(persons, 23);

//        if(optional.isPresent()){
//            Person person = optional.get();
//            System.out.println(person.getName());
//        }

//        optional.ifPresent(p -> System.out.println(p.getName()));

//        Person person = optional.orElse(new Person("Anonymous", -1));

//        Person person = optional.orElseGet(() -> new Person("Anonymous", -1));

        Person person = optional.orElseThrow(() -> new PersonNotFoundException());

        System.out.println(person.getName());


    }

    public static Optional<Person> findPersonByAge(Person[] persons, int age) {
        Person person = null;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge() == age) {
                person = persons[i];
                break;
            }
        }
        return Optional.ofNullable(person);
    }

}
