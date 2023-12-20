package demo1;

public class CountDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterRunnable(counter));
        Thread thread2 = new Thread(new CounterRunnable(counter));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

       // Thread.sleep(100);


        System.out.println("Count = " + counter.getCount());
    }
}
