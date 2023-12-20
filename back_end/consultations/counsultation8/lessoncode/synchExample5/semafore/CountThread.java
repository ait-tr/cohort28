package synchExample5.semafore;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable{

    CommonResource res;
    Semaphore semaphore;
    String name;

    public CountThread(CommonResource res, Semaphore semaphore, String name) {
        this.res = res;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
      try{
          System.out.println(name + " ожидает получения разрешения ");
          semaphore.acquire();
          res.setX(1);
          for (int i = 0; i < 10; i++) {
              System.out.println(this.name + ": " + res.getX());
              res.increment();
              Thread.sleep(100);
          }
      }catch (InterruptedException e) {
          System.out.println(e.getMessage());
      }
        System.out.println(name + " освобождает полученное разрешение");
      semaphore.release();
    }
}
