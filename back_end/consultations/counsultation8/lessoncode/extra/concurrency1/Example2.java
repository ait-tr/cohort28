package extra.concurrency1;

// Пример применения CountDownLatch в процессе отправления людей в отпуск, у нас 8 человек, которые
// желают отправиться в отпуск. В аэропорту они выполняют обычные действия, такие как регистрация,
// сдача багажа. Делают они это по отдельности, а после этого уже группой садятся в самолет и вылетают


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Example2 {
    public static void main(String[] args) throws Exception {


        // список людей, кто желает полететь на отдых
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        CountDownLatch countDownLatch = new CountDownLatch(personNames.length);

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new PersonInAirport(personNames[i], countDownLatch)).start();
            Thread.sleep(1000);
        }

        int numPassengers = 10; // Количество пассажиров
        int numPermits = 5; // Количество разрешений Semaphore

        Semaphore semaphore = new Semaphore(numPermits);

        for (int i = 1; i <= numPassengers; i++) {
            String personName = "Пассажир " + i;
            PersonInAirport2 person = new PersonInAirport2(personName, semaphore);
            Thread thread = new Thread(person);
            thread.start();
        }

    }
}
