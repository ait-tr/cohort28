package stream.library;

import java.util.List;

public class AppLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        LibraryUtils lUtils = new LibraryUtils();

        lUtils.printBooks(lUtils.doWithLambda(library.getBooks()));

        System.out.println("==================");


        List<Reader> readers = library.getReaders();

//        for (int i = 0; i < readers.size(); i++) {
//            Reader reader = readers.get(i);
//            System.out.println("ФИО: " + reader.getFio());
//            System.out.println("email: " + reader.getEmail());
//            System.out.println("subscriber Y/N: " + (reader.isSubscriber() ? "Yes" : "No"));
//            reader.getBooks().stream()
//                    .peek(book -> System.out.println("Название книги: " + book.getName() + ", Автор: " + book.getAuthor()))
//                    .toList();
//
//        }
//
//        readers.stream()
//                .peek(reader -> {
//                    System.out.println("ФИО: " + reader.getFio());
//                    System.out.println("email: " + reader.getEmail());
//                    System.out.println("subscriber Y/N: " + (reader.isSubscriber() ? "Yes" : "No"));
//                    reader.getBooks().stream()
//                            .peek(book -> System.out.println("Название книги: " + book.getName() + ", Автор: " + book.getAuthor()))
//                            .toList();
//                }).toList();

        readers.forEach(reader -> {
            System.out.println("ФИО: " + reader.getFio());
            System.out.println("email: " + reader.getEmail());
            System.out.println("subscriber Y/N: " + (reader.isSubscriber() ? "Yes" : "No"));
            reader.getBooks().forEach(
                    book -> System.out.println("Название книги: " + book.getName() + ", Автор: " + book.getAuthor()));
        });
    }
}
