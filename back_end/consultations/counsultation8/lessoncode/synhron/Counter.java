package synhron;

public class Counter {

    private int counter = 0;

    public synchronized void increaseCounter() {
        counter++;
    }

    public int getCounter(){
        return counter;
    }
}
