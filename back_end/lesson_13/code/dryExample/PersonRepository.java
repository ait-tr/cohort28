package lesson13.dryExample;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    List<Person> repository = new ArrayList<>();

    public PersonRepository(List<Person> repository) {
        this.repository = repository;
    }

    public List<Person> getRepository() {
        return repository;
    }

    public void setRepository(List<Person> repository) {
        this.repository = repository;
    }

    public void addPerson(Person person) {
        repository.add(person);
    }
}
