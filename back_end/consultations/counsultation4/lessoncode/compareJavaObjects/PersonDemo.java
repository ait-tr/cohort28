package compareJavaObjects;

import java.util.Set;
import java.util.TreeSet;

public class PersonDemo {
    public static void main(String[] args) {
        Set<Person> ourTeam = new TreeSet<>();

        ourTeam.add(new Person("Johnatan", "Watson"));
        ourTeam.add(new Person("Zigmund", "Freid"));
        ourTeam.add(new Person("Boris", "Baker"));
        ourTeam.add(new Person("Alex", "King"));
        ourTeam.add(new Person("Elena", "Trojan"));
        ourTeam.add(new Person("John", "Watson"));

        System.out.println(ourTeam);

    }
}
