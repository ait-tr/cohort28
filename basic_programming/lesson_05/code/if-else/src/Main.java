
public class Main {
    public static void main(String[] args) {
        int height = -182;
        if(height > 192)
        {
            System.out.println("I am very tall");
            System.out.println("Feed me");
        }
        else
        {
            System.out.println("I am not very tall");
        }
        System.out.println("Mi height is: " + height + " sm");
        double res = max(8.9, 8.8);
        System.out.println("Max = " + res);
    }
    public static double max(double x, double y){
        double res;
        if(x > y) {res = x;} else {res = y;} return res;   }
}