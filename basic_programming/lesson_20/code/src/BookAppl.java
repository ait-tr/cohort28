package ait.book;

import ait.book.dao.Library;
import ait.book.model.Book;

public class BookAppl {
    public static void main(String[] args) {
        Library library = new Library(10);
        library.addBook(new Book(2000000000000l, "Book0", 1988));
        library.addBook(new Book(3000000000000l, "Book1", "Author1", 1998));
        System.out.println(library.getSize());
        library.addBook(new Book(4000000000000l, "Book2", "Author1", 1995));
        library.addBook(new Book(5000000000000l, "Book3", "Author2", 1990));
        library.addBook(new Book(6000000000000l, "Book4", 1981));
        System.out.println(library.getSize());
        System.out.println(library.addBook(new Book(6000000000000l, "Book44", 1987)));
        System.out.println(library.getSize());
        library.printBooks();
        Book book = library.findBook(5000000000000l);
        System.out.println(book);
        book = library.findBook(9000000000000l);
        System.out.println(book);
        book = library.removeBook(3000000000000l);
        System.out.println(library.getSize());
        book = null;
        library.printBooks();
    }
}
