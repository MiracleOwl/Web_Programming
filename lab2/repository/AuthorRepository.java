package mk.ukim.finki.wp.lab.repository;

import java.util.List;
import java.util.ArrayList;
import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {
    private final List<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        authors.add(new Author("J.K.", "Rowling", "UK", "Author of Harry Potter"));
        authors.add(new Author("George", "Orwell", "UK", "Author of 1984 and Animal Farm"));
        authors.add(new Author("Leo", "Tolstoy", "Russia", "Author of War and Peace"));
    }
    public List<Author> findAll() {
        return authors;
    }
}
