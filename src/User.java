import java.util.List;


public class User {

    //user details
    private String username;
    private String password;
    private boolean isAdmin;
    private List<String> loanedBooks;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<String> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(List<String> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }

    public void addLoanedBook(String bookId) {
        loanedBooks.add(bookId);
    }

    public void removeLoanedBook(String bookId) {
        loanedBooks.remove(bookId);
    }

    // Convert user to CSV line
    public String toCSV() {
        String loans = String.join("|", loanedBooks);
        return username + "," + password + "," + isAdmin + "," + loans;
    }

    //Constructor for above. - user data
    public User(String username, String password, boolean isAdmin, List<String> loanedBooks) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.loanedBooks = loanedBooks;
    }
}
