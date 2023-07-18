package comparator;

import java.util.Arrays;

public class PlainAppl {
    public static void main(String[] args) {
        Plain p1 = new Plain("Boeing", "1BC5F", 200, 650);
        Plain p2 = new Plain("AirBus", "R56F", 250, 800);
        Plain p3 = new Plain("SuperJet", "H36S", 120, 600);
        Plain p4 = new Plain("McDonald", "44T33", 300, 850);
        Plain p5 = new Plain("Antonov", "A27U", 350, 700);

        Plain[] flot = new Plain[5];

        flot[0] = p1;
        flot[1] = p2;
        flot[2] = p3;
        flot[3] = p4;
        flot[4] = p5;

        System.out.println("Print flot before sorting");

        for (int i = 0; i < flot.length; i++) {
            System.out.println(flot[i]);
        }

        // отсортируем этот массив
        Arrays.sort(flot); // здесь и происходит сортировка по bortNumber

        System.out.println("Print flot after sorting");

        for (int i = 0; i < flot.length; i++) {
            System.out.println(flot[i]);
        }


    }
}
