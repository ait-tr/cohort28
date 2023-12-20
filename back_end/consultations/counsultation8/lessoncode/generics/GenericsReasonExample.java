package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsReasonExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("Hello");
        //list.add(123);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            String str = list.get(i);
        }
    }
}
