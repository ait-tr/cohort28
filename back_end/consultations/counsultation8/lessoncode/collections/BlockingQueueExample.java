package collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Создаем блокирующую очередь размером 3
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // Создаем и запускаем производителя
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producer добавляет элемент: " + i);
                    queue.put(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();

        // Создаем и запускаем потребителя
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer element = queue.take();
                    System.out.println("Consumer извлекает элемент: " + element);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        consumer.start();
    }
}

