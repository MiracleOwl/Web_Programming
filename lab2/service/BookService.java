package mk.ukim.finki.wp.lab.service;

import java.util.List;
import mk.ukim.finki.wp.lab.model.Book;

public interface BookService{
    List<Book> listAll();
    Book saveBook(String title, String genre, Double averageRating, Long authorId);
    Book editBook(Long bookId, String title, String genre, Double averageRating, Long authorId);
    void deleteBook(Long bookId);}
