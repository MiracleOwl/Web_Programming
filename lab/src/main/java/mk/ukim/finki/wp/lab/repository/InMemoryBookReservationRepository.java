package mk.ukim.finki.wp.lab.repository;


import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository{
    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }
    @Override
    public List<BookReservation> findAllByBookTitle(String bookTitle) {
        return DataHolder.reservations.stream()
                .filter(r -> r.getBookTitle().equalsIgnoreCase(bookTitle))
                .collect(Collectors.toList());
    }

}
