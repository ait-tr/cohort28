package practice.bus;

import java.util.ArrayList;
import java.util.Collections;

public class CityBusAppl {
    public static void main(String[] args) {

        // Создадим список городских маршрутов

        ArrayList<Bus> cityBuses = new ArrayList<Bus>(); // еще нет элементов

        cityBuses.add(new Bus("BrandNew", "30", 50));
        cityBuses.add(new Bus("Mercedes", "Düsseldorf - Köln", 30));
        cityBuses.add(new Bus("Man", "40", 55));
        cityBuses.add(new Bus("Man", "10", 45));

        System.out.println(cityBuses.size());
        
        int index = cityBuses.indexOf(new Bus("", "40", 0));

        System.out.println(index);

        // for(T e: "set of T"){ do something};
        // В теле этого цикла переменная "e" принимает поочередно значение каждого элементаor(T e: "set of T"){ do something};

        // печать до сортировки
        for (Bus route: cityBuses) {
            System.out.println(route);
        }

        System.out.println("======Sorting by route ========");
        Collections.sort(cityBuses); // сортировка по маршруту

        // печать после сортировки
        for (Bus route: cityBuses) {
            System.out.println(route);
        }

        int totalCapacity = 0;
        System.out.println("========Total Capacity=============");
        for (Bus capacity:
             cityBuses) {
            totalCapacity +=  capacity.getCapacity();
        }

        System.out.println(totalCapacity);

    }
}
