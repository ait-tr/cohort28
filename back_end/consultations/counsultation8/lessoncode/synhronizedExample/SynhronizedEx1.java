package synhronizedExample;

public class SynhronizedEx1 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                System.out.println("thread");
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        Thread.sleep(1);

        synchronized (lock) {
            for (int i = 0; i < 8; i++) {
                System.out.println(thread.getState());
                Thread.currentThread().sleep(1000);
                System.out.println(" " + i);
            }
            System.out.println(".....");
        }
    }
}
