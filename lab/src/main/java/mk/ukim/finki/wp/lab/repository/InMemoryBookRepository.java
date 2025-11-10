package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;

import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }
    @Override
    public Book findById(Long id) {
        return DataHolder.books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @Override
    public Book save(Book book) {
        Book existing = findById(book.getId());
        if (existing != null) {
            existing.setTitle(book.getTitle());
            existing.setGenre(book.getGenre());
            existing.setAverageRating(book.getAverageRating());
            existing.setAuthor(book.getAuthor());
            return existing;
        }
        DataHolder.books.add(book);
        return book;
    }
    @Override
    public Book update(Book book) {
        Book b = findById(book.getId());
        if (b != null) {
            b.setTitle(book.getTitle());
            b.setGenre(book.getGenre());
            b.setAverageRating(book.getAverageRating());
            b.setAuthor(book.getAuthor());
        }
        return b;
    }
    @Override
    public void deleteById(Long id) {
        DataHolder.books.removeIf(b -> b.getId().equals(id));
    }
}
