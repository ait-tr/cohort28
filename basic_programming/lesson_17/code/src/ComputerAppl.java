package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        Computer[] computers = new Computer[3];

        computers[0] = new Computer("i5", 12, 512, "HP");
        computers[1] = new Laptop("i7", 16, 512, "Asus", 2.5, 2.1);
        computers[2] = new Smartphone("Snapdragon", 8, 128, "Samsung", 24,
                0.15, 123456789098l);
        printArray(computers);
        int total = getTotalSSDCapacity(computers);
        System.out.println("Total ssd capacity = " + total);
//        System.out.println(computers[1].getHours());
//        System.out.println(computers[2].getHours());
    }

    public static int getTotalSSDCapacity(Computer[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res + arr[i].getSsd();
        }
        return res;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
