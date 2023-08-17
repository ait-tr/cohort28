package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

import java.util.Arrays;

public class ThreadGroupSum extends GroupSum {
    public ThreadGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
        Thread[] threads = new Thread[numberGroups.length];
        OneGroupSum[] groupSums = new OneGroupSum[numberGroups.length];
        startThreads(threads, groupSums);
        return computeTotalSum(threads, groupSums);
    }

    private int computeTotalSum(Thread[] threads, OneGroupSum[] groupSums) {
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return Arrays.stream(groupSums).mapToInt(OneGroupSum::getSum).sum();
    }

    private void startThreads(Thread[] threads, OneGroupSum[] groupSums) {
        for (int i = 0; i < groupSums.length; i++) {
            groupSums[i] = new OneGroupSum(numberGroups[i]);
            threads[i] = new Thread(groupSums[i]);
            threads[i].start();
        }
    }
}
