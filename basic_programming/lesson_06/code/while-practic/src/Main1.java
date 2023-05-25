public class Main1 {
    public static void main(String[] args) {
        System.out.println("Обратный отсчет");

        int countDownStart = 10;

        while (countDownStart > 0) {
            System.out.println("To start left: " + countDownStart + " sec.");
            countDownStart--;
        }

        System.out.println("The rocket goes up!");

    }
}