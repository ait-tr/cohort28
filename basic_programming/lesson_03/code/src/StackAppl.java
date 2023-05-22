public class StackAppl {
    public static void main(String[] args) {
        System.out.println("Method main start");
        method1();
        System.out.println("Method main stop");
    }

    private static void method1() {
        System.out.println("Method method1 start");
        method2();
        System.out.println("Method method1 stop");
    }

    private static void method2() {
        System.out.println("Method method2 start");
        method3();
        System.out.println("Method method2 stop");
    }

    private static void method3() {
        System.out.println("Method method3 start");
        System.out.println("Method method3 stop");
    }
}