import Entity.Book;
import Controller.BookController;
import Data.PostgresDB;
import Data.Interface.IDB;
import Repository.BooksRepository;
import Repository.Interface.IBooksRepository;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(1, "Death on the Nile", "Agatha Christie", 1937);
        Book book2 = new Book(2, "1984", "George Orwell", 1949);
        Book book3 = new Book(3, "It", "Stephen King", 1986);
        Book book4 = new Book(4, "Animal Farm", "George Orwell", 1949);


        System.out.println("Entity.Book Details:");
        System.out.println(book1.getDetails());
        System.out.println(book2.getDetails());
        System.out.println(book3.getDetails());


        LibraryUser user1 = new LibraryUser("Alice", 101);
        LibraryUser user2 = new LibraryUser("Bob", 102);


        System.out.println("\nLibrary Users:");
        System.out.println(user1.getDetails());
        System.out.println(user2.getDetails());


        Library library1 = new Library("Astana IT University Library");
        Library library2 = new Library("Eurasian University Library");

        System.out.println("\n" + library1.getName());


        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2);
        library2.addBook(book3);


        System.out.println("\nAvailable Books:");
        library1.displayBooks();
        library2.displayBooks();

        System.out.println("\nBooks by Agatha Christie:");
        library1.filterByAuthor("Agatha Christie").forEach(System.out::println);

        System.out.println("\nSearching for a book called '1984':");
        library1.searchByTitle("1984").forEach(System.out::println);

        System.out.println("\nBooks sorted by year in Astana IT University Library:");
        library1.sortByYear().forEach(System.out::println);

        System.out.println("Comparing books one and four by year of publication: " + book1.equals(book4));

        System.out.println(book1.hashCode());


        IDB db = new PostgresDB();
        IBooksRepository repo = new BooksRepository(db);
        BookController controller = new BookController(repo);
        App app = new App(controller);
        app.start();
    }
}
