package synchExample5.semafore2;

public class Consumer implements Runnable{

    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (true) {
                store.get();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());}

    }
}
