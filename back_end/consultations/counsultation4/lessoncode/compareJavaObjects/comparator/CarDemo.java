package compareJavaObjects.comparator;

import java.util.Set;
import java.util.TreeSet;

public class CarDemo {
    public static void main(String[] args) {
        CarComparator carComparator = new CarComparator();
        Set<Car> garage = new TreeSet<>(carComparator);

        garage.add(new Car("Mercedes"));
        garage.add(new Car("BMW"));
        garage.add(new Car("Toyota"));
        garage.add(new Car("Ford"));
        garage.add(new Car("Volvo"));

        System.out.println(garage);

    }
}
