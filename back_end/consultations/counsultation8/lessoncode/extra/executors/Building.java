package extra.executors;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Building implements Runnable {
    private String city;
    private CountDownLatch latch;
    private String[] stages;
    private boolean printDateWithSeconds;

    public Building(CountDownLatch latch, String city, String[] stages, boolean printDateWithSeconds) {
        this.city = city;
        this.latch = latch;
        this.stages = stages;
        this.printDateWithSeconds = printDateWithSeconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < stages.length; i++) {
            if (printDateWithSeconds)
                System.out.println(city + ": " + stages[i] + ", " + Thread.currentThread().getName() + " " + new Date());
            else
                System.out.println(city + ": " + stages[i] + ", " + Thread.currentThread().getName());
            latch.countDown();

            // можно показать без sleep, но лучше видно с этим параметром
            try {
                Thread.sleep((long)(Math.random()*1500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*
---
        newSingleThreadExecutor()

// Имитация работы строительной компании, у которой техники хватает только на 1 объект.
// Строительная компания, у которой есть объекты для строительства в разных городах (4 штуки)
// На каждый объект одни и те же стадии строительства.

---
        newFixedThreadPool()


// Строительная компания, у которой есть объекты для строительства в разных городах (4 штуки)
// На каждый объект одни и те же стадии строительства.


---
        newCachedThreadPool()


// Строительная компания, у которой есть объекты для строительства в разных городах (4 штуки)
// На каждый объект одни и те же стадии строительства.

// Создаём пул через newCachedThreadPool, через который работают 4 задачи

// Когда мы создаем пул потоков с помощью этого метода, максимальный размер пула потоков устанавливается на
// максимальное целочисленное значение в Java. Этот метод создает новые потоки по запросу и разрушает потоки,
// которые простаивают больше минуты, если запрос отсутствует.

---
        newScheduledThreadPool()

// Строительная компания, у которой есть объекты для строительства в разных городах (4 штуки)
// На каждый объект одни и те же стадии строительства.

// Создаём пул исполнения через newScheduledThreadPool, который может планировать выполнение задач после заданной
// задержки или через регулярные промежутки времени. Данный пример с использованием метода schedule(), но могут
// быть другие варианты с использованием методов scheduleAtFixedRate() и scheduleWithFixedDelay()

// здесь можно отследить по времени задержку запуска работы с тем или иным городом



 */