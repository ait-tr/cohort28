package ait.set.model;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements ISet<E> {
    private LinkedList<E>[] hashset;
    private int size;
    private int capacity;
    private double loadFactor;

    public MyHashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        hashset = new LinkedList[capacity];
    }

    public MyHashSet(int capacity) {
        this(capacity, 0.75);
    }

    public MyHashSet() {
        this(16, 0.75);
    }

    //O(1)
    @Override
    public boolean add(E element) {
        if (size >= capacity * loadFactor) {
            rebuildArray();
        }
        int index = getIndex(element);
        if (hashset[index] == null) {
            hashset[index] = new LinkedList<>();
        }
        if (hashset[index].contains(element)) {
            return false;
        }
        hashset[index].add(element);
        size++;
        return true;
    }

    private void rebuildArray() {
        capacity = capacity * 2;
        LinkedList<E>[] newHashSet = new LinkedList[capacity];
        for (int i = 0; i < hashset.length; i++) {
            if (hashset[i] != null) {
                for (E e : hashset[i]) {
                    int index = getIndex(e);
                    if (newHashSet[index] == null) {
                        newHashSet[index] = new LinkedList<>();
                    }
                    newHashSet[index].add(e);
                }
            }
        }
        hashset = newHashSet;
    }

    private int getIndex(E element) {
        int hashcode = element.hashCode();
        hashcode = hashcode >= 0 ? hashcode : -hashcode;
        return hashcode % capacity;
    }

    //O(1)
    @Override
    public boolean contains(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }
        return hashset[index].contains(element);
    }

    //O(1)
    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if (hashset[index] == null) {
            return false;
        }
        boolean res = hashset[index].remove(element);
        if (res) {
            size--;
        }
        return res;
    }

    //O(1)
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i;
            int j;
            int totalCounter;

            @Override
            public boolean hasNext() {
                return totalCounter < size;
            }

            @Override
            public E next() {
                while (hashset[i] == null || hashset[i].isEmpty()) {
                    i++;
                }
                E res = hashset[i].get(j);
                totalCounter++;
                if (j < hashset[i].size() - 1) {
                    j++;
                } else {
                    j = 0;
                    i++;
                }
                return res;
            }
        };
    }
}
