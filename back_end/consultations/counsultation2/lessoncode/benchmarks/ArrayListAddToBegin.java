package benchmarks;


import java.util.ArrayList;
import java.util.List;

class ArrayListAddToBegin {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        System.out.println(integers.size());

        long start = System.currentTimeMillis();

        for (int i = 0; i < 500_000; i++) {
            integers.add(0, i);
        }

        long finish = System.currentTimeMillis();
        long result = finish - start;

        System.out.println(integers.size());
        System.out.println("Result = " + result + " ms");
    }
}
