import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator");

        //oper == 1 => +, oper == 2 => -, oper == 3 => *, oper == 4 => /
        //other print "Wrong operation"

        Scanner scanner = new Scanner(System.in); // включаем Scanner

        System.out.println("Input 1st number: ");
        double a = scanner.nextDouble(); // считываем число с клавиатуры
        System.out.println("Input 2nd number: ");
        double b = scanner.nextDouble(); // считываем число с клавиатуры

        System.out.println("Input operation: 1 - sum, 2 - subtraction, 3 - multiplication, 4 - division");
        int operation = scanner.nextInt();

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Operation is " + operation);

        switch (operation) {
            case 1: {
                double res = sum (a, b); // вызов метода
                System.out.println("Sum a and b = " + res);
                break;
            }

            case 2: {
                double res = sub (a, b); // вызов метода
                System.out.println("a - b = " + res);
                break;
            }

            case 3: {
                double res = mul (a, b); // вызов метода
                System.out.println("a * b = " + res);
                break;
            }

            case 4: {
                double res = div (a, b); // вызов метода
                System.out.println("a / b = " + res);
                break;
            }

            default: {
                System.out.println("Wrong operation");
            }
        }
    }

    // ___________Methods______________
        public static double sum(double x, double y) {
        return x + y;
        }

        public static double sub(double x, double y) {
            return x - y;
        }

        public static double mul(double x, double y) {
            return x * y;
        }

        public static double div(double x, double y) {
            return x / y;
        }

    // __________end of Methods________

}