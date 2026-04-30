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

    // Temporary getters so you can test loading
    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
}
