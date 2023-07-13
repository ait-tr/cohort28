package ait.list.model;

import ait.list.interfaces.IList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements IList<E> {

    // поля
    private Object[] elements; // массив объектов
    private int size;  // размер этого массива

    public MyArrayList() {
//        elements = new Object[10];
        this(10); // это начальный размер любого  ArrayList
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);
        }
        elements = new Object[initialCapacity];
    }

    // методы этого класса

    //O(1)
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        //TODO
        // придумать, как удалить элементы массива (цикл)
        // size изменить на 0
    }

    //O(1)
    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            if (size == Integer.MAX_VALUE) {
                throw new OutOfMemoryError();
            }
            int newCapacity = elements.length + elements.length / 2;
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public boolean add(int index, E element) {
        //TODO
        return false;
    }

    //O(1)
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    //O(n)
    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o == elements[i]) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        //TODO
        return 0;
    }

    @Override
    public E remove(int index) {
        //TODO
        return null;
    }

    @Override
    public E set(int index, E element) {
        //TODO
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        //TODO
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
}
