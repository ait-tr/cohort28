package synchExample3;

public class SynhronizedEx1 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    System.out.println("thread started");
                    Thread.sleep(1000);
                    System.out.println("thread finished ");
                } catch (InterruptedException e) {

                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        //Thread.sleep(1);

        synchronized (lock) {
            for (int i = 0; i < 8; i++) {
                //System.out.println(thread.getState());
                Thread.currentThread().sleep(1000);
                System.out.print(" " + i);
            }
            System.out.println(".....");
        }
    }
}
