import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {

        //Вводится число, напечатайте это число в обратном порядке
        Scanner scanner = new Scanner(System.in); // включаем Scanner
        System.out.println("Input number (positive and integer)"); // invitation for user
        int number = scanner.nextInt(); // read data
        int numberNew = 0;
        while (number > 0) { // loop start
            numberNew = numberNew * 10 + number % 10; // new number creation
            number = number / 10; // изменение параметра цикла, change loop parameter/argument
        }
        System.out.println("New number is " + numberNew);
    }

}