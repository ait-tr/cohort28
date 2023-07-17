import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements IList<E> {

    // поля
    private Object[] elements; // непосредственно хранилище элементов, массив типа Object (либо с параметризацией)
    private int size; // количество элементов, не путать с размером массива! одновременно - это позиция, куда нужно добавить элемент при вызове add

    public MyArrayList() {
        this(10); // конструктор, который создает первоначальный массив длины 10
    }

    public MyArrayList(int initialCapacity) { // конструктор с параметром, который принимает начальный размер массива
        if (initialCapacity < 0) { // если начальный размер - отрицательное число - выбрасываем ошибку
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);
        }
        // создаем массив нужного размера
        elements = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // TODO:
        // придумать, как удалить элементы массива (цикл)
        // size изменить на 0
    }

    @Override
    public boolean add(E element) {
        ensureCapacity(); // нам нужно гарантировать, что места хватит, поэтому вызываем данный метод
        elements[size] = element; // добавляем элемент в конец списка
        size++; // увеличиваем размер массива
        return true;
    }

    private void ensureCapacity() { // увеличивает размер массива
        if (size == elements.length) { // если количество элементов совпало с размером массива
            if (size == Integer.MAX_VALUE) { // если мы дошли до максимального целого - выбрасываем ошибку
                throw new OutOfMemoryError();
            }
            int newCapacity = elements.length + elements.length / 2; // новая длина - в полтора раза больше предыдущей, можно написать elements.length >> 1
            if (newCapacity < 0) { // если было переполнение - то просто берем максимальное целое
                newCapacity = Integer.MAX_VALUE;
            }
            // создаем копию массива нового размера
            // внутри происходит копирование всех элементов
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public boolean add(int index, E element) {
        //TODO
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index); // проверяем адекватный ли индекс
        return (E) elements[index]; // возвращаем его
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) { // проверяем, нормальный ли индекс
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public int indexOf(Object o) {
        if (o != null) { // если ненулевой элемент
            for (int i = 0; i < size; i++) { // пробегаем все элементы массива
                if (o.equals(elements[i])) { // сравниваем через equals, если нашли элемент
                    return i; // возвращаем результат - индекс этого элемента
                }
            }
        } else {
            for (int i = 0; i < size; i++) { // если передали null, значит ищем null
                if (o == elements[i]) { // сравниваем через обычное ==, потому что equals у null вызвать нельзя
                    return i; // возвращаем индекс null-а
                }
            }
        }

        return -1; // если ничего не нашли, возвращаем -1
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