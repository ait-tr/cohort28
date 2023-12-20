package interrupt;

public class InterruptExample {
    public static void main(String[] args) {
        Thread tr = new Thread(() -> {
            boolean flag = true;
            while (flag) {
                System.out.println("Working ...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Exception!");
                    flag = false;
                }
            }
        });

        tr.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tr.interrupt();
    }
}
