package ait.set;

import java.util.*;

public class SetAppl {
    public static void main(String[] args) {
        List<String> list = List.of("c", "ab", "abc", "b", "ab", "bd", "b");
        System.out.println("\tPrint List");
        list.forEach(s -> System.out.println(s));
        Set<String> hashset = new HashSet<>(3, 10);
        hashset.addAll(list);
        System.out.println("\tPrint HashSet");
        hashset.forEach(s -> System.out.println(s));
        List<String> uniqueList = new ArrayList<>(new HashSet<>(list));
        System.out.println("\tPrint Unique List");
        uniqueList.forEach(s -> System.out.println(s));
        TreeSet<String> treeSet = new TreeSet<>(list);
        System.out.println("\tPrint TreeSet");
        treeSet.forEach(s -> System.out.println(s));
        System.out.println("\tPrint TreeSet return one element");
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.ceiling("abd"));
        System.out.println(treeSet.ceiling("ca"));
        System.out.println(treeSet.floor("aba"));
        System.out.println("\tPrint TreeSet return subset");
        //treeSet.headSet("bd").forEach(s -> System.out.println(s));
        //treeSet.headSet("bd", true).forEach(s -> System.out.println(s));
        //treeSet.tailSet("abc").forEach(s -> System.out.println(s));
        //treeSet.tailSet("abc", false).forEach(s -> System.out.println(s));
        //treeSet.subSet("abc", "c").forEach(s -> System.out.println(s));
        treeSet.subSet("abc", false, "c", true).forEach(s -> System.out.println(s));
        System.out.println("\tPrint TreeSet comparator");
        TreeSet<String> setComparator = new TreeSet<>((s1, s2) -> {
            int res = Integer.compare(s1.length(), s2.length());
            return res != 0 ? res : s1.compareTo(s2);
        });
        setComparator.addAll(list);
        setComparator.forEach(s -> System.out.println(s));

    }
}
