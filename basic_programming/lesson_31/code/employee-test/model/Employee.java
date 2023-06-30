package model;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    long id;
    String name; // имя
    int age; // возраст
    int experience; // стаж работы

    //конструктор на все поля
    public Employee(long id, String name, int age, int experience) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    //пустой конструктор
    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employee" + "id=" + id + ", name='" + name + ", age=" + age + ", experience=" + experience ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id; // находим сотрудника по табельному номеру
    }

    @Override
    public int compareTo(Employee o) {
        if (this.age == o.age) {
            return 0;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 1;
        }
    }
}
