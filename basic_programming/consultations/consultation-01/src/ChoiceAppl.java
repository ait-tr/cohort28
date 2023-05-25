public class ChoiceAppl {
    public static void main(String[] args) {
        int age = 21;
        double res = barmen(age);
        printVol(res);
        age = 15;
        res = barmen(age);
        printVol(res);
        res = max(3.8, 5.4);
        System.out.println("Max = " + res);
        res = max(8.2, 8.1);
        System.out.println("Max = " + res);
        res = abs(5);
        System.out.println("abs = " + res);
        res = abs(-7);
        System.out.println("abs = " + res);
        res = abs(0);
        System.out.println("abs = " + res);
        int a = sign(5.5);
        System.out.println("sign = " + a);
        a = sign(-2.8);
        System.out.println("sign = " + a);
        a = sign(0);
        System.out.println("sign = " + a);
    }

    public static double barmen(int age){
        double vol = age >= 18 ? 42 : 1.5;
        return vol;
    }

    public static void printVol(double vol){
        System.out.println("You max. vol. = " + vol);
    }

    public static double max(double x, double y){
        //  double res = x > y ? x : y;
        //  return res;
        return x > y ? x : y; // это тернарный опертор
    }

    public static double abs(double x) {
        return x < 0 ? -x : x;
    }

    public static int sign(double x) {
        return x > 0 ? 1 : (x < 0 ? -1 : 0);
    }

    public static double min(double x, double y) {
        double x1, y1;
        // поменять знак у x и y
        x1 = - x;
        y1 = - y;
        // использовать метод max и получаем результат - это минимальное число с обратным знаком

        // изменить знак у полученного числа

        // вернуть результат

    }

}