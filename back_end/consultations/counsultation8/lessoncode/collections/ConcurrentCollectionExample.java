package collections;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCollectionExample {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();

        // Создание и запуск двух потоков для записи данных
        Thread writerThread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                set.add(i);
            }
        });

        Thread writerThread2 = new Thread(() -> {
            for (int i = 10000; i < 20000; i++) {
                set.add(i);
            }
        });

        // Создание и запуск двух потоков для чтения данных
        Thread readerThread1 = new Thread(() -> {
            for (Integer data : set) {
                System.out.println("Reader Thread 1: " + data);
            }
        });

        Thread readerThread2 = new Thread(() -> {
            for (Integer data : set) {
                System.out.println("Reader Thread 2: " + data);
            }
        });

        writerThread1.start();
        writerThread2.start();

        // Даем потокам время для выполнения записи данных
        writerThread1.join();
        writerThread2.join();

        System.out.println(set);

        readerThread1.start();
        readerThread2.start();
    }
}
