package lessons.lesson27.extra.concurrency1;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.Phaser;

public class ForceTerminationPaserDemo {
    public static void main(String[] args) throws InterruptedException {


        Phaser phaser = new Phaser(1);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Task(phaser));
            thread.start();

        }

        Thread.sleep((5000));

        //phaser.forceTermination();
        System.out.println("Main : фазер завершен.");

    }

   static class Task implements Runnable {
        private Phaser phaser;

        public Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " Фаза 1");
            phaser.arriveAndAwaitAdvance();

            System.out.println("Thread " + Thread.currentThread().getName() + " Фаза 2");
            phaser.arriveAndAwaitAdvance();

            System.out.println("Thread " + Thread.currentThread().getName() + " Фаза 3");
            phaser.arriveAndAwaitAdvance();

            System.out.println("Thread " + Thread.currentThread().getName() + " Фаза 4");
            phaser.arriveAndAwaitAdvance();

        }
    }
}
