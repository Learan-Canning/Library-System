public class Login {

    private Library library;

    public Login(Library library) {
        this.library = library;
    }

    // Authenticate user by User and Pass
    public User authenticate(String username, String password) {
        User user = library.findUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user; // login successful
        }

        return null; // login failed
    }

    // Check if a user is admin
    public boolean isAdmin(User user) {
        return user != null && user.isAdmin();
    }
}
