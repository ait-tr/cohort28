package lessons.lesson27.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionExample2 {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 30;
        int numberOfElements = 10000;


        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();


        List<Thread> concurrentList = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < numberOfElements; j++) {
                    copyOnWriteArrayList.add(j);
                }
            });
            concurrentList.add(thread);
        }

        long startTime = System.currentTimeMillis();
        for (Thread thread : concurrentList) {
            thread.start();
        }

        for (Thread thread : concurrentList) {
            thread.join();
        }
        long endTime = System.currentTimeMillis();

        long concurrentLinkedQueueTime = endTime - startTime;

        System.out.println("Time cuncurrent array list = " + concurrentLinkedQueueTime);


    }
}
