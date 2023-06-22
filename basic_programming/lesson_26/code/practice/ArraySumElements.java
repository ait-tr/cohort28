package practice;

public class ArraySumElements {
    public static void main(String[] args) {
//        Задайте массив на 10 элементов и заполните его случайными числами в интервале от -10 до 10.
//        Распечатайте полученный массив.
//        Найдите сумму элементов массива.
//        Разработайте соответсвующий тест (набор тестов).

        int[] array = new int[10];

        int a = -10;
        int b = 10;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (b - a + 1) + a);
        }

        printArray(array);
        System.out.println();
        System.out.println(sumElements(array));

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }

    public static int sumElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}
