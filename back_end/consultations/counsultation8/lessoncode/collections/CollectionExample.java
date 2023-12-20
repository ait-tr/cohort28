package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectionExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 100;
        int numberOfElements = 1000000;

        List<Integer> myArrayList = new ArrayList<>();

        List<Thread> concurrentList = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                synchronized (myArrayList) {
                    for (int j = 0; j < numberOfElements; j++) {
                        myArrayList.add(j);
                    }
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

        long myArrayListTime = endTime - startTime;

        System.out.println("Time array list = " + myArrayListTime);



    }
}
