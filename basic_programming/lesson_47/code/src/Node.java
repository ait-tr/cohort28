package ait.list.model;

public class Node<E> {
    Node<E> prev;
    E data;
    Node<E> next;

    public Node(Node<E> prev, E data, Node<E> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
