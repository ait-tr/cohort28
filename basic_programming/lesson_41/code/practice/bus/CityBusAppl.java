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

        System.out.println("Size of ArrayList cityBases: " + cityBuses.size());
        
        int index = cityBuses.indexOf(new Bus("", "40", 0));
        System.out.println(index);

        System.out.println("======Index of route 30 ========");
        int index1 = cityBuses.indexOf(new Bus ("30"));
        System.out.println(index1);

        System.out.println("======Index = 0 ========");
        System.out.println(cityBuses.get(0));


        // for(T e: "set of T"){ do something};
        // В теле этого цикла переменная "e" принимает поочередно значение каждого элементаor(T e: "set of T"){ do something};
        System.out.println("======List ========");
        // печать до сортировки
        for (Bus route: cityBuses) {
            System.out.println(route);
        }
        System.out.println("======Indexes ========");
        for (Bus route: cityBuses) {
            System.out.println(cityBuses.indexOf(route));
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

        System.out.println("========List with Indexes=============");
        for (int i = 0; i < cityBuses.size(); i++) {
            System.out.println("Index = " + i + " " + cityBuses.get(i));
        }

    }
}
