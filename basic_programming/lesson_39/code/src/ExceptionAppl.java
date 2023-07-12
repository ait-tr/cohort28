package ait.exception;

public class ExceptionAppl {
    public static void main (String[] args) {
        int a = 3;
        int b = 12;
        try {
            int x = solution(a, b);
            System.out.println("Solution = " + x);

        } catch (NoSolutionException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
            System.out.println("No solution");

        } catch (SolutionAnyNumberException e) {
//            System.out.println(e.getMessage());
            System.out.println("Solution any number");

        }  finally {
            System.out.println("Bye, bye");
        }
        System.out.println("Math is great");

    }

    public static int solution(int a, int b) throws NoSolutionException {
        int res;
        if (a == 0 && b != 0) {
            throw new NoSolutionException();
        }
        if (a == 0 && b == 0) {
            throw new SolutionAnyNumberException();
        }
        res = b / a;
        return res;
    }
}
