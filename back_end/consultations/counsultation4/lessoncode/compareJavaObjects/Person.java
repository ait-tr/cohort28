package compareJavaObjects;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String firstName;
    private String secondName;

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public int compareTo(Person personForComparing) {
        int compareResult = secondName.compareTo(personForComparing.getSecondName());
        if (compareResult == 0) {
            compareResult = firstName.compareTo(personForComparing.getFirstName());
        }
        return compareResult;
    }
}
