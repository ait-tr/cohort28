package ait.elevator.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Elevator {
    String name;
    AtomicInteger currentVolume = new AtomicInteger(0);

    public Elevator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentVolume() {
        return currentVolume.get();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(int portion) {
        currentVolume.addAndGet(portion);
    }

    @Override
    public String toString() {
        return "Elevator " + name + " has " + currentVolume.get() + " tonn";
    }
}
