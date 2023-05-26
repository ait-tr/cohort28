// Вводится шестизначное число (номер автобусного билета). Определите,
// является ли этот билет "счастливым"
// (сумма первых трех цифр равна сумме трех последних цифр).

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // включаем Scanner
        System.out.println("Input number (positive and integer)");
        int number = scanner.nextInt();
        int number1= number/1000;
        number = number % 1000;

        int sum1 = sumTicket(number);
        int sum2 = sumTicket(number1);
        System.out.println("Left " + number1);
        System.out.println("Right " + number);
        System.out.println("Summa Right is " + sum1);
        System.out.println("Summa Left is " + sum2);
        if (sum1==sum2) {
            System.out.println("Ticket happy! ");
        } else {
            System.out.println("Ticket unhappy( ");
        }
    }
    public static int sumTicket(int num) {
        int sum = 0;
        int count= 0;
        while (count < 3){
            sum = sum + num % 10;
            num = num / 10;
            count++;
        }
        return sum;
    }
}