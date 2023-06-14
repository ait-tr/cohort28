package ait.goat.model;

public class Goat {
    private int count;
    public final int max;

    public static final int GOAT_LIMIT = 100;

    public Goat(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    //    public void setMax(int max){
//        this.max = max;
//    }
    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
