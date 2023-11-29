package setCollection;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {

        Set<Town> towns = new HashSet<>();

        Town town1 = new Town("USA", "New-York");
        Town town2 = new Town("USA", "Washington");
        Town town3 = new Town("Canada", "Toronto");
        Town town4 = new Town("Germany", "Berlin");
        Town town5 = new Town("France", "Paris");

        Town town6 = new Town("USA", "Berlin");


        towns.add(town1);
        System.out.println(town1.hashCode());
        towns.add(town2);
        System.out.println(town2.hashCode());
        towns.add(town3);
        System.out.println(town3.hashCode());
        towns.add(town4);
        System.out.println(town4.hashCode());
        towns.add(town5);
        System.out.println(town5.hashCode());
        towns.add(town6);
        System.out.println(town6.hashCode());

        System.out.println(towns);

        for (Town town : towns) {
            if (town.hashCode() == 84354) {
                System.out.println(town);
            }
        }

        System.out.println("=========");

        for (Town town : towns) {
            if (town.getCountry().equals("USA")) {
                System.out.println(town);
            }
        }

    }
}
