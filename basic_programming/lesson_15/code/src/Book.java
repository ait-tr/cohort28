package ait.book.model;

public class Book {
    private long isbn;
    private String title;
    private String author;
    private int yearOfPublishing;

    public Book(long isbn, String title, String author, int yearOfPublishing) {
        this.isbn = checkIsbn(isbn);
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(long isbn, String title, int yearOfPublishing) {
        this.isbn = checkIsbn(isbn);
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        author = "unknown";
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setIsbn(long isbn) {
        this.isbn = checkIsbn(isbn);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    private long checkIsbn(long isbn) {
        if (isbn >= 1_000_000_000_000L && isbn <= 9_999_999_999_999l) {
            return isbn;
        }
        return -1;
    }

    public void display() {
        System.out.println("ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Year: " + yearOfPublishing);
    }
}
