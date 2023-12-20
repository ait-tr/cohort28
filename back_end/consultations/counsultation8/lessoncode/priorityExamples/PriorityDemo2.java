package priorityExamples;

public class PriorityDemo2 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        Thread thread1 = new Thread(()->{
            System.out.println("User thread 1 is running");
            Thread.currentThread().setName("My name");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
        });

        Thread thread2 = new Thread(()->{
            System.out.println("User thread 2 is running");
            Thread.currentThread().setName("My name");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getPriority());
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();

    }
}
