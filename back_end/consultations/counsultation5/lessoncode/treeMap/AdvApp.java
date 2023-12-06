package treeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class AdvApp {
    public static void main(String[] args) {
        TreeMap<Person, Integer> treeMap = new TreeMap<>(Comparator.comparingInt(person -> person.getAge()));

        treeMap.put(new Person("Ruslan", "Simonov", 17), 0);
        treeMap.put(new Person("John", "Smith", 67), 0);
        treeMap.put(new Person("Victor", "Petrov", 32), 0);
        treeMap.put(new Person("Sergey", "Ivanov", 14), 0);
        treeMap.put(new Person("Rabindranat", "Tagor", 121), 0);

        Person firstAdultPerson = treeMap.navigableKeySet().stream()
                .filter(person -> person.getAge() > 18)
                .findFirst()
                .get();

        Map<Person, Integer> youngPersonMap = treeMap.headMap(firstAdultPerson, false);
        Map<Person, Integer> adultPersonMap = treeMap.tailMap(firstAdultPerson, true);

        showMap(youngPersonMap, "Наши молодые зрители");

        showMap(adultPersonMap, "Наши взрослые зрители");

    }

    public static void showMap(Map<Person, Integer> map, String message){
        System.out.println(message);
        for (Person person : map.keySet()){
            System.out.println("Person " + person.getFirstName() + " Age: " + person.getAge());
        }
    }
}
