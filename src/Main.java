//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        System.out.println("Books loaded: " + lib.getBooks().size());
        System.out.println("Users loaded: " + lib.getUsers().size());

        lib.borrowBook("learyn", "1");
        lib.returnBook("learyn", "1");
    }
}
