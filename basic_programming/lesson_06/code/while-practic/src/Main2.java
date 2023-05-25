import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Количество цифр в числе");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input number (positive and integer): ");
        int number = scanner.nextInt();
        System.out.println("Number is: " + number);

        // Алгоритм:
        // number делим НАЦЕЛО на 10 до тех пор, пока не получим число, меньшее 0
        // на каждой итерации цикла счетчик ++
        // значение счетчика = количество цифр в числе

        int count = 0; // начальное значение счетчика

//        while ( number > 0 ) {
//            number = number / 10;
//            count = count + 1;
//        }

        do {
            number = number / 10;
            count = count + 1;
        } while (number > 0);

        System.out.println("Number of digits is: " + count);
    }
}