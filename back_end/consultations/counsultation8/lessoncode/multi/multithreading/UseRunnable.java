package multi.multithreading;

public class UseRunnable {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                Thread.sleep(500);
                System.out.println("Hello world!");
                System.out.println("Finish thread");
            } catch (InterruptedException err) {
                throw new RuntimeException(err);
            }

        };
        System.out.println("Start program");
        System.out.println("Pause 5 sec");

        Thread thread = new Thread(r);
        thread.start();

        System.out.println("Finish program");
        int count = 0;

        for (int i = 0; i < 500000000; i++) {
            count++;
        }
        System.out.println(count);
    }
}

