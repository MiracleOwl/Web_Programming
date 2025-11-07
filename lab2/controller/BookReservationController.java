package mk.ukim.finki.wp.lab.controller;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
public class BookReservationController {
    private final BookReservationService reservationService;
    public BookReservationController(BookReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping
    public String reserveBook(@RequestParam String bookTitle,
                              @RequestParam String readerName,
                              @RequestParam String readerAddress,
                              @RequestParam Long numCopies,
                              HttpServletRequest request,
                              Model model) {
        String clientIp = request.getRemoteAddr();
        BookReservation reservation = reservationService.placeReservation(
                bookTitle, readerName, readerAddress, numCopies
        );
        model.addAttribute("reservation", reservation);
        model.addAttribute("clientIp", clientIp);

        return "reservationConfirmation";
    }
}
