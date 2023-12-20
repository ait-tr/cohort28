package multi.multithreading;

public class ThreadExampleWithLambda {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread is running"));
        thread.start();
    }
}
