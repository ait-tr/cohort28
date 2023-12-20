package atomic;


import java.util.LinkedList;
import java.util.Queue;

public class ConcurrentQueue<T> {
    private Queue<T> queue = new LinkedList<>();

    public synchronized void enqueue(T element) {
        queue.add(element);
    }

    public synchronized T dequeue() {
        return queue.poll();
    }
}
