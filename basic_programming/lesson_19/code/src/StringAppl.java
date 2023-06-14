package ait.string;

import java.util.Scanner;

public class StringAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = scanner.next();
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str2 == str4);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str4));
    }
}
