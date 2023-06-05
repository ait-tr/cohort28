package ait.string;

public class StringAppl {
    public static void main(String[] args) {
        char c = 65;
        System.out.println(c);
        char b = 'a';
        System.out.println(b);
        int x = 'C' - 'A';
        System.out.println(x);
        x = b - c;
        System.out.println(x);
        System.out.println("===================");
        x = 'f';
        System.out.println(x);
//        for (char i = 'A'; i < 'Z'; i++) {
//            System.out.println(i);
//        }
        System.out.println("========= String ==========");
        String str = "Hello";
        System.out.println(str);
        str = str + " world"; // concatenation
        System.out.println(str);
        str = 8 + 1 + str + 8 + 1;
        System.out.println(str);
        greeting("Peter");
        greeting("John");
    }

    public static void greeting(String name){
        String str = "Welcome " + name + "!";
        System.out.println(str);
    }
}
