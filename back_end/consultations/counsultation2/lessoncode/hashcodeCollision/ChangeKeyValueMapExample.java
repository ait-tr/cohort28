package hashcodeCollision;

import java.util.HashMap;
import java.util.Map;

public class ChangeKeyValueMapExample {
    public static void main(String[] args) {
        Map<Person, Cat> personCatMap = new HashMap<>();

        personCatMap.put(new Person("Petya" ), new Cat("Barsik"));

        Person person = new Person("Vasya");
        System.out.println(" Vasya hashCode = " + person.hashCode());
        personCatMap.put(person, new Cat("Murzik"));

        System.out.println(personCatMap);

        person.name = "Ruslan";

        System.out.println("Ruslan (old Vasya) hash = " + person.hashCode());
        System.out.println(personCatMap);

        Cat cat = personCatMap.get(person);

        System.out.println(cat);

        Person personVasya = new Person("Vasya");

        System.out.println("Vasya (new Vasya) hash = " + personVasya.hashCode());

        Cat cat2 = personCatMap.get(personVasya);
        System.out.println(cat2);

        person.name = "Vasya";
        System.out.println(personCatMap);
        Cat cat3 = personCatMap.get(person);
        System.out.println(cat3);


    }
}
