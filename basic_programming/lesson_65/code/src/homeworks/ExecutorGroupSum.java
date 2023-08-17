package ait.numbers.model;

import ait.numbers.task.OneGroupSum;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ExecutorGroupSum extends GroupSum {
    public ExecutorGroupSum(int[][] numberGroups) {
        super(numberGroups);
    }

    @Override
    public int computeSum() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        List<OneGroupSum> groupSums = Arrays.stream(numberGroups)
                .map(OneGroupSum::new)
                .peek(executorService::execute)
                .collect(Collectors.toList());
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return groupSums.stream().mapToInt(OneGroupSum::getSum).sum();
    }
}
