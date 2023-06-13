package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerAppl {
    public static void main(String[] args) {
        double x = 3.;
        int y = (int) x;

        Computer[] computers = new Computer[3];

        computers[0] = new Computer("i5", 12, 512, "HP");
        computers[1] = new Laptop("i7", 16, 512, "Asus", 2.5, 2.1);
        computers[2] = new Smartphone("Snapdragon", 8, 128, "Samsung", 24,
                0.15, 123456789098l);
        printArray(computers);
        int total = getTotalSSDCapacity(computers);
        System.out.println("Total ssd capacity = " + total);
        if (computers[1] instanceof Laptop) {
            Laptop laptop = (Laptop) computers[1];
            System.out.println(laptop.getHours());
            laptop.setRam(20);
            System.out.println(laptop);
            System.out.println(computers[1]);
        }
        if(computers[2] instanceof Laptop) {
            Laptop smartphone = (Laptop) computers[2];
            System.out.println(smartphone.getHours());
//          System.out.println(smartphone.getImei());
        }
        if(computers[0] instanceof Laptop) {
            Laptop computer = (Laptop) computers[0];
            System.out.println(computer.getHours());
        }
        double totalHours = getTotalHours(computers);
        System.out.println("Total hours = " + totalHours);
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

    public static double getTotalHours(Computer[] arr) {
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] instanceof Laptop){
                Laptop laptop = (Laptop) arr[i];
                res += laptop.getHours(); //res = res + laptop.getHours();
            }
        }
        return res;
    }
}
