import java.util.Scanner;

public class LoopAppl {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bound:");
        int bound = scanner.nextInt();
        double res = sumNumbers(bound);
        System.out.println("Result = " + res);
        System.out.println("Enter number for factorial:");
        bound = scanner.nextInt();
        int result = factorial(bound);
        System.out.println("Factorial = " + result);
        System.out.println("Enter sum for deposit:");
        double sum = scanner.nextDouble();
        System.out.println("Enter years for deposit:");
        bound = scanner.nextInt();
        res = deposit(sum, bound);
        System.out.println("Result of your deposit " + res);
//        printMaxNumbers();
        result = oddProduct();
        System.out.println("Odd product = " + result);
        System.out.println("Enter sum of loan:");
        double loanSum = scanner.nextDouble();
        System.out.println("Enter loan limit:");
        double limit = scanner.nextDouble();
        int years = loan(loanSum, limit);
        System.out.println("Years = " + years);
    }

    public static double sumNumbers(int bound) {
        double res = 0;
        for (int i = 1; i <= bound; i++) {
            res = res + 1. / i;
        }
        return res;
    }

    public static int factorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res = res * i;
        }
        return res;
    }

    public static double deposit(double amount, int years) {
        double res = amount;
        for (int i = 1; i <= years; i++) {
            res = res * 1.03;
        }
        return res;
    }

    public static void printMaxNumbers() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter number1:");
            int num1 = scanner.nextInt();
            System.out.println("Enter number2:");
            int num2 = scanner.nextInt();
            System.out.println(num1 > num2 ? num1 : num2);
        }

    }

    public static int oddProduct() {
        int res = 1;
        for (int i = 13; i < 100; i = i + 13) {
            if (i % 2 != 0) {
                res = res + i;
            }
        }
        return res;
    }

    public static int loan(double amount, double limit) {
//        int counter;
//        for (counter = 0; amount <= limit; amount = amount * 1.1, counter++) ;
//        return counter;
        int counter = 0;
        while (amount <= limit) {
            counter++;
            amount = amount * 1.1;
        }
        return counter;
    }
}
