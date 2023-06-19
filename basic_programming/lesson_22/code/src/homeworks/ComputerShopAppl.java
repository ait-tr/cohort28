package ait.computer;

import ait.computer.dao.ComputerShop;
import ait.computer.model.Computer;
import ait.computer.model.Laptop;
import ait.computer.model.Smartphone;

public class ComputerShopAppl {
    public static void main(String[] args) {
        ComputerShop shop = new ComputerShop(10);
        shop.addComputer(new Computer(1, "i5", 12, 512, "HP"));
        shop.addComputer(new Laptop(2, "i7", 16, 512, "Asus", 2.5, 2.1));
        System.out.println(shop.getSize());
        shop.addComputer(new Smartphone(3,"Snapdragon", 8, 128, "Samsung", 24,
                0.15, 123456789098l));
        System.out.println(shop.getSize());
        System.out.println(shop.addComputer(new Computer(1, "i5", 12, 512, "HP")));
        System.out.println(shop.getSize());
        shop.printComputers();
        Computer computer = shop.findComputer(3);
        System.out.println(computer);
        computer = shop.findComputer(4);
        System.out.println(computer);
        computer = shop.removeComputer(3);
        System.out.println(shop.getSize());
        System.out.println(computer);
        computer = shop.findComputer(3);
        System.out.println(computer);
    }


}
