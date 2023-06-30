package model;

public class Manager extends Employee{
    private double baseSalary;
    private int grade;
    private int hours;

    public Manager(long id, String name, int age, int experience, double baseSalary, int grade, int hours) {
        super(id, name, age, experience);
        this.baseSalary = baseSalary;
        this.grade = grade;
        this.hours = hours;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double calcSalary() {
        double salary = baseSalary + grade * hours;
        return salary;
    }

}
