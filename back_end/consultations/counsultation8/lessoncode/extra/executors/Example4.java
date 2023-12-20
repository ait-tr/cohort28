package lessons.lesson27.extra.executors;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example4 {
    public static void main(String[] args) {

        String[] stages = new String[]{
                "1.Проектная деятельность", "2.Старт строительных работ",
                "3.Финиш строительных работ", "4.Отделочные работы"
        };

        CountDownLatch cd1 = new CountDownLatch(stages.length);
        CountDownLatch cd2 = new CountDownLatch(stages.length);
        CountDownLatch cd3 = new CountDownLatch(stages.length);
        CountDownLatch cd4 = new CountDownLatch(stages.length);

        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);

        System.out.println("Запуск потоков " + new Date());

        es.schedule(new Building(cd1, "Dusseldorf", stages, true), 3, TimeUnit.SECONDS);
        es.schedule(new Building(cd2, "Cologne", stages, true), 4, TimeUnit.SECONDS);
        es.schedule(new Building(cd3, "Dortmund", stages, true), 5, TimeUnit.SECONDS);
        es.schedule(new Building(cd4, "Essen", stages, true), 6, TimeUnit.SECONDS);

//        es.execute(new Building(cd1, "Dusseldorf", stages));
//        es.execute(new Building(cd2, "Cologne", stages));
//        es.execute(new Building(cd3, "Dortmund", stages));
//        es.execute(new Building(cd4, "Essen", stages));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        es.shutdown();
        System.out.println("Завершение потоков");

    }
}
