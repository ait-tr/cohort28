package ait.mystring.model;

import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {

    // поля
    private StringBuilder str;
    private int size; // размер коллекции
    private int currPos; // позиция курсор

    // конструктор
    public MyStringIterator(StringBuilder str){
        this.str = str;
        size = str.length();
//        currPos = 0;
    }

    // методы
    @Override
    public boolean hasNext() {
        return currPos < size;
    }

    @Override
    public Character next() {
        Character curCharacter = str.charAt(currPos);
        currPos++;
        return curCharacter;
    }

    @Override
    public void remove() {
        str.deleteCharAt(--currPos);
        size--;
    }
}
