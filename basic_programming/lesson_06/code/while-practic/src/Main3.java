import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Бегун>");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите конечную цель ");
        double target = scanner.nextDouble();
        System.out.println("Сколько вы пробежали сегодня? ");
        double s = scanner.nextDouble() ;

        double day = 0 ;

        while (target > s){
            s = s + (s * 0.1);
            day = (day +1);
        }
        System.out.println("Поздравляю! До цели осталось " + day + " Дней");
    }
}