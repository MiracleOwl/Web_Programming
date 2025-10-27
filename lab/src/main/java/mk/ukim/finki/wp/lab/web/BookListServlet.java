package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import mk.ukim.finki.wp.lab.service.BookService;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;
import java.io.IOException;

@WebServlet(name="bookListServlet",urlPatterns = "/")
public class BookListServlet extends HttpServlet {

    private final BookService bookService;

    public  BookListServlet(BookService bookService) {
        this.bookService = bookService;
    }
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        List<Book> books = bookService.listAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/listbooks.html").forward(request,response);
    }
}
