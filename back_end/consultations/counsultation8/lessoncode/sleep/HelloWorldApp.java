package sleep;

public class HelloWorldApp {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                int secToWait = 60 * 1000;
                Thread.currentThread().sleep(secToWait);
                System.out.println("Wake up!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
