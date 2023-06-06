package ait.employee.model;

public class Employee {
    private int id;
    private String firstName;

    private String lastName;
    private double salary;
    private boolean gender;

    public Employee(int id, String firstName, String lastName, double salary, boolean gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary);
        this.gender = gender;
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

    public double getSalary() {
        return salary;
    }

    public boolean isGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        if (salary > this.salary) {
            this.salary = salary;
        }
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void display() {
        System.out.println("ID: " + id + ", first name: " + firstName + ", last name: "
                + lastName + ", salary: " + salary + ", gender: " + (gender ? "male" : "female"));
    }
}
