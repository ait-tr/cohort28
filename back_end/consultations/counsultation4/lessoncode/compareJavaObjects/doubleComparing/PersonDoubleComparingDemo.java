package compareJavaObjects.doubleComparing;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PersonDoubleComparingDemo {
    public static void main(String[] args) {
        Comparator<Person> personComparator = new PersonNameComparator().thenComparing(new PersonAgeComparator());

        Set<Person> people = new TreeSet<>(personComparator);

        people.add(new Person("Alex", 21));
        people.add(new Person("Alex", 19));
        people.add(new Person("Alexander", 32));
        people.add(new Person("Bob", 18));
        people.add(new Person("Alex", 18));
        people.add(new Person("Georg", 45));
        people.add(new Person("Olga", 18));

        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge());
        }

    }
}
