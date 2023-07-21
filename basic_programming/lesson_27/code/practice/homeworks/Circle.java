package ait.figure.model;

public class Circle extends Shape {
    public Circle(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        return side * side * Math.PI;
    }

    public double calcPerimeter() {
        return 2 * side * Math.PI;
    }
}
