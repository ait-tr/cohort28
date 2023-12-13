package stream.library;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryUtils {

    public List<Book> doWithoutLambda(List<Book> books) {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getIssueYear().compareTo(o2.getIssueYear());
            }
        });
        return books;
    }

    public List<Book> doWithLambda(List<Book> books) {
        List<Book> list = books.stream()
                .sorted(Comparator.comparing(Book::getIssueYear))
                .collect(Collectors.toList());
        return list;
    }




    public void printBooks(List<Book> books){
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

}
