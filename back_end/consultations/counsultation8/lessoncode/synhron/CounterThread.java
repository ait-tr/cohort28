package synhron;

public class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        //System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();

        }
        //System.out.println(Thread.currentThread().getName() + " finished");
    }
}
