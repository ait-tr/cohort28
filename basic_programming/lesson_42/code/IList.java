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

    default boolean remove(Object o) { // удаление конкретного объекта в списке
        int index = indexOf(o); // получаем индекс этого элемента
        if (index < 0) { // если вернулось -1
            return false; // вернем false (сообщаем, что ничего не удалили)
        }
        remove(index); // если мы элемент нашли, то удаляем его с помощью операции удаления по индексу
        return true; // возвращаем true
    }

    boolean add(int index, E element); // добавить на место с индексом (что добавить - element, куда добавить - index)

    E get(int index);  // получить элемент по индексу

    int indexOf(Object o); // узнать индекс

    int lastIndexOf(Object o); // получить последний индекс

    E remove(int index); // удалить элемент по его индексу

    E set(int index, E element); // назначить на место = индексу элемент, element - чем хотим заменить, index - в какой позиции хотим заменить
}