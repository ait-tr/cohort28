package lesson14;

import java.util.ArrayList;
import java.util.List;

public class DeleteFromListExample {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("AAA");
        strings.add("BBB");
        strings.add("CCC");
        strings.add("DDD");
        strings.add("EEE");

        String stringForRemove = "CCC";

        System.out.println(strings);

        for (String myString:strings) {
            if (myString.equals(stringForRemove)) {
                strings.remove(stringForRemove);
            }
        }

//        {
//            String currentString = strings.get(i);
//            if (currentString.equals(stringForRemove)) {
//                strings.remove(stringForRemove);
//                //break;
//            }
//        }

        System.out.println(strings);

    }
}
