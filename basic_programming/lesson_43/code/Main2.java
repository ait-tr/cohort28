/**
 * 7/18/2023
 * SimpleProject
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double x = calculator.divWithTryCatch(10, 0);
        System.out.println(x + 100);

        try {
            double y = calculator.divWithThrows(10, 0);
            System.out.println(y);
        } catch (ArithmeticException e) {
            System.out.println("Нельзя делить на ноль!");
        }

        try {
            double z = calculator.divWithCheckedException(10, 5);
        } catch (Exception e) {
            System.out.println("ОШибка!");
        }


    }
}
