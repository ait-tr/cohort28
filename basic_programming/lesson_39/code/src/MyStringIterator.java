package ait.mystring.model;

import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {
    private StringBuilder str;
    private int size;
    private int currPos;

    public MyStringIterator(StringBuilder str){
        this.str = str;
        size = str.length();
//        currPos = 0;
    }
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
