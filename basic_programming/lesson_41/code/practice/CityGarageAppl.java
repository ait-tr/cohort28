package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CityGarageAppl {
    public static void main(String[] args) {

        ArrayList <Bus> cityBuses = new ArrayList<>(10);

        cityBuses.add(0, new Bus("Mercedes", 50, "1"));
        cityBuses.add(0, new Bus("Man", 40, "2"));
        cityBuses.add(0, new Bus("NoName", 20, "3"));

        System.out.println(cityBuses.size());
        // System.out.println(cityBuses);

        // for(T e: "set of T"){ do something};
        // В теле этого цикла переменная "e" принимает поочередно значение каждого элементаor(T e: "set of T"){ do something};

        for (Bus rout: cityBuses) {
            System.out.println(rout);
        }
        System.out.println("=================");
        Collections.sort(cityBuses);
        for (Bus rout: cityBuses) {
            System.out.println(rout);
        }

    }
}
