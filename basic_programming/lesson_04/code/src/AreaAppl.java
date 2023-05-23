public class AreaAppl {
    public static void main(String[] args) {
        double res = calcCircleArea(10);
        System.out.println(res);
        res = calcSquareArea(10);
        System.out.println(res);
        res = calcRectangleArea(10, 20);
        System.out.println(res);
    }

    public static double calcCircleArea(double radius) {
        return radius * radius * 3.1415926;
    }

    public static double calcSquareArea(double side) {
        return side * side;
    }

    public static double calcRectangleArea(double side1, double side2) {
        return side1 * side2;
    }
}
