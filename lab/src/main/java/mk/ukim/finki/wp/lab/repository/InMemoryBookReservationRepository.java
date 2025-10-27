package mk.ukim.finki.wp.lab.repository;


import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository{
    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }
}
