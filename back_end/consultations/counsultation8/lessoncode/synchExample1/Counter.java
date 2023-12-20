package synchExample1;

public class Counter {
    private long counter = 0L;

    public void increaseCounter() {
        synchronized (this) {
        counter++;}
    }

    public long getCounter() {
        return counter;
    }
}
