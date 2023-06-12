package ait.computer.model;

import ait.computer.model.Computer;

public class Laptop extends Computer {
    double hours;
    protected double weight;

    public Laptop(String cpu, int ram, int ssd, String brand, double hours, double weight) {
        super(cpu, ram, ssd, brand);
        this.hours = hours;
        this.weight = weight;
    }

    public double getHours() {
        return hours;
    }

    public double getWeight() {
        return weight;
    }

    public void display() {
        super.display();
        System.out.print(", Hours: " + hours + ", Weight: " + weight);
    }

}
