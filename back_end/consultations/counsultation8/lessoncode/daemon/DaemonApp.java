package daemon;

public class DaemonApp {
    public static void main(String[] args) {

        var worker = new Thread(() -> {
                try {
                    Thread.sleep(5000);
        } catch (InterruptedException exception) {
                    exception.printStackTrace();
        }
          var threadName = Thread.currentThread().getName();
        System.out.println("Thread name is executing: " + threadName);
        }, "Worker");

        var daemon = new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                var threadName = Thread.currentThread().getName();
                System.out.println("Thread is executing with name : " + threadName);
            }
        }, "Daemon");

        daemon.setDaemon(true);
        worker.start();
        daemon.start();


        var threadName = Thread.currentThread().getName();
        System.out.println("Thread is executing with name : " + threadName);



    }
}
