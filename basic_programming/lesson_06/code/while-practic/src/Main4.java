//Вводится число, напечатайте это число в обратном порядке

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // включаем Scanner
        System.out.println("Input number (positive and integer)");
        int number = scanner.nextInt();
        int numberNew = 0;
        while (number > 0) {
            numberNew = numberNew * 10 + number % 10;
            number = number / 10;
        }
        System.out.println("New number is " + numberNew);
    }

}