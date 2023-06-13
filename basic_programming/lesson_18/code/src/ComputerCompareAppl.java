package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerCompareAppl {
    public static void main(String[] args) {
        Computer[] computers = new Computer[3];
        computers[0] = new Computer("i5", 12, 512, "HP");
        computers[1] = new Laptop("i7", 16, 512, "Asus", 2.5, 2.1);
        computers[2] = new Smartphone("Snapdragon", 8, 128, "Samsung", 24,
                0.15, 123456789098l);
        printArray(computers);
        System.out.println("==================================");
        Computer computer = new Computer("i5", 12, 512, "HP");
        boolean checker = computer.equals(computers[0]);
        System.out.println("Computers is " + checker);
        Laptop laptop = new Laptop("i7", 16, 512, "Asus", 2.5, 2.1);
        checker = laptop.equals(computers[1]);
        System.out.println("Laptops is " + checker);
        Smartphone smartphone = new Smartphone("Snapdragon", 8, 128, "Samsung", 24,
                0.15, 123456789090l);
        checker = smartphone.equals(computers[2]);
        System.out.println("Smartphones is " + checker);
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
