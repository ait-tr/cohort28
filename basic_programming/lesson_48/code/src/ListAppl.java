package ait.list;

import java.util.*;

public class ListAppl {
    private static final int N_NUMBERS = 10;
    private static final int MIN = 10;
    private static final int MAX = 20;
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        fillList(list);
        printList(list);
//        NB! Wrong way!
//        for (Integer integer : list) {
//            if (integer == 15) {
//                list.remove(integer);
//            }
//        }

//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer >= 15) {
//                iterator.remove();
//            }
//        }

        list.removeIf(x -> x >= 15);

        printList(list);
    }

    private static void printList(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
        System.out.println();
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(MIN + random.nextInt(MAX - MIN));
        }
    }
}
