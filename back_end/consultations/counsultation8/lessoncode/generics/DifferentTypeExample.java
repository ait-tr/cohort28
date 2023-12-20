package generics;

import java.util.Collection;

public class DifferentTypeExample<T> {

    public <T> void test(Collection<T> collection){
        for (T element : collection) {
            System.out.println(element);
        }
    }

//    public void test(List<Integer> collection){
//        for (Integer element : collection) {
//            System.out.println(element);
//        }
//    }
}
