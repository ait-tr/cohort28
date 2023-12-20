package generics.example1;

public class GenericDemo {
    public static void main(String[] args) {
        //Тест на Rectangle<Integer>
        Rectangle<Integer> rInt = new Rectangle<>(1,2,3,5);
        double areaRect = rInt.area();
        System.out.println("Rectangle area = " + areaRect);

        //Тест на Rectangle<Double>
        Rectangle<Double> rDouble = new Rectangle<>(1.5,5.5,3.5,5.5);
        areaRect = rDouble.area();
        System.out.println("Rectangle area = " + areaRect);


        //Тест на Circle
        Circle<Float> cFloat = new Circle<>(1.5f);
        double areaCircle = cFloat.area();
        System.out.println("Circle area = " + areaCircle);

        //ццCircle<Boolean>
    }
}
