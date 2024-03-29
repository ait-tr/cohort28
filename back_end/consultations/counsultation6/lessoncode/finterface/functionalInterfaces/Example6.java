package finterface.functionalInterfaces;

public class Example6 {
    public static void main(String[] args) {
        MyFuncInterface add = (int x, int y) -> x + y;
        MyFuncInterface multiply = (int x, int y) -> x * y;

        System.out.println("Addition: " + add.operate(2,3, add));
        System.out.println("Multiplying: " + multiply.operate(2,3, multiply));
    }
}

