package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Service;
import mk.ukim.finki.wp.lab.model.Book;
import java.util.List;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.model.Author;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository,AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Book> listAll()
    {
        return bookRepository.findAll();
    }
    @Override
    public Book saveBook(String title, String genre, Double averageRating, Long authorId) {
        Author author = authorRepository.findAll().stream()
                .filter(a -> a.getId().equals(authorId))
                .findFirst()
                .orElse(null);
        Book book = new Book(title, genre, averageRating);
        return bookRepository.save(book);
    }
    @Override
    public Book editBook(Long bookId, String title, String genre, Double averageRating, Long authorId){
        Author author = authorRepository.findAll().stream()
                .filter(a -> a.getId().equals(authorId))
                .findFirst()
                .orElse(null);
        Book book = new Book( title, genre, averageRating);
        return bookRepository.update(book);
    }
    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book likeBook(Long bookId) {
        Book book = bookRepository.findAll().stream()
                .filter(b->b.getId().equals(bookId))
                .findFirst()
                .orElse(null);
        if(book==null)
        {
            throw new RuntimeException("Book not found");
        }
        book.like();

        return bookRepository.save(book);
    }
}
