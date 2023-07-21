package ait.figure;

import ait.figure.model.Shape;
import ait.figure.model.Circle;
import ait.figure.model.Square;
import ait.figure.model.Triangle;


public class FigureAppl {
    public static void main(String[] args) {
        Shape[] figures = new Shape[6];
        figures[0] = new Circle(5);
        figures[1] = new Circle(10);
        figures[2] = new Triangle(5);
        figures[3] = new Square(10);
        double totalShapesArea = totalArea(figures);
        double totalShapesPerimeter = totalPerimeter(figures);
        System.out.println("Total area = " + totalShapesArea);
        System.out.println("Total perimeter = " + totalShapesPerimeter);
        double circlesArea = totalCirclesArea(figures);
        System.out.println("Total area of circles = " + circlesArea);
    }

    private static double totalArea(Shape[] figures) {
        double res = 0;
        for (int i = 0; i < figures.length; i++) {
            if(figures[i] != null) {
                res += figures[i].calcArea();
            }
        }
        return res;
    }

    private static double totalPerimeter(Shape[] figures) {
        double res = 0;
        for (int i = 0; i < figures.length; i++) {
            if(figures[i] != null) {
                res += figures[i].calcPerimeter();
            }
        }
        return res;
    }
    private static double totalCirclesArea(Shape[] figures) {
        double res = 0;
        for (int i = 0; i < figures.length; i++) {
            if(figures[i] instanceof Circle) {
                res += figures[i].calcArea();
            }
        }
        return res;
    }
}
