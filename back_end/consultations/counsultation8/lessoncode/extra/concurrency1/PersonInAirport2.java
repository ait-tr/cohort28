package lessons.lesson27.extra.concurrency1;


import java.util.concurrent.Semaphore;

class PersonInAirport2 implements Runnable {
    private String personName;
    private Semaphore semaphore;

    public PersonInAirport2(String personName, Semaphore semaphore) {
        this.personName = personName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            // список дел, которые буду выполнены в рамках каждого потока (человека) самостоятельно
            System.out.println("-> " + personName + " приехал в аэропорт.");
            System.out.println("[!] " + personName + " сдал багаж");
            System.out.println("[!] " + personName + " успел перекусить");

            semaphore.acquire(); // Запрашиваем разрешение

            // фраза о вылете группой
            System.out.println(personName + " группой вылетел на отдых");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Освобождаем разрешение
        }
    }
}

