package interrupt;

public class InterruptedExample8 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
                // восстанавливаем флаг прерывания
                Thread.currentThread().interrupt();
            }
        });

        thread.start();
        // Прерываем поток через 5000 миллисек если он еще не завершился

        Thread.sleep(5000);

        if (thread.isAlive()) {
            thread.interrupt();
        }
    }
}