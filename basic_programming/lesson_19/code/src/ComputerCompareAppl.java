package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

import java.util.Scanner;

public class ComputerCompareAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String i5 = new String("i5");
        Computer computer1 = new Computer(i5, 12, 512, "HP");
        System.out.println("Enter CPU: ");
        String cpu = scanner.next();
        System.out.println("Enter RAM: ");
        int ram = scanner.nextInt();
        System.out.println("Enter SSD: ");
        int ssd = scanner.nextInt();
        System.out.println("Enter brand: ");
        String brand = scanner.next();
        Computer computer2 = new Computer(cpu, ram, ssd, brand);
        Computer computer3 = new Computer("i5", 12, 512, "HP");
        System.out.println(computer1);
        System.out.println(computer2);
        System.out.println(computer3);
        System.out.println(computer1.equals(computer2));
        System.out.println(computer1.equals(computer3));
        System.out.println(computer3.equals(computer2));
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
