package extra.concurrency1;

import java.util.concurrent.Semaphore;

class Person implements Runnable {
    private String personName;
    private Semaphore semaphore;
    private boolean[] freeTables;

    public Person(String personName, Semaphore semaphore, boolean[] freeTables) {
        this.personName = personName;
        this.semaphore = semaphore;
        this.freeTables = freeTables;
    }

    @Override
    public void run() {
        System.out.println("-> " + personName + " подошёл в ресторан.");
        try {
            // запрашивается доступ, если доступ не разрешён - поток ожидает разрешения
            semaphore.acquire();
            int parkingNumber = -1;

            synchronized (freeTables) {
                for (int i = 0; i < freeTables.length; i++) {
                    if (!freeTables[i]) {

                        // определяем место как занятое
                        freeTables[i] = true;

                        // наличие свободного места гарантирует Semaphore
                        parkingNumber = i;

                        System.out.println("[!] " + personName + " был размещён за столиком #" + (i + 1));
                        break;
                    }
                }
            }

            // время на приготовление ланча и его завершение
            Thread.sleep(5000);

            synchronized (freeTables) {
                freeTables[parkingNumber] = false;
            }

            semaphore.release();
            synchronized (freeTables) {
                System.out.println("<- " + personName + " закончил свой ланч и покинул ресторан");
                System.out.println("[!] столик " + (parkingNumber + 1) + " освободился");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}