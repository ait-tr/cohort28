package multi.multithreading;

public class Car extends Thread{

    private final String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void run(){
        try{
            System.out.println("Start! " + getName());
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("Car " + model + " is being driven by tread  " + Thread.currentThread().getName());
    }

}
