public class MyTaskImplements implements Runnable{

    String name;
    int max;
    @Override
    public void run() {

        for (int i = 0; i < max; i++) {
            System.out.println("Task" + name + ", count = " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " task stopped." );
    }

}
