package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;
import mk.ukim.finki.wp.lab.model.Author;
import java.util.List;
import java.util.ArrayList;

@Component
public class DataHolder {
    public static List<Book> books;
    public static List<BookReservation> reservations;
    public static List<Author> authors;

    @PostConstruct
    public void init(){
        books = new ArrayList<>();
        reservations = new ArrayList<>();
        authors = new ArrayList<>();

        Author jkRowling = new Author("J.K.", "Rowling", "UK", "Author of Harry Potter");
        Author georgeOrwell = new Author("George", "Orwell", "UK", "Author of 1984 and Animal Farm");
        Author leoTolstoy = new Author("Leo", "Tolstoy", "Russia", "Author of War and Peace");

        authors.add(jkRowling);
        authors.add(georgeOrwell);
        authors.add(leoTolstoy);

        books.add(new Book("The Hobbit", "Fantasy", 4.8));
        books.add(new Book("1984", "Dystopia", 4.6));
        books.add(new Book("Pride and Prejudice", "Romance", 4.7));
        books.add(new Book("To Kill a Mockingbird", "Drama", 4.9));
        books.add(new Book("The Catcher in the Rye", "Fiction", 4.3));
        books.add(new Book("The Great Gatsby", "Classic", 4.5));
        books.add(new Book("Harry Potter", "Fantasy", 4.9));
        books.add(new Book("Moby Dick", "Adventure", 4.2));
        books.add(new Book("War and Peace", "Historical", 4.4));
        books.add(new Book("The Lord of the Rings", "Fantasy", 4.9));
    }

}
