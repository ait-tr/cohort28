package stream.examples;

import java.util.stream.IntStream;

public class Example1 {
    public static void main(String[] args) {

        int[] arr = {50,90,60,70,80,90,100,110,120};

        int count = 0;

        for (int x : arr) {
            if (x >= 90) continue;
                x = x + 10;
                count++;
                if (count > 3) break;
            System.out.println(x);
        }

        IntStream.of(50,90,60,70,80,90,100,110,120)
                .filter(x -> x < 90)
                .map(x -> x + 10)
                .limit(3)
                .forEach(System.out::println);
    }
}
