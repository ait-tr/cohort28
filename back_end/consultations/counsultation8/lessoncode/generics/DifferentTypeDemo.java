package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferentTypeDemo {
    public static void main(String[] args) {
        DifferentTypeExample<String> stringExample = new DifferentTypeExample<>();
        List<String> list = Arrays.asList("test", "test2");
        stringExample.test(list);

        DifferentTypeExample<String> stringExample2 = new DifferentTypeExample<>();
        Set<String> set = new HashSet<>();
        set.add("Test");
        set.add("TEST@");
        stringExample2.test(set);
    }
}
