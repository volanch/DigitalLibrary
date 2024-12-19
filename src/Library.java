import java.util.ArrayList;

public class Library {
    private String name;
    private final ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books available in " + name + ":");
        for (Book book : books) {
            System.out.println(" - " + book.getValues());
        }
    }
}
