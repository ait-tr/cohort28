package lesson13.dryExample;

public class Services2 {

    PersonRepository repository;

    Services services;

    public Services2(PersonRepository repository, Services services) {
        this.repository = repository;
        this.services = services;
    }

    public void addPersonWithConditions(Person person) {
        repository.addPerson(person);
    }

    public void addPersonWithConditionsUseServices(Person person) {
        services.addPerson(person);
    }
}
