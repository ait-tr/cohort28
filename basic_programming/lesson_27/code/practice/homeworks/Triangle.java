package ait.figure.model;

public class Triangle extends Shape {
    public Triangle(double side) {
        super(side);
    }

    @Override
    public double calcArea() {
        return side * side * Math.sqrt(3) / 4;
    }

    public double calcPerimeter() {
        return 3 * side;
    }
}
