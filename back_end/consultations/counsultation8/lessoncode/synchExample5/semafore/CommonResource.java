package synchExample5.semafore;

public class CommonResource {
    int x = 0;

    public int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }
    public synchronized void increment() {
        x++;
    }
}
