package ait.equation;

import ait.equation.model.QuadraticEquation;

public class EquationAppl {
    public static void main(String[] args) {
        QuadraticEquation eq = new QuadraticEquation(1, 2, 1);
        eq.display();
        System.out.println("Delta = " + eq.delta());
        System.out.println("Number of roots = " + eq.quantityRoots());
    }
}
