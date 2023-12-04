package compareJavaObjects.comparator;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        String nameCar1 = car1.getModel();
        String nameCar2 = car2.getModel();

        return nameCar1.compareTo(nameCar2);
    }
}
