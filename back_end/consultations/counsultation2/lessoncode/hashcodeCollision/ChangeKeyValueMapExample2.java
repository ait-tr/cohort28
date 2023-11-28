package hashcodeCollision;

import java.util.HashMap;
import java.util.Map;

public class ChangeKeyValueMapExample2 {
    public static void main(String[] args) {
        Map<Person, Cat> personCatMap = new HashMap<>();

        personCatMap.put(new Person("Petya" ), new Cat("Barsik"));

        Person person = new Person("Vasya");
        System.out.println(" Vasya hashCode = " + person.hashCode());
        Cat murzik = new Cat("Murzik");
        personCatMap.put(person, murzik);

        System.out.println(personCatMap);

        person.name = "Ruslan";

        System.out.println("Ruslan (old Vasya) hash = " + person.hashCode());
        System.out.println(personCatMap);

        Cat cat = personCatMap.get(person);

        System.out.println(cat);

        System.out.println("=====================");

        Person person1 = new Person("Name1");
        Person person2 = new Person("Name2");
        Person person3 = new Person("Name3");
        Person person4 = new Person("Name4");
        Person person5 = new Person("Name5");
        Person person6 = new Person("Name6");
        Person person7 = new Person("Name7");
        Person person8 = new Person("Name8");
        Person person9 = new Person("Name9");
        Person person10 = new Person("Name10");
        Person person11 = new Person("Name11");
        Person person12 = new Person("Name12");
        Person person13 = new Person("Name13");
        Person person14 = new Person("Name14");
        Person person15 = new Person("Name15");

        Cat newCat = new Cat("Dexter");

        personCatMap.put(person1, newCat);
        personCatMap.put(person2, newCat);
        personCatMap.put(person3, newCat);
        personCatMap.put(person4, newCat);
        personCatMap.put(person5, newCat);
        personCatMap.put(person6, newCat);
        personCatMap.put(person7, newCat);
        personCatMap.put(person8, newCat);
        personCatMap.put(person9, newCat);
        personCatMap.put(person10, newCat);
        personCatMap.put(person11, newCat);
        personCatMap.put(person12, newCat);
        personCatMap.put(person13, newCat);
        personCatMap.put(person14, newCat);
        personCatMap.put(person15, newCat);

        System.out.println(personCatMap);

        cat = personCatMap.get(person);
        System.out.println(person.hashCode());

        System.out.println(cat);

        System.out.println(getKey(personCatMap, murzik));


    }

    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
