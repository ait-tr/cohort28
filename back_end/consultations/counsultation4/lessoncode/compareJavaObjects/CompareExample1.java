package compareJavaObjects;

import java.util.TreeSet;

public class CompareExample1 {
    public static void main(String[] args) {
        TreeSet<String> ourSet = new TreeSet<>();

        ourSet.add("Boris");
        ourSet.add("Zigmund");
        ourSet.add("John");
        ourSet.add("Alex");
        ourSet.add("Elena");

        System.out.println(ourSet);
    }
}
