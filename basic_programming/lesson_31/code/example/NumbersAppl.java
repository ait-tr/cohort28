import java.util.Arrays;

public class NumbersAppl {
    public static void main(String[] args) {
        Numbers n1 = new Numbers(6);
        Numbers n2 = new Numbers(2);
        Numbers n3 = new Numbers(4);
        Numbers n4 = new Numbers(1);
        Numbers n5 = new Numbers(3);
        Numbers n6 = new Numbers(5);

        Numbers[] num = new Numbers[6];

        num[0] = n1;
        num[1] = n2;
        num[2] = n3;
        num[3] = n4;
        num[4] = n5;
        num[5] = n6;

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
        System.out.println();

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }

    }
}
