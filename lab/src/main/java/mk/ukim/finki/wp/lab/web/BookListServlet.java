/*package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet", urlPatterns = "/books")
public class BookListServlet extends HttpServlet {
    private final BookService bookService;
    private final SpringTemplateEngine springTemplateEngine;

    public BookListServlet(BookService bookService, SpringTemplateEngine springTemplateEngine) {
        this.bookService = bookService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.listAll();
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);
        WebContext context = new WebContext(webExchange);
        context.setVariable("books", books);
        springTemplateEngine.process("listBooks.html", context, response.getWriter());
    } }
     */
