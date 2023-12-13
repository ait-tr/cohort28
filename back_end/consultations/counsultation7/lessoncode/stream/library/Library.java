package stream.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        init();
    }

    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Оруэлл", "1984", 2021));
        books.add(new Book("Оруэлл2", "1985", 2021));
        books.add(new Book("Оруэлл3", "1986", 2020));
        books.add(new Book("Оруэлл2", "1990", 2021));
        books.add(new Book("Оруэлл4", "1900", 2020));
        books.add(new Book("Оруэлл7", "1954", 2021));
        books.add(new Book("Оруэлл", "1924", 2022));
        books.add(new Book("Оруэлл", "1914", 2022));
        //и так далее для других книг

        readers = new ArrayList<>();
        readers.add(new Reader("Иванов Иван Иванович", "ivanov.email@test.eu", true));
        readers.add(new Reader("Иванов2 Иван2 Иванович2", "ivanov2.email@tes2t.eu", false));
        //и так далее для других читателей

        readers.get(0).getBooks().add(books.get(0));
        readers.get(0).getBooks().add(books.get(1));
        readers.get(0).getBooks().add(books.get(2));
        readers.get(0).getBooks().add(books.get(3));
        readers.get(0).getBooks().add(books.get(4));
        readers.get(1).getBooks().add(books.get(5));
        readers.get(1).getBooks().add(books.get(6));
        readers.get(1).getBooks().add(books.get(7));

        //и так далее для других читателей и взятых книг
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}