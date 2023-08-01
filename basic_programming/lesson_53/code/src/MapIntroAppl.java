package ait.map;

import java.util.*;

public class MapIntroAppl {
    public static void main(String[] args) {
        Map<String, Integer> usa = new TreeMap<>();
        usa.put("Denver", 600_000);
        usa.put("Boston", 670_000);
        usa.put("Chicago", 2_700_000);
        usa.put("Atlanta", 470_000);
        usa.put("New York", 8_500_000);
        usa.put("Dallas", 1_300_000);
        System.out.println(usa.size());
        System.out.println(usa.isEmpty());
        Integer num = usa.get("Chicago");
        System.out.println(num);
        num = usa.get("Detroit");
        System.out.println(num);
        System.out.println(usa.containsKey("Boston"));
        System.out.println(usa.containsKey("Detroit"));
        num = usa.put("Chicago", 2_700_001);
        System.out.println(num);
        num = usa.get("Chicago");
        System.out.println(num);
        Collection<Integer> population = usa.values();
        int total = 0;
        for (Integer integer: population) {
            total += integer;
        }
        System.out.println(total);
        System.out.println("==========");
        // method 1 for TeeMap O(n log(n))
        Set<String> keys = usa.keySet();
        for (String key: keys) {
            System.out.println(key + " -> " + usa.get(key));
        }
        // method 2 for TreeMap O(n)
        Set<Map.Entry<String, Integer>> entries = usa.entrySet();
        for (Map.Entry<String, Integer> entry: entries) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
