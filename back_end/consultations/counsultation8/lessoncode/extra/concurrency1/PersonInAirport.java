package extra.concurrency1;


import java.util.concurrent.CountDownLatch;

class PersonInAirport implements Runnable {
    private String personName;
    private CountDownLatch countDownLatch;

    public PersonInAirport(String personName, CountDownLatch countDownLatch) {
        this.personName = personName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            // список дел, которые буду выполнены в рамках каждого потока (человека) самостоятельно
            System.out.println("-> " + personName + " приехал в аэропорт.");
            System.out.println("[!] " + personName + " сдал багаж");
            System.out.println("[!] " + personName + " пошел перекусить");

            countDownLatch.countDown();

            System.out.println("Count = " + countDownLatch.getCount());
            System.out.println();
            countDownLatch.await();



            // финальное - выполнится то, что находится после await() метода
            System.out.println(personName + " группой вылетел на отдых");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

