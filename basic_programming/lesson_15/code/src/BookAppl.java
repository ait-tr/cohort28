package ait.book;

import ait.book.model.Book;

public class BookAppl {
    public static void main(String[] args) {
//        int[] arr = new int[5];
        Book[] books = new Book[5];
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
        books[0] = new Book(2000000000000l, "Book0", 1988);
        books[1] = new Book(3000000000000l, "Book1", "Author1", 1998);
        books[2] = new Book(4000000000000l, "Book2", "Author1", 1995);
        books[3] = new Book(5000000000000l, "Book3", "Author2", 1990);
        books[4] = new Book(6000000000000l, "Book4", 1981);
        printBooks(books);
        System.out.println("Oldest book");
        Book oldestBook = findOldestBook(books);
        oldestBook.display();
        System.out.println("Newest book");
        Book newestBook = findnewestBook(books);
        newestBook.display();
    }

    public static Book findOldestBook(Book[] books) {
        Book res = books[0];
        for (int i = 1; i < books.length; i++) {
            if (res.getYearOfPublishing() > books[i].getYearOfPublishing() && books[i].getYearOfPublishing() >= 0) {
                res = books[i];
            }
        }
        return res;
    }

    public static Book findnewestBook(Book[] books) {
        Book res = books[0];
        for (int i = 1; i < books.length; i++) {
            if (res.getYearOfPublishing() < books[i].getYearOfPublishing()) {
                res = books[i];
            }
        }
        return res;
    }

    public static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            books[i].display();
        }
    }
}
