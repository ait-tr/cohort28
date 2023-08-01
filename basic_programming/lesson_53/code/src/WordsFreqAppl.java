package ait.map;

import java.util.*;

public class WordsFreqAppl {
    public static void main(String[] args) {
        String[] words = {"abc", "ab", "limn", "limn", "ab", "limn", "a"};
        printWordsFrequency(words);
    }

    private static void printWordsFrequency(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (res.containsKey(words[i])) {
                res.put(words[i], res.get(words[i]) + 1);
            } else {
                res.put(words[i], 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = res.entrySet();
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
