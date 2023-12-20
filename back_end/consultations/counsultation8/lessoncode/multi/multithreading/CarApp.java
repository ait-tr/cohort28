package multi.multithreading;

public class CarApp {
    public static void main(String[] args) throws InterruptedException {

        var ferrari = new Car("Ferrari");
        Car bmw = new Car("BMW");

        ferrari.start();
        bmw.start();

        Thread.sleep(200);
        System.out.println("Method continues execution... Main method is executed by thread " +
                Thread.currentThread().getName());

    }
}
