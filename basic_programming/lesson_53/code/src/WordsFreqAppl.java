package ait.map;

import java.util.*;

public class WordsFreqAppl {
    public static void main(String[] args) {
        String[] words = {"abc", "ab", "limn", "limn", "ab", "limn", "a"};
        printWordsFrequency(words);
    }

    private static void printWordsFrequency(String[] words) {
        Map<String, Integer> res = new HashMap<>(); // объектная переменная, объект класса HashMap
        for (int i = 0; i < words.length; i++) { // проходим по словам
            if (res.containsKey(words[i])) {  // в качестве ключа принимается само слово
                res.put(words[i], res.get(words[i]) + 1); // кладем в HashMap пару Ключ, Значение
            } else {
                res.put(words[i], 1); // в HashMap кладем только Ключ, 1
            }
        }

        Set<Map.Entry<String, Integer>> entries = res.entrySet(); // перекладываем HashMap в Set
        System.out.println("===== Unsorted =====");
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("===== Sorted by value desc =====");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);
        list.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        list.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
