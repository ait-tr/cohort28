package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"Привет", "как", "дела?");

//        Comparator<String> comparator = new StringLengthComparator();
//
//        class StringLengthComparator implements Comparator<String> {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        Comparator<String> comparator2 = (String o1, String o2) -> { return o1.length() - o2.length();};

        Comparator<String> comparator3 = (o1, o2) -> o1.length() - o2.length();


        Collections.sort(list,comparator1);

        Collections.sort(list,(o1,o2) -> o1.length() - o2.length());

        System.out.println(list);
    }
}
