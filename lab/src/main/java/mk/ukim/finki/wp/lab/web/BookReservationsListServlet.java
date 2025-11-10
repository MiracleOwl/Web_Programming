/*
package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "bookReservationsListServlet", urlPatterns = "/bookReservations")
public class BookReservationsListServlet extends HttpServlet {

    private final BookReservationService bookReservationService;

    public BookReservationsListServlet(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String bookTitle = req.getParameter("bookTitle");
        List<BookReservation> reservations = bookReservationService.getReservationsForBook(bookTitle);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Reservations for " + bookTitle + "</title></head><body>");
        out.println("<h1>Reservations for book: " + bookTitle + "</h1>");
        out.println("<table border='1'><tr><th>Reader Name</th><th>Address</th><th>Copies</th></tr>");

        for (BookReservation r : reservations) {
            out.println("<tr>");
            out.println("<td>" + r.getReaderName() + "</td>");
            out.println("<td>" + r.getReaderAddress() + "</td>");
            out.println("<td>" + r.getNumberOfCopies() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<br><a href='/'>Back to books</a>");
        out.println("</body></html>");
    }
}
*/