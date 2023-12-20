package interrupt;

public class InterruptedExample5 implements Runnable{

    private boolean stop;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Thread is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                stop = true;
            }
        }
    }

    public void stopThread() { stop = true;}

    public static void main(String[] args) throws InterruptedException {
        InterruptedExample5 ie = new InterruptedExample5();
        Thread thread = new Thread(ie);
        thread.start();

        Thread.sleep(5000);

        //ie.stopThread(); - первый вариант

        thread.interrupt(); // - второй вариант
    }

}
