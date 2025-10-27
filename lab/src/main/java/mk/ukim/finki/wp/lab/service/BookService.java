package mk.ukim.finki.wp.lab.service;

import java.util.List;
import mk.ukim.finki.wp.lab.model.Book;

public interface BookService{
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
}
