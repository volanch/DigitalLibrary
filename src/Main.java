public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("\"Death on the Nile\"", "Agatha Christie", 1937);
        Book book2 = new Book("\"1984\"", "George Orwell", 1949);
        Book book3 = new Book("\"It\"", "Stephen King", 1986);


        System.out.println("Book Details:");
        System.out.println(book1.getValues());
        System.out.println(book2.getValues());
        System.out.println(book3.getValues());


        LibraryUser user1 = new LibraryUser("Alice", 101);
        LibraryUser user2 = new LibraryUser("Bob", 102);


        System.out.println("\nLibrary Users:");
        System.out.println(user1.getValues());
        System.out.println(user2.getValues());


        Library library1 = new Library("Astana IT University Library");
        Library library2 = new Library("Eurasian University Library");

        System.out.println(library1.getName());


        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2);
        library2.addBook(book3);


        System.out.println("\nAvailable Books:");
        library1.displayBooks();
        library2.displayBooks();


        System.out.println("\nComparing book1 and book2: " + book1.equals(book2));
    }
}
