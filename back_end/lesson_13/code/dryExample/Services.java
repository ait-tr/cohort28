package lesson13.dryExample;

public class Services {

    PersonRepository repository;

    public Services(PersonRepository repository) {
        this.repository = repository;
    }

    public void addPerson(Person person) {
        repository.addPerson(person);
    }
}
