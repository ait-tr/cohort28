package collable;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callableTask = () -> {
            throw new IllegalArgumentException("Некорректный аргумент");
        };

        Future<String> future = executorService.submit(callableTask);

        System.out.println("Ждем результат...");

        try {
            String result = future.get();
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Произошло исключение: " + e.getMessage());
        }

        executorService.shutdown();
    }
}

