package ait.wrapper;

public class ArrayArgsAppl {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Wrong number of args");
            return;
        }
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[2]);
        double res = calculator(x, y, args[1]);
        System.out.println("Result = " + res);
    }

    public static double calculator(double a, double b, String oper) {
        switch (oper) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return Double.NaN;
        }
    }
}
