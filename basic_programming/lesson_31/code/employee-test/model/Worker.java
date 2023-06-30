package model;

public class Worker extends Employee{
    private double rate;
    private int hours;

    public Worker(long id, String name, int age, int experience, double rate, int hours) {
        super(id, name, age, experience);
        this.rate = rate;
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double calcSalary() {
        double salary = hours * rate;
        return salary;
    }

}
