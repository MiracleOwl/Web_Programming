package mk.ukim.finki.wp.lab.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Book {

    private Long id;
    private String title;
    private String genre;
    private double averageRating;
    private Author author;
    private int likes;

    public Book(String title, String genre, double averageRating) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
    }
    public Book() {}

    public void like() {
        this.likes++;
    }
}
