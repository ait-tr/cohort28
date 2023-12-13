package stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        List<String> c = Arrays.asList("10","20","1","10","50","25","20","25");

        System.out.println("Original: " + c);

        //filter && count
        long result = c.stream()
                .filter(p -> p.equals("10"))
                .count();
        System.out.println("Result of filtering and counting: " + result );

        // sorted
        List<String> result2 = c.stream()
                .sorted()
                .toList();

        System.out.println("Result of sorting: " + result2);

        //sorted && limit
        List<String> result3 = c.stream()
                .sorted()
                .limit(3)
                .toList();

        System.out.println("Result of sorting and limit(3): " + result3);


        //sorted && skip
        List<String> result4 = c.stream()
                .sorted()
                .skip(3)
                .toList();

        System.out.println("Result of sorting and skip(3): " + result4);


        //distinct
        List<String> result5 = c.stream()
                .sorted()
                .distinct()
                .toList();

        System.out.println("Result of sorting and distinct: " + result5);

        //peek
        System.out.println("Result of peek() method:");
        c.stream()
                .peek((e) -> System.out.println(e + " hello!"))
                .collect(Collectors.toList());
        System.out.println();

        // map example
        System.out.println("Result of map() method:");
        c.stream()
                .map(x -> x + " times")
                .forEach(msg -> System.out.print(msg + " "));
        System.out.println();

    }
}
