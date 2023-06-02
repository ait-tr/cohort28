import java.util.Arrays;
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Binary search");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input element to search: ");
        int element = scanner.nextInt(); // read searched element from user

        int[] numbers = {-4, 1, 10, 11, 13, 20, 35, 46, 56, 67}; // нужен отсортированный (!!!) массив
        System.out.println(Arrays.toString(numbers)); // print array

        // Алгоритм:
        // левый left - левый конец массива (индекс)
        // правый right - правый конец массива (индекс)
        // середина массива middle - середина массива, middle = left + (right - left)/2; (array.length / 2)
        // пока левый <= правый будем делать
        // искать элемент в левой или правой половине?
        // "сделать" новые left и right в зависимости от того, где оказался искомый элемент - в левой или правой половине

        int left = 0;
        int right = numbers.length - 1;
        int middle = left + (right - left)/2;
        boolean hasElement = false;

        while (left <= right) {
            if (element < numbers[middle]) { // element in left part
                right = middle - 1;
            } else if (element > numbers[middle]) { // element in right part
                left = middle + 1;
            } else { // element is finded
                hasElement = true;
                break;
            }
            middle = left + (right - left)/2; // new middle
        }
        System.out.println("Search result " + hasElement);
    }
}