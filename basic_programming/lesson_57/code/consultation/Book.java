package consultation;

//Тема: Обработка коллекции книг с использованием Stream API
//
//        Представьте, что у вас есть коллекция книг. Каждая книга имеет следующие свойства: название, автор, год издания и рейтинг. Ваша задача - написать программу, используя Stream API, для выполнения следующих операций:
//
//        Создайте класс Book с соответствующими полями и методами доступа к ним.
//        Создайте список List<Book> и добавьте несколько книг в этот список.
//        Используя Stream API, отфильтруйте книги, оставив только те, у которых рейтинг выше 8.
//        Отсортируйте отфильтрованные книги по году издания, начиная с самых новых.
//        Найдите средний рейтинг всех книг в списке.
//        Создайте новую коллекцию, содержащую только названия всех книг.
//        Группируйте книги по автору и создайте карту (Map), в которой ключ - автор, а значение - список книг этого автора.
//        Это задание поможет вам практически ознакомиться с применением Stream API для обработки коллекций объектов, фильтрации, сортировки и агрегации данных.

public class Book implements Comparable<Book>{

    // поля класса
    private String name;
    private String author;
    private int age;
    private int rating;

    // конструктор
    public Book(String name, String author, int age, int rating) {
        this.name = name;
        this.author = author;
        this.age = age;
        this.rating = rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getAge() {
        return age;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}
