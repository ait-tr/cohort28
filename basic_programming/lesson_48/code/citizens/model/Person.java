package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person implements Comparable<Person>{

    private int id;
    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    public Person(int id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // getAge
    public int getAge(){
        int age = 0;
        //TODO - вычислить текущий возраст персоны, зная ее день рождения
        LocalDate currentDate = LocalDate.now();
        age = (int) ChronoUnit.YEARS.between(birthDate, currentDate);
        return age;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", age= " + getAge() +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.id, o.id); // выше у нас id с меньшим значением
    }
}
