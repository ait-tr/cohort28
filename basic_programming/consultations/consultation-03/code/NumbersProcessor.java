package consultation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 7/20/2023
 * Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class NumbersProcessor {
    /**
     * Метод, который возвращает список чисел, собранных по определенному условию
     * @param numbers входной список чисел
     * @param integerPredicate условие для фильтрации
     * @return список чисел, удовлетворяющих условию <code>integerPredicate</code>
     */
    public List<Integer> filter(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        List<Integer> filtered = new ArrayList<>(); // список отфильтрованных чисел

        for (int number : numbers) { // пробегаемся по исходному списку
            if (integerPredicate.test(number)) { // мы не знаем, как именно будет реализован test, но нам все равно
                filtered.add(number); // закидываем число в список, если метод дал true
            }
        }

        return filtered; // возвращаем результат
    }
}
