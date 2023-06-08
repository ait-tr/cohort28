import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Binary search");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input element to search: ");
        int element = scanner.nextInt(); // read searched element from user
        int[] numbers = {-4, 1, 10, 11, 13, 20, 35, 46, 56, 67}; // требуется отсортированный массив
        System.out.println(Arrays.toString(numbers)); // выводит массив
        int[] result = binarySearch(numbers, element); // выполняет бинарный поиск
        int index = result[0];
        int foundElement = result[1];
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + index);
            System.out.println("Found element: " + foundElement);
        }
    }
    public static int[] binarySearch(int[] array, int element) {
        int left = 0;
        int right = array.length - 1;
        int middle;
        int[] result = {-1, -1}; // значение по умолчанию, если результат не найден
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (element < array[middle]) {
                right = middle - 1;
            } else if (element > array[middle]) {
                left = middle + 1;
            } else {
                result[0] = middle; // обновляет индекс
                result[1] = array[middle]; // обновляем найденный элемент
                break;
            }
        }
        return result;
    }
}