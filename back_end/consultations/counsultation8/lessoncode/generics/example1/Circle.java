package generics.example1;

public class Circle <T extends Number> implements Figure{
    private T radius;

    public Circle(T radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius.doubleValue(), 2);
    }
}
