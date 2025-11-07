package mk.ukim.finki.wp.lab.model;

public class BookReservation {
    private String bookTitle;
    private String readerName;
    private String readerAddress;
    private Long numberOfCopies;

    public BookReservation(String bookTitle,String readerName,String readerAddress,Long numberOfCopies) {
        this.bookTitle = bookTitle;
        this.readerName=readerName;
        this.readerAddress=readerAddress;
        this.numberOfCopies= numberOfCopies;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }
    public String getReaderName(){
        return readerName;
    }
    public void setReaderAddress(String readerAddress){
        this.readerAddress = readerAddress;
    }
    public String getReaderAddress(){
        return readerAddress;
    }
    public void setNumberOfCopies(Long numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
    public Long getNumberOfCopies() {
        return numberOfCopies;
    }
}
