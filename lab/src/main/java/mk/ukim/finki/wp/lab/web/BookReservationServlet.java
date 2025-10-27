package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;

import java.io.IOException;

@WebServlet(name="bookReservationServlet", urlPatterns = "/bookReservation" )
public class BookReservationServlet extends HttpServlet {

    private final BookReservationService reservationService;

    public BookReservationServlet(BookReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String bookTitle = request.getParameter("bookTitle");
        String readerName = request.getParameter("readerName");
        String readerAddress = request.getParameter("readerAddress");
        Long numberOfCopies = Long.parseLong(request.getParameter("numberOfCopies"));

        String clientIp = request.getRemoteAddr();

        BookReservation reservation = reservationService.placeReservation(bookTitle, readerName, readerAddress, numberOfCopies);

        request.setAttribute("reservation", reservation);
        request.setAttribute("clientIp", clientIp);

        request.getRequestDispatcher("/reservationConfirmation.html").forward(request, response);
    }
}
