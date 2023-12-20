package synchExample5.countDown;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownEx {
    public static void main(String[] args) {
        int numbersOfThread = 15;
        int numberOfCount = 5;
        CountDownLatch cdl = new CountDownLatch(numberOfCount);

        /*
        Предположим что мы создали и запустили 15 потоков
        поток1 - поток 15

        поток2.join()
        поток5.join()
        поток7.join()
        поток9.join()
        поток11.join()

        в чем отличие?
         */

        for (int i = 0; i < numbersOfThread; i++) {
            Thread worker = new Thread(new Worker(i, cdl));
            worker.start();
        }
        try {
            cdl.await();
            System.out.println("Все потоки завершили свою работу");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    static class Worker implements Runnable {

        private final int idWorker;
        private final CountDownLatch cdl;

        public Worker(int idWorker, CountDownLatch cdl) {
            this.idWorker = idWorker;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("Поток " + idWorker + " начинает работу");

            try{
                Random random = new Random();
                Thread.sleep(random.nextInt(2000,3000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Поток " + idWorker + " завершает работу");
            cdl.countDown();

        }
    }
}
