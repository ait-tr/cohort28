package exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;

public class DeliveryExample {
    public static void main(String[] args) {

        // создаем Exchanger

        Exchanger<List<String>> exchanger = new Exchanger<>();

        // создаем список товаров
        List<String> goods1 = List.of(
                new String("Item1"),
                new String("Item2"),
                new String("Item3")
        );
        List<String> goods2 = List.of(
                new String("Item4"),
                new String("Item5"),
                new String("Item6")
        );

        Truck truck1 = new Truck(1,"Factory A", "Warehouse C", goods1, exchanger);
        Truck truck2 = new Truck(2,"Factory B", "Warehouse D", goods2, exchanger);

        new Thread(truck1).start();
        new Thread(truck2).start();
    }
}
