package stream.examples;

import java.util.ArrayList;
import java.util.List;

public class FlatMapExample1 {
    public static void main(String[] args) {
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(4);
        two.add(5);
        two.add(6);

        ArrayList<List<Integer>> l1 = new ArrayList<>();

        l1.add(one);
        l1.add(two);

        System.out.println(l1);

        System.out.println("Result of flatmap method");
        List<Integer> myList = l1.stream()
                .flatMap(listFromMyCollection -> listFromMyCollection.stream())
                .peek( x -> System.out.print(x + ", "))
                .filter(x -> x < 10)
                .toList();

        System.out.println(myList);

    }
}
