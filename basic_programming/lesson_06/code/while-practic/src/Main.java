public class Main {
    public static void main(String[] args) {
        System.out.println("Корзина с яблоками");
        int numberApple = 30;

        // snake_case
        // camelCase

        // условие вход в цикл
        while (numberApple > 0) { // начало тело цикла
            System.out.println("Lost in basket " + numberApple + " aplles.");
            // numberApple = numberApple - 1;
            numberApple--; // уменьшает значение на 1
        } // конец тела цикла

        System.out.println("The basket is empty.");
    }
}