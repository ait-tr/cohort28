package stream.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example4 {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2,3,4,5);

        System.out.println(number);

        List<Integer> square = number.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        System.out.println(square);


        List<String> words = Arrays.asList("Java", "Collections", "Stream", "Array", "System");
        List<String> result = words.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());

        System.out.println(result);


        List<Integer> number2 = Arrays.asList(2,3,4,5,2,4);

        System.out.println(number2);

        Set<Integer> squareSet = number2.stream()
                .map(x -> x * x)
                .collect(Collectors.toSet());

        System.out.println(squareSet);

    }
}
