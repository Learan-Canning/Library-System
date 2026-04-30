public class Book {

    // Setting Data types :)
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;
    private int loanCount;


    // Constructor for above
    public Book(String id, String title, String author, boolean isBorrowed, int loanCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.loanCount = loanCount;
        }
}