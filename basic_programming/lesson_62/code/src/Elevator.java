package ait.elevator.model;

public class Elevator {
    String name;
    int currentVolume;

    public Elevator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(int portion) {
        currentVolume = currentVolume + portion;
    }

    @Override
    public String toString() {
        return "Elevator " + name + " has " + currentVolume + " tonn";
    }
}
