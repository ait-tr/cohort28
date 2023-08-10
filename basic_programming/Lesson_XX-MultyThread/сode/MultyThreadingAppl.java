
public class MultiThreadingAppl {

    private static final int MAX = 10;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAin thread started");
        MyTaskImplements task1 = new MyTaskImplements("TaskImpements", MAX);
        for (int i = 0; i < MAX; i++) {
            System.out.println("Task" + name + ", count = " + i);
            Thread.sleep(1);
        }
        System.out.println(name + " task stopped." );
    }
}
