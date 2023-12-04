package dequeue;

import java.util.ArrayDeque;

public class DequeueExample {
    public static void main(String[] args) {

        ArrayDeque<String> states = new ArrayDeque<>();

        states.add("Germany");
        System.out.println(states);
        states.addFirst("France");
        System.out.println(states);
        states.push("Great Britain");
        System.out.println(states);
        states.addLast("Spain");
        System.out.println(states);
        states.add("Greece");
        System.out.println(states);


        String myState = states.getFirst();
        System.out.println(myState);




    }
}
