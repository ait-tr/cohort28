package consultation;

import java.util.Arrays;
import java.util.Random;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main3 {
    // на вход подаются числа от 0 до 999 включительно (в произвольном порядке, не уникальные)
    // нужно узнать, какое число встречается чаще остальных
    // O(n) ~ O(2n) ...
    public static void main(String[] args) {
        Random random = new Random();
        int[] randomNumbers = new int[500];
        int[] counts = new int[1000]; // последний индекс 999
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(1000); // 1000 не входит
        }

        System.out.println(Arrays.toString(randomNumbers));

        for (int i = 0; i < randomNumbers.length; i++) {
            counts[randomNumbers[i]]++; // если встретили 89, counts[89]++
        }

        // найти максимум в counts и индекс максимума
        // индекс максимума - число, которое встречается чаще других
    }
}
