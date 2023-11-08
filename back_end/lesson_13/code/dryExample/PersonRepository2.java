package lesson13.dryExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonRepository2 {

    List<Person> repository = new LinkedList<>();

    public PersonRepository2(List<Person> repository) {
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
