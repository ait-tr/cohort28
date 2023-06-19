package ait.computer.dao;

import ait.computer.model.Computer;

public class ComputerShop {
    private Computer[] computers;
    private int size;

    public ComputerShop(int capacity) {
        computers = new Computer[capacity];
    }

    public boolean addComputer(Computer computer) {
        if (size == computers.length || findComputer(computer.getBarCode()) != null) {
            return false;
        }
        computers[size] = computer;
        size++;
        return true;
    }

    public void printComputers() {
        for (int i = 0; i < size; i++) {
            System.out.println(computers[i]);
        }
        System.out.println("=============================================");
    }

    public int getSize() {
        return size;
    }

    public Computer findComputer(long barCode) {
        for (int i = 0; i < size; i++) {
            if (computers[i].getBarCode() == barCode) {
                return computers[i];
            }
        }
        return null;
    }

    public Computer removeComputer(long barCode) {
        Computer victim = null;
        for (int i = 0; i < size; i++) {
            if (computers[i].getBarCode() == barCode){
                victim = computers[i];
                computers[i] = computers[size - 1];
                computers[size - 1] = null;
                size--;
                break;
            }
        }
        return victim;
    }
}
