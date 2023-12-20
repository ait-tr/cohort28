package extra.concurrency1;

// пример применения Semaphore в работе небольшого ресторана, в котором всего 5 столиков, но в людей, желающих
// пообедать больше, чем свободных столов

import java.util.concurrent.Semaphore;

public class Example1 {
    public static void main(String[] args) throws Exception {

        int numberOfTables = 5;

        // устанавливая флаг true, Semaphore будет раздавать разрешения в порядке очереди
        Semaphore semaphore = new Semaphore(numberOfTables, true);

        // свободные столики (5 штук) - по умолчанию создаются с параметром false
        // true - занято, false - свободно
        boolean[] freeTables = new boolean[numberOfTables];

        // список людей, кто желает пообедать в этом ресторане
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new Person(personNames[i], semaphore, freeTables)).start();
            Thread.sleep(700);
        }

    }
}