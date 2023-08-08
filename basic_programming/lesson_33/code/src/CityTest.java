
import ait.city.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class CityTest {
    City[] cities;

    @BeforeEach
    void setUp() {
        cities = new City[6];
        cities[0] = new City("Denver", 600_000);
        cities[1] = new City("Boston", 670_000);
        cities[2] = new City("Chicago", 2_700_000);
        cities[3] = new City("Atlanta", 470_000);
        cities[4] = new City("New York", 8_500_000);
        cities[5] = new City("Dallas", 1_300_000);
    }

    private void printArray(Object[] arr, String title) {
        System.out.println("===== " + title + " =====");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testComparable() {
        printArray(cities, "Original array");
        Arrays.sort(cities);
        printArray(cities, "Natural order");
        City pattern = new City(null, 1_200_000);
        int index = Arrays.binarySearch(cities, pattern);
        System.out.println("Index = " + index);
    }

    @Test
    void testComparator() {
        Comparator<City> comparator = (c1, c2) -> c1.getName().compareTo(c2.getName());
        Arrays.sort(cities, comparator);
        printArray(cities, "Sort by name");
        City pattern = new City("Chicago", 0);
        int index = Arrays.binarySearch(cities, pattern, comparator);
        System.out.println("Index = " + index);
    }

    @Test
    void testArrayCopy() {
        City[] citiesCopy = Arrays.copyOf(cities, cities.length * 2);
        printArray(citiesCopy, "citiesCopy before sort of cities");
        Arrays.sort(cities);
        printArray(citiesCopy, "citiesCopy after sort of cities");
        Comparator<City> comparator = (c1, c2) -> c1.getName().compareTo(c2.getName());
        Arrays.sort(citiesCopy, 0, cities.length, comparator);
        printArray(citiesCopy, "citiesCopy sort by name");
        City pattern = new City("Yalta", 0);
        int index = Arrays.binarySearch(citiesCopy, 0, cities.length, pattern, comparator);
        System.out.println("Index = " + index);
    }

    @Test
    void testCopyOfRange() {
        City[] citiesCopyRange = Arrays.copyOfRange(cities, 1, cities.length - 1);
        printArray(citiesCopyRange, "citiesCopyOfRange");
    }

    @Test
    void testSystemArrayCopy() {
        City[] citiesCopy = new City[cities.length * 2];
        System.arraycopy(cities, 1, citiesCopy, 4, cities.length - 2);
        printArray(citiesCopy, "System.arraycopy");
    }

    @Test
    void testKeepSorted() {
        Arrays.sort(cities);
        printArray(cities, "Natural order");
        City city = new City("Salem", 690_000);
        City[] citiesCopy = Arrays.copyOf(cities, cities.length + 1);
//        Wrong way
//        citiesCopy[citiesCopy.length - 1] = city;
//        Arrays.sort(citiesCopy);
        int index = Arrays.binarySearch(citiesCopy, 0, citiesCopy.length - 1, city);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(citiesCopy, index, citiesCopy, index + 1, citiesCopy.length - index - 1);
        citiesCopy[index] = city;
        cities = citiesCopy;
        printArray(cities, "Natural order after add city");

    }
}
