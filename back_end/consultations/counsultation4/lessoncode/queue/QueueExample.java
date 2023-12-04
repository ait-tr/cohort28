package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        int time = 100;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <  time ; i++) {
            queue.add(i);
        }

        System.out.println(queue);

        for (int i = 0; i < time; i++) {
            int fromQueue = queue.poll();
            System.out.println(fromQueue);
        }

        System.out.println(queue);

    }
}
