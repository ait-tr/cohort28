package lesson13.dryExample;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Ruslan");

        List<Person> people = new ArrayList<>();
        people.add(person);

        PersonRepository repository = new PersonRepository(people);


        Person person2 = new Person("John");
        Services services = new Services(repository);
        services.addPerson(person2);

    }
}
