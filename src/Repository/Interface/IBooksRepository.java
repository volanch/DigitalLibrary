package Repository.Interface;
import Entity.Book;

import java.util.List;

public interface IBooksRepository {
    boolean createBook(Book book);
    Entity.Book getBook(int id);
    List<Book> getAllBooks();
    boolean updateBook(int id, String title);
    boolean deleteBook(int id);
}
