package multi.multithreading;

public class WaitExample {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
            System.out.println("thread");
        };

        Thread taskThread = new Thread(task);
        taskThread.start();

        // ждем и после этого забираем себе лок оповещаем и отдаем лок

        Thread.currentThread().sleep(3000);

        System.out.println("Main");
        synchronized (lock) {
            lock.notify();
        }
    }
}
