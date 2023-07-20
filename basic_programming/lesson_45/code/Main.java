import autopark.Bus;
import autopark.Driver;
import autopark.Passenger;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus("22A");
        Bus bus2 = new Bus("23A");
        Driver roman = new Driver("Roman", "Popov", 12);
        roman.setBus(bus);

        Passenger oksana = new Passenger("Oksana");
        Passenger lena = new Passenger("Lena");
        Passenger timur = new Passenger("Timur");
        Passenger serhii = new Passenger("Serhii");
        Passenger volodymyr = new Passenger("Volodymyr");
        Passenger vrendy = new Passenger("Вредный");

        oksana.goToBus(bus);
        lena.goToBus(bus);
        timur.goToBus(bus);
        serhii.goToBus(bus);
        volodymyr.goToBus(bus);

        roman.drive();
        vrendy.goToBus(bus);
        vrendy.sayAbout();
        volodymyr.goToBus(bus2);


//        Driver marsel = new Driver("Marsel", "Sidikov", 2);
//        Driver roman = new Driver("Roman", "Popov", 12);
//        marsel.setBus(bus);
//        marsel.drive();
//        marsel.stopDrive();
//        roman.setBus(bus);
//        roman.drive();
    }
}
