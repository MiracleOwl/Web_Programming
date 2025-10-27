package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }
    @Override
    public List<Book> searchBooks(String text, Double rating)
    {
        return DataHolder.books.stream()
                .filter(b -> {
                    boolean hasText = b.getTitle().toLowerCase().contains(text.toLowerCase());
                    boolean meetsRating = b.getAverageRating() >= rating;
                    return hasText && meetsRating;
                })
                .collect(Collectors.toList());
    }
}
