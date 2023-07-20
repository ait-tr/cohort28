package consultation;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        NumbersProcessor processor = new NumbersProcessor();
        List<Integer> numbers = Arrays.asList(178, 21, 15, 16, 77, 13, 71);

//        Predicate<Integer> predicate1 = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer % 2 == 0;
//            }
//        };
//
//        Predicate<Integer> predicate2 = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer % 10 == 1;
//            }
//        };

        Predicate<Integer> predicate1 = integer -> integer % 2 == 0; // реализация метода test

        Predicate<Integer> predicate2 = integer -> integer % 10 == 1; // реализация метода test

        List<Integer> result = processor.filter(numbers, integer -> integer % 3 == 0);

        System.out.println(result);
    }
}
