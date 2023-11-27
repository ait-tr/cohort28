package benchmarks;

import java.util.LinkedList;
import java.util.List;

class LinkedListAddToEnd {

    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        System.out.println(integers.size());

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            integers.add(i);
        }

        long finish = System.currentTimeMillis();
        long result = finish - start;

        System.out.println(integers.size());
        System.out.println("Result = " + result + " ms");
    }
}
