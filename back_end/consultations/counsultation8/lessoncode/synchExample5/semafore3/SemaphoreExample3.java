package synchExample5.semafore3;

import java.util.concurrent.Semaphore;

public class SemaphoreExample3 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);


        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new Worker(semaphore, "Поток №"+i));
            t1.start();
        }

    }


    static class Worker implements Runnable{
        private Semaphore semaphore;
        private String name;

        public Worker(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " ждет разрешения ");
                semaphore.acquire();
                System.out.println(name + " получил разрешение");
                // какой-то код
                Thread.sleep(2000);
                System.out.println(name + "освобождает разрешение");
                semaphore.release();
            } catch (InterruptedException e) {}
        }
    }
}
