package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class CatTest {

    Cat[] cats; // создаем массив объектов типа Cat

    @BeforeEach
    void setup() { // этот метод определяет исходные данные по нашей задаче
        cats = new Cat[] {
          new Cat("Belka", 4, "red" , 3),
          new Cat("Strelka", 5, "white", 6),
          new Cat("Tom", 5, "gray", 7),
          new Cat("Jerry", 6, "brown", 4)
        };
    }

    @Test
    void testCatsSort(){
        System.out.println("===========TestCatsSort==============");
        printArray(cats); // несортированный массив
        System.out.println("Unsorted");
        System.out.println();
        Arrays.sort(cats); // выполнили сортировку
        System.out.println("Sorted by age");
        printArray(cats); // печатаем результат

        // второй способ сортировки
        Comparator<Cat> catsComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };
        System.out.println();
        System.out.println("Sorted by name (reverse)");
        Arrays.sort(cats, catsComparator); // выполнили сортировку с помощью компаратора
        printArray(cats); // печатаем результат

        // третий способ
        // синтаксис с лямбда-выражением
        // сортировка по весу и возрасту
        Arrays.sort(cats,(s1,s2) -> {
            int res = s1.weight-s2.weight; // сортировка по весу
            if (res !=0) return res;
            return s1.age - s2.age; // сортировка по возрасту
        } );
        System.out.println();
        printArray(cats);

    }

    // ______CatTest Methods________
    public void printArray (Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    // ________end of Methods___________
}
