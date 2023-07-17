import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 7/17/2023
 * SimpleProject
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Marsel");
        words.add("Sidikov");
        words.add("29");
        words.add("1.85");

        HashSet<String> names = new HashSet<>();
        names.add("Marsel");
        names.add("Lena");
        names.add("Igor");
        names.add("Marsel"); // Marsel второй раз добавлен не будет

//        System.out.println(names.get(0));

        // цикл, который делает последовательный обход списка
//        for (int i = 0; i < words.size(); i++) {
//            System.out.println(words.get(i));
//        }

//        Iterator<String> listIterator = words.iterator();
//
//        while (listIterator.hasNext()) {
//            System.out.println(listIterator.next());
//        }
//
//        Iterator<String> setIterator = names.iterator();
//
//        while (setIterator.hasNext()) {
//            System.out.println(setIterator.next());
//        }

        for (String word : words) {
            System.out.println(word);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
