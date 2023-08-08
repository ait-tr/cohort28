package consultation;

import java.util.ArrayList;
import java.util.List;

public class BookAppl {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        Book[] book = new Book[5];

        book[0] = new Book("Три мушкетера", "А. Дюма", 1856, 8);
        book[1] = new Book("Три товарища", "Ремарк", 1939, 9);
        book[2] = new Book("Старик и море", "Э. Хеменгуэй", 1952, 6);
        book[3] = new Book("Властелин колец", "Толкиен", 2000, 10);
        book[4] = new Book("Гарри Поттер", "Роулинг", 2005, 10);

//
        for (int i = 0; i < book.length; i++) {
        books.add(book[i]);
        }
        // печать
        books.stream().forEach(System.out::println);
        //
        books.stream().filter(x -> x.getRating() > 8).forEach(System.out::println);
        books.stream().filter(x-> x.getRating() > 8).sorted().forEach(System.out::println);
        System.out.println("==========Average rating=============");
        double averageRating = books.stream().mapToDouble(Book::getRating).average().orElse(0.0);

        System.out.println(averageRating);

    }
}
