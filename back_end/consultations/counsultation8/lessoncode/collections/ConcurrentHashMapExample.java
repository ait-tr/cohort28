package collections;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

		// Поток 1 записывает 100 элементов
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				String key = "Key" + i;
				int value = i;
				map.put(key, value);
			}
		});

		// Поток 2 записывает 100 элементов
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				String key = "Key" + (i + 100);
				int value = i + 100;
				map.put(key, value);
			}
		});

		// Запускаем оба потока
		thread1.start();
		thread2.start();

		// Ожидаем завершения обоих потоков
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Выводим содержимое коллекции
		map.forEach((key, value) -> System.out.println(key + " = " + value));
	}
}
