package multi.multithreading;

public class MyRunnableDemo1 {
    public static void main(String[] args) {
        Thread myNewThread = new Thread(new MyRunnable1());
        myNewThread.start();


    }
}
