package interrupt;

import java.util.concurrent.TimeUnit;

public class InterruptedExample3 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                //===========
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Interrupt");
                Thread.currentThread().interrupt();
            }
                //===========
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}
