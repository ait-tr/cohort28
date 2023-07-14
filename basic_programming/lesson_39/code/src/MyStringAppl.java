package ait.mystring;

import ait.mystring.model.MyString;

import java.util.Iterator;

public class MyStringAppl {
    public static void main(String[] args) {
        MyString myString = new MyString("Two beer, or not two beer"); // создаем объект нового класса
        System.out.println(myString);
        Iterator<Character> iterator = myString.iterator(); // объявляем переменную типа Iterator

        while (iterator.hasNext()) {
            char c = iterator.next();
            if (c == 'e') {
                iterator.remove();
            }
        }


//        Wrong way!!!
//        for (char c: myString) {
//            if(c == 'e'){
//                myString.removeChar(c);
//            }
//        }
        System.out.println(myString);

//        for (Character c: myString) {
//            System.out.println(Character.toUpperCase(c));
//        }


//        Iterator<Character> iterator = myString.iterator();
//        while (iterator.hasNext()){
//            char c = iterator.next();
//            System.out.println(Character.toUpperCase(c));
//        }


//        myString.addChar('!');
//        System.out.println(myString);
//        myString.removeChar('r');
//        System.out.println(myString);
//        StringBuilder builder = myString.getStr();
//        for (int i = 0; i < builder.length(); i++) {
//            char c = builder.charAt(i);
//            c = Character.toUpperCase(c);
//            System.out.println(c);
//        }
//        builder.setLength(3);
//        System.out.println(builder);
//        System.out.println(myString);
    }
}
