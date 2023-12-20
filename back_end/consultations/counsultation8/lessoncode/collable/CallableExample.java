package collable;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callableTask = () -> {
            Thread.sleep(2000);
            return 42;
        };

        Future<Integer> future = executorService.submit(callableTask);

        System.out.println("Ждем результат...");

        // Блокируем поток до получения результата
        Integer result = future.get();

        System.out.println("Результат: " + result);

        executorService.shutdown();
    }
}

