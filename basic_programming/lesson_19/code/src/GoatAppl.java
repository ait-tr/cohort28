package ait.goat;

import ait.goat.model.Goat;

public class GoatAppl {
    public static void main(String[] args) {
        Goat goatling1 = new Goat(10);
        for (int i = 1; i <= goatling1.getMax(); i++) {
            goatling1.incrementCount();
        }
        System.out.println("goatling1.count = " + goatling1.getCount());
        Goat goatling2 = new Goat(15);
        for (int i = 1; i <= goatling2.getMax(); i++) {
            goatling2.incrementCount();
        }
        System.out.println("goatling2.count = " + goatling2.getCount());
        System.out.println("goatling1.count = " + goatling1.getCount());
//        int[] arr = new int[5];
//        System.out.println(arr.length);
//        arr.length = 10;
        System.out.println(Goat.GOAT_LIMIT);
        System.out.println(Math.PI);
        System.out.println(Math.E);
    }
}
