/**
 * 7/18/2023
 * SimpleProject
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Calculator {
    public int divWithTryCatch(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double divWithThrows(int a, int b) throws ArithmeticException {
        return (double) a/b;
    }

    public double divWithCheckedException(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("Вы пытаетесь делить на ноль");
//            throw new RuntimeException("Вы пытаетесь делить на ноль");
        } else {
            return (double) a / b;
        }
    }
}
