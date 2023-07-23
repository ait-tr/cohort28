package ait.list.interfaces;

public interface IList<E> extends Iterable<E> {
    int size(); // знать размер (кол-во элементов в листе)

    default boolean isEmpty() {
        return size() == 0;
    } // проверка на то, что пустой или уже чем-то заполнен

    void clear(); // удаляет все элементы, нужен для очистки

    default boolean contains(Object o) {
        return indexOf(o) >= 0;
    } // проверка, а есть ли такой элемент

    boolean add(E element); // добавить элемент, самый важный и нужный метод


    default boolean remove(Object o) { // удаление конкретного объкта в списке
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    boolean add(int index, E element); // добавить на место с индексом

    E get(int index);  // получить элемент по индексу

    int indexOf(Object o); // узнать индекс

    int lastIndexOf(Object o); //

    E remove(int index); // удалить элемент по его индексу

    E set(int index, E element); // назначить на место = индексу элемент
}
