import java.util.*;
import java.io.*;

public class Library {

    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();

        loadBooks();
        loadUsers();
    }

    // Load all books from books.csv
    public void loadBooks() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String title = parts[1];
                String author = parts[2];
                boolean isBorrowed = Boolean.parseBoolean(parts[3]);
                int loanCount = Integer.parseInt(parts[4]);

                books.add(new Book(id, title, author, isBorrowed, loanCount));
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }

    // Load all users from users.csv
    public void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String username = parts[0];
                String password = parts[1];
                boolean isAdmin = Boolean.parseBoolean(parts[2]);

                List<String> loanedBooks = new ArrayList<>();
                if (parts.length > 3 && !parts[3].isEmpty()) {
                    loanedBooks = Arrays.asList(parts[3].split("\\|"));
                }

                users.add(new User(username, password, isAdmin, loanedBooks));
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public void saveBooks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.csv"))) {
            for (Book b : books) {
                writer.write(b.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }
    // save users to csv
    public void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.csv"))) {
            for (User u : users) {
                writer.write(u.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }

    }
    //find a book by id
    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }
    // find user by username
    public User findUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    //borrow a book
    public boolean borrowBook(String username, String bookId) {
        User user = findUserByUsername(username);
        Book book = findBookById(bookId);

        if (user == null || book == null) {
            return false;
        }

        if (book.isBorrowed()) {
            return false;
        }

        book.setBorrowed(true);
        book.setLoanCount(book.getLoanCount() + 1);
        user.addLoanedBook(bookId);

        saveBooks();
        saveUsers();

        return true;
    }
    //return a book
    public boolean returnBook(String username, String bookId) {
        User user = findUserByUsername(username);
        Book book = findBookById(bookId);

        if (user == null || book == null) {
            return false;
        }

        if (!book.isBorrowed()) {
            return false;
        }

        book.setBorrowed(false);
        user.removeLoanedBook(bookId);

        saveBooks();
        saveUsers();

        return true;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}
