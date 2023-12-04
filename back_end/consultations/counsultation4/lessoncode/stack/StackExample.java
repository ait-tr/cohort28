package stack;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        /*
        push - добавить элемент в коллекцию
        pop - вытащить элемент сверху стека

        peek - "копирует" верхний элемент стека, но не "вытаскивает" его (не удаляет элемент из коллекции)
        search - есть ли такой элемент в коллекции и на какой глубине он лежит
        empty - говорит пустая ли коллекция или нет
         */

        stack.push("I");
        stack.push(" love");
        stack.push(" Java!");

        System.out.println(stack);

        System.out.println(stack.search("I"));

        System.out.println("The element at the top of the stack is: " + stack.pop());

        System.out.println(stack);

        System.out.println("The element at the top of the stack is: " + stack.pop());

        System.out.println(stack);

        System.out.println("The element at the top of the stack is: " + stack.pop());

        System.out.println(stack);

        System.out.println(stack.empty());

//        System.out.println("The element at the top of the stack is: " + stack.pop());
//
//        System.out.println(stack);

    }
}
