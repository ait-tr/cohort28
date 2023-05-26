import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Sum from 1 to n, n - input from user");
//        Посчитать сумму всех чисел до введенного n (n - натуральное число)

        // Алгоритм:
        // 1 + 2 + ..... + 999 + 1000
        // 1 + 1000 = 1001, 2 + 999 = 1001 , таких пар = 500
        // 500 * 1001 = 500500

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input N: ");
        int n = scanner.nextInt(); // принимаем число с клавиатуры (get number from user)

        int sum = 0; // переменная для суммы

        for (int i = 1; i <= n / 2; i++) { // перебираем i от 1 до n/2
            sum = sum + (i + (n - (i - 1))); // накапливаем первое + последнее число, следующее + предпоследнее
        }

        System.out.println(sum);
    }
}

//    Полезно при отладке цикла:
//    - включить промежуточные печати параметра цикла и получаемого результата
//    - проверить при крайних значениях, а потом на 1-2 итерации самостоятельно (ручка, бумажка, калькулятор)