package generics.example1;

public class Rectangle <T extends Number> implements Figure{

    private T x1, x2, y1, y2;

    public Rectangle(T x1, T x2, T y1, T y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public double area() {
        return Math.abs(x1.doubleValue() - x2.doubleValue()) *
                Math.abs(y1.doubleValue() - y2.doubleValue());
    }
}
