package interrupt;

public class InterruptedExample4 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());

            while (!Thread.currentThread().isInterrupted()) {
                // Do some work
            }
            System.out.println("Finished");
        };

        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();

    }
}
