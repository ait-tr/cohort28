package ait.computer.model;

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

    @Override
    public String toString() {
        return super.toString() + ", Hours: " + hours + ", Weight: " + weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Laptop)) {
            return false;
        }
        Laptop other = (Laptop) obj;
        return super.equals(other) && hours == other.hours && weight == other.weight;
    }
}
