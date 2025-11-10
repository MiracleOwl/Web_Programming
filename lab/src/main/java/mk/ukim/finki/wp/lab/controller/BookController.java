package mk.ukim.finki.wp.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import java.util.ArrayList;

@Controller
public class BookController {

    @GetMapping("/")
    public String redirectToBooks() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("books", DataHolder.books);
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        } else {
            model.addAttribute("hasError", false);
        }
        return "listBooks";
    }

    @PostMapping("/books/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Book book = new Book(title, genre, averageRating);
        book.setId((long) (Math.random() * 1000));
        DataHolder.books.add(book);
        return "redirect:/books";
    }

    @PostMapping("/books/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Book bookToEdit = DataHolder.books.stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElse(null);
        if (bookToEdit != null) {
            bookToEdit.setTitle(title);
            bookToEdit.setGenre(genre);
            bookToEdit.setAverageRating(averageRating);
        }
        return "redirect:/books";
    }

    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        DataHolder.books.removeIf(book -> book.getId().equals(id));
        return "redirect:/books";
    }

    @GetMapping("/book-form")
    public String getAddBookPage(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", new ArrayList<>());
        return "book-form";
    }

    @GetMapping("/book-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        Book book = DataHolder.books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (book == null) {
            return "redirect:/books?error=BookNotFound";
        }
        model.addAttribute("book", book);
        model.addAttribute("authors", new ArrayList<>());
        return "book-form";
    }

    @PostMapping("/books/{id}/like")
    public String likeBook(@PathVariable Long id) {
        Book book = DataHolder.books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (book != null) {
            book.like();
        }
        return "redirect:/books";
    }
}
