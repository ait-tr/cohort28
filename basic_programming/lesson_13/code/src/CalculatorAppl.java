package ait.calculator;

import java.util.Scanner;

public class CalculatorAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first argument");
        double x = scanner.nextDouble();
        System.out.println("Enter second argument");
        double y = scanner.nextDouble();
        System.out.println("Enter operation");
        String oper = scanner.next();
        double res = calculator(x, y, oper);
        System.out.println("Result = " + res);

    }

    public static double calculator(double x, double y, String oper) {
        switch (oper) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                System.out.println("Wrong operation");
                //return 0. / 0;
                return 0;
        }
    }
}
