package multi.multithreading;

public class CarAppWithRunnable {
    public static void main(String[] args) throws InterruptedException {

        CarWithRunnable ferrari = new CarWithRunnable("Ferrari");
        CarWithRunnable bmw = new CarWithRunnable("BMW");

        var ferrariThread = new Thread(ferrari, "Ferrari-Thread");
        var bmwThread = new Thread(bmw, "BMW-Thread");


        ferrariThread.start();
        bmwThread.start();

        //Thread.sleep(200);
        System.out.println("Method continues execution... Main method is executed by thread " +
                Thread.currentThread().getName());

    }
}
