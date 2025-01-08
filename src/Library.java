import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
            System.out.println(" * " + book);
        }
    }

    public List<Book> filterByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    public List<Book> searchByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }

    public List<Book> sortByYear() {
        return books.stream().sorted(Comparator.comparingInt(Book::getYear)).collect(Collectors.toList());
    }
}
