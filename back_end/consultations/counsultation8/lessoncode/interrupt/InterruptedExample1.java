package interrupt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterruptedExample1 {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            BufferedReader reader = null;
            try {
                System.out.println(Thread.currentThread().getName());
                reader = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (Thread.interrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    System.out.println("Read: " + line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                   reader.close();
                } catch (IOException e) {
                    System.out.println("Error while closing reader " + e.getMessage());
                }
            }
        }, "My thread");

        t.start();
        Thread.sleep(5000);

        t.interrupt();
    }
}
