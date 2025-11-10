package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Book;
import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(Long id);
    Book update(Book book);
    Book save(Book book);
    void deleteById(Long id);
}
