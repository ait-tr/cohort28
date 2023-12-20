package generics.wildCard;

import java.util.ArrayList;
import java.util.List;

public class WildCardExample {
    public static void main(String[] args) {
        // пример с ограничениями сверху (? extends Type)
        List<? extends Number> numbers = new ArrayList<>();

        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        List<Double> doubles = new ArrayList<>();

        doubles.add(1.1);
        doubles.add(2.2);
        doubles.add(3.3);


        numbers = doubles;

        //numbers.add(5); нельзя добавлять элементы (кроме null)

        List<? super Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        integerList = numberList;

        integers.add(11);
        integers.add(15);

        // integers.add(5.5); нельзя добавлять элементы других типов


    }
}
