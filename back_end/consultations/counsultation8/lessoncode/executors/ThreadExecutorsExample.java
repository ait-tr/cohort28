package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutorsExample {
    public static void main(String[] args) {
        // создадим сервис с помощью executor
        // который будет решать задачи в пуле из 5 потоков

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable task1 = () -> {
            System.out.println("Задача номер 1 запущена и выполняется");
        };

        Runnable task2 = () -> {
            System.out.println("Задача номер 2 запущена и выполняется");
        };

        Runnable task3 = () -> {
            System.out.println("Задача номер 3 запущена и выполняется");
        };

        Runnable task4 = () -> {
            System.out.println("Задача номер 4 запущена и выполняется");
        };

        Runnable task5 = () -> {
            System.out.println("Задача номер 5 запущена и выполняется");
        };
        Runnable task6 = () -> {
            System.out.println("Задача номер 6 запущена и выполняется");
        };
        Runnable task7 = () -> {
            System.out.println("Задача номер 7 запущена и выполняется");
        };

        for (int i = 0; i < 10; i++) {
            //System.out.println("БЛОК ЗАДАЧ № " + i);
            executorService.execute(task1);
            executorService.execute(task2);
            executorService.execute(task3);
            executorService.execute(task4);
            executorService.execute(task5);
            executorService.execute(task6);
            executorService.execute(task7);
        }

        executorService.shutdown();

    }

}
