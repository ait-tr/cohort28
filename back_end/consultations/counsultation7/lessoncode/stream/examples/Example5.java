package stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("BigBen", "BigBob", "Big", "Ben", "Big Bob");
        System.out.println(list.stream().filter("Big"::equals).count());

        List<String> list2 = Arrays.asList("a1", "b5", "a2", "b4");
        System.out.println(list2.stream().min(String::compareTo).get());

        List<String> list3 = Arrays.asList("a1", "b5", "a2", "b4","c1", "a1", "b5");
        List<String> result3 = list3.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result3);



        List<String> list4 = Arrays.asList("a1", "b5", "a2", "b4","c1", "a1", "b5");
        List<String> result4 = list4.stream()
                .sorted((o1,o2) -> (-1) * (o1.compareTo(o2)))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result4);
    }
}
