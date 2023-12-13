package stream.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapExample2 {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> list2 = Arrays.asList(4,5,6,11,12,13,14,15);
        List<Integer> list3 = Arrays.asList(7,8,90,91,92);

        List<List<Integer>> listOfLists = Arrays.asList(list1,list2,list3);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .sorted()
                .distinct()
                .toList();

        System.out.println(listOfAllIntegers);

    }
}
