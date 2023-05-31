import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Search element in array");
//        Задать массив из 10 случайных чисел в интервале от 10 до 100. Пользователь вводит интересующее его
//        число. Определить, есть ли в массиве такое число. Если есть, то указать на каком оно месте.

        int[] array = new int[10]; // определили массив

        for (int i = 0; i < array.length; i++) { // делаем заполнение масива
            int b = 100; // это из условия задачи
            int a = 10; // это из условия задачи
            array[i] = (int)(Math.random() * (b - a + 1) + a);
        }

        System.out.println(Arrays.toString(array));// печать массива на экран

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number for searching in array: ");
        int number = scanner.nextInt();
        int index = -1; // такого индекса в массиве нет

        // Поиск в массиве
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.println("Number " + number + " presents in array.");
                index = i;
                System.out.println(" Index of searched number is: " + index);
            }
        }

        if (index == -1) {
            System.out.println("The number doesn't present in array.");
        }

    }
}