package ait.elevator.task;

import ait.elevator.model.Elevator;

public class Truck implements Runnable {

    int nRaces;
    int capacity;
    Elevator elevator;

    public Truck(int nRaces, int capacity, Elevator elevator) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            elevator.add(capacity);
        }
    }
}
