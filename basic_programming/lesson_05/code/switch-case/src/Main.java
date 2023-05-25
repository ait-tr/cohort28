public class Main {
    public static void main(String[] args) {
        fan1(11);
    }
    public static void fan1(int mode) {
        switch (mode) {
            case 0:
                System.out.println("Off");
                break;
            case 1:
                System.out.println("Slow");
                break;
            case 2:
                System.out.println("Medium");
                break;
            case 3:
                System.out.println("Fast");
                break;
            default:
                System.out.println("Wrong mode");
        }
        System.out.println("Bye, bye!");
    }

    public static void calculator(double a, double b, int oper){
        //oper == 1 => +, oper == 2 => -, oper == 3 => *, oper == 4 => /
        //other print "Wrong operation"
    }
}