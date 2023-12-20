package volatileExample;

public class SharedApp {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread thread1 = new Thread(() -> {
            sharedData.setFlag();
        });

        Thread thread2 = new Thread(() -> {
            sharedData.doSomething();
        });

        thread1.start();
        thread2.start();
    }
}
