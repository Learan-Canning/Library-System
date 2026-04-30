public class Book {

    // Setting Data types :)
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;
    private int loanCount;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }

    // Constructor for above
    public Book(String id, String title, String author, boolean isBorrowed, int loanCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
        this.loanCount = loanCount;
        }

        //Book Saving. - Converts the book into a CSV line so it can be saved to books.csv
    public String toCSV() {
        return id + "," + title + author + "," + isBorrowed + "," + loanCount;
    }
}