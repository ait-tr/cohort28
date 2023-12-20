package interrupt;

public class InterruptedExample7 implements Runnable{

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                System.out.println("Thread is running");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                //Thread.currentThread().interrupt();
            }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptedExample7 ie = new InterruptedExample7();
        Thread thread = new Thread(ie);
        thread.start();

        Thread.sleep(5000);

        thread.interrupt();
    }

}
