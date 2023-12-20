package interrupt;

public class InterruptedExample6 implements Runnable{

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("Thread is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                //Thread.currentThread().interrupt();
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        InterruptedExample6 ie = new InterruptedExample6();
        Thread thread = new Thread(ie);
        thread.start();

        Thread.sleep(5000);

        thread.interrupt();
    }

}
