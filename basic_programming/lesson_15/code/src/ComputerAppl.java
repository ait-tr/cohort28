package ait.computer;

import ait.computer.model.Computer;
import ait.computer.model.Laptop;

public class ComputerAppl {
    public static void main(String[] args) {
        Computer comp1 = new Computer("i5", 12, 512, "HP");
        Laptop lap1 = new Laptop("i7", 16, 512, "Asus", 2.5, 2.1);
        comp1.display();
        System.out.println();
        lap1.display();
        System.out.println();

    }
}
