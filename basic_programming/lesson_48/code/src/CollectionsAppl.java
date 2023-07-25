package ait.list;

import java.util.*;

public class CollectionsAppl {
    public static void main(String... args) {
//        List<String> technologies = new ArrayList<>();
//        technologies.add("Java");
//        technologies.add("JCF");
//        technologies.add("Git");
//        technologies.add("JUnit");
//        technologies.add("SQL");
//        technologies.add("MongoDB");
//        technologies.add("Spring");
//        technologies.add("Hibernate");
        String[] arr = {"Java", "JCF", "Git", "JUnit", "SQL", "MongoDB", "Spring", "Hibernate"};
//        List<String> technologies = Arrays.asList("Java", "JCF", "Git", "JUnit", "SQL", "MongoDB", "Spring", "Hibernate");
        List<String> technologies = new ArrayList<>(List.of("Java", "JCF", "Git", "JUnit", "SQL", "MongoDB", "Spring", "Hibernate"));
        technologies.forEach(t -> System.out.println(t));
        technologies.add("Kafka");
        technologies.set(0, "Java 11");
        technologies.forEach(t -> System.out.println(t));

//        for (String t: technologies) {
//            System.out.println(t);
//        }
        int res = sum(2, 3, 5, 7);
        System.out.println("result = " + res);
        System.out.println("===== Collections =====");
        System.out.println("===== Collections sort =====");
        Collections.sort(technologies);
        technologies.forEach(t -> System.out.println(t));
        int index = Collections.binarySearch(technologies, "JCF");
        System.out.println("index = " + index);
        index = Collections.binarySearch(technologies, "K8s");
        System.out.println("index = " + index);
        System.out.println("===== Collections sort by Comparator =====");
        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(technologies, comparator);
        technologies.forEach(t -> System.out.println(t));
        index = Collections.binarySearch(technologies, "SQL", comparator);
        System.out.println("index = " + index);
        index = Collections.binarySearch(technologies, "K8s", comparator);
        System.out.println("index = " + index);
    }

    public static int sum(int a, int b, int... rest) {
        int res = a + b;
        for (int i = 0; i < rest.length; i++) {
            res += rest[i];
        }
        return res;
    }
}
