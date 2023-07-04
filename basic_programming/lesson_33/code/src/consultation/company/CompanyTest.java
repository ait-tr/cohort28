package consultation.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;


public class CompanyTest {

    Company[] companies; // создаем массив типа Company

    @BeforeEach
    void setup() {
        companies = new Company[4];
        // создаем конкретные объекты класса Company
        companies[0] = new Company("Bosch", 100000, 5000000, 1906);
        companies[1] = new Company("Mercedes", 200000, 2000000, 1936);
        companies[2] = new Company("MAN", 500000, 1000000, 1925);
        companies[3] = new Company("Audi", 30000, 5000000, 1950);
    }

    @Test
    void testCompareCompany() {
        System.out.println("=========Sort companies by numOfEmployees ==========");
        printArray(companies); // печатаем до сортировки
//        Arrays.sort(companies);
//        System.out.println();
//        System.out.println("Sorted by Number of Employee");
//        printArray(companies);
        System.out.println("Sorted by Profit");
        Arrays.sort(companies); // проводим сортировку по прибыли, большая прибыль - вверху
        printArray(companies);

    }

    void printArray(Object[] objects){
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

}

