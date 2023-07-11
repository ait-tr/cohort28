package ait.exception;

public class ExceptionAppl {
    public static void main(String[] args) {
        int a = 3;
        int b = 12;
        try {
            int x = solution(a, b);
            System.out.println("Solution = " + x);

        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
            System.out.println("No solution");

        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
            System.out.println("Solution any number");

        } catch (Exception e) {
            System.out.println("Unknown exception");

        } finally {
            System.out.println("Bye, bye");
        }
        System.out.println("Math is great");

    }

    public static int solution(int a, int b) {
        int res;
        if (a == 0 && b != 0) {
            throw new IllegalArgumentException();
        }
        if (a == 0 && b == 0) {
            throw new ArithmeticException();
        }
        res = b / a;
        return res;
    }
}
