package ait.list;

import ait.list.interfaces.IList;
import ait.list.model.MyArrayList;
import ait.list.model.MyLinkedList;

public class ListAppl {
    public static void main(String[] args) {
        IList<Integer> list = new MyLinkedList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(5);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add(null);
        list.add(7);
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(4));
//        System.out.println(list.get(7));
        System.out.println(list.indexOf(3));
        System.out.println(list.indexOf(7));
        System.out.println(list.contains(5));
        System.out.println(list.contains(-5));
        System.out.println(list.indexOf(5));
        System.out.println(list.indexOf(null));
//        int num = list.set(5, 11);
//        System.out.println(num);
//        System.out.println(list.get(5));
//        System.out.println(list.size());
//        num = list.remove(2);
//        System.out.println(list.size());
//        System.out.println(num);
//        System.out.println("==================");
//        System.out.println(list.remove((Integer) 11));
//        System.out.println(list.size());
//        for (Integer n : list) {
//            System.out.println(n);
//        }
//        System.out.println("======== List of String ==========");
//        IList<String> myList = new MyArrayList<>();
//        myList.add("Boston");
//        myList.add("Atlanta");
//        myList.add("Chicago");
//        myList.add("Boston");
//        myList.add("New York");
//        System.out.println(myList.size());
//        System.out.println(myList.get(3));
//        System.out.println(myList.indexOf("Boston"));
//        System.out.println(myList.remove(0));
//        System.out.println(myList.size());
//        System.out.println(myList.remove("Boston"));
//        System.out.println(myList.contains("Boston"));
//        System.out.println(myList.add(2, "Boston"));
//        System.out.println(myList.size());
//        System.out.println(myList.get(2));
//        for (String str : myList) {
//            System.out.println(str);
//        }
//        myList.clear();
//        System.out.println(myList.size());
    }
}
