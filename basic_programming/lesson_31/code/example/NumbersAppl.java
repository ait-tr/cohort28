import model.Cat;

import java.util.Arrays;
import java.util.Comparator;

public class NumbersAppl {
    public static void main(String[] args) {

        Numbers[] num = new Numbers[]{
                new Numbers(5),
           new Numbers(17),
           new Numbers(3),
           new Numbers(87),
           new Numbers(34),
           new Numbers(67)
        } ;

        System.out.println("Unsorted");
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        System.out.println();
    // способ 1 - сделать класс implement Comparable<Класс> и реализовать в нем метод compareTo
    // затем вызвать Arrays.sort()
        Arrays.sort(num);
        System.out.println("Sorted");
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        System.out.println();

    // способ 2 - создать Comporator
        Comparator<Numbers> compNum = new Comparator<Numbers>() {
            @Override
            public int compare(Numbers o1, Numbers o2) {
                return o1.n - o2.n;
            }
        };

        // новый несортированный массив:
        Numbers[] num1 = new Numbers[]{
                new Numbers(45),
                new Numbers(-27),
                new Numbers(-13),
                new Numbers(7),
                new Numbers(-34),
                new Numbers(65)
        } ;
        System.out.println("Unsorted");
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }
        System.out.println();
        // производим сортировку с помощью Comparator compNum
        Arrays.sort(num1, compNum);
        //печатаем результат сортировки
        System.out.println("Sorted");
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num1[i]);
        }

        // 3-й способ: с помощью лямбда - выражения
        // новый несортированный массив:
        Numbers[] num2 = new Numbers[]{
                new Numbers(45),
                new Numbers(-27),
                new Numbers(-13),
                new Numbers(7),
                new Numbers(-34),
                new Numbers(65)
        } ;
        System.out.println("Unsorted");
        for (int i = 0; i < num1.length; i++) {
            System.out.println(num2[i]);
        }

        Arrays.sort(num2,(n1,n2) -> {
            int res = n1.n - n2.n; // сравнение
            return res;
        } );
        System.out.println();
        System.out.println("Sorted");
        for (int i = 0; i < num2.length; i++) {
            System.out.println(num2[i]);
        }
    }
}
