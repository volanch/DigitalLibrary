package Controller;

import Entity.Book;
import Repository.Interface.IBooksRepository;

import java.util.List;

public class BookController {
    private final IBooksRepository repo;

    public BookController(IBooksRepository repo) {
        this.repo = repo;
    }
    public String createBook(String title, String author, int year) {
        Book book = new Book(title, author, year);

        boolean created = repo.createBook(book);

        return (created ? "Book Created" : "Book Not Created");
    }

    public String getBook(int id) {
        Book book = repo.getBook(id);

        return (book != null ? book.getTitle() : "Book Not Found");
    }

    public String getAllBooks() {
        List<Book> books = repo.getAllBooks();
        return (books != null ? books.toString() : "Books Not Found");
    }

    public String deleteBook(int id) {
        boolean deleted = repo.deleteBook(id);
        return (deleted ? "Book Deleted" : "Book Not Found");
    }

    public String updateBook(int id, String title) {
        boolean updated = repo.updateBook(id, title);
        return (updated ? "Book Updated" : "Book Not Updated");
    }
}
