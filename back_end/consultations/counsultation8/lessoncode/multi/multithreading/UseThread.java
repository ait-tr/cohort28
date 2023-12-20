package multi.multithreading;

public class UseThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("Hello  world!");
                    System.out.println("Finish thread");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        //--------- закончилось описание создания нового потока ---------
        // -------- запуск выполнения моего кода -----------------------
        System.out.println("Start program");
        System.out.println("Pause 5 sec");
        thread.start();
        Thread.sleep(5000);
        System.out.println("Finish program");
        int count = 0;

        for (int i = 0; i < 500000000; i++) {
            count++;
        }
        System.out.println(count);

    }


}
