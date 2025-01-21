package Repository;

import Data.Interface.IDB;
import Entity.Book;
import Repository.Interface.IBooksRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BooksRepository implements IBooksRepository {
    private final IDB db;

    public BooksRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createBook(Book book) {
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "INSERT INTO books(title, author, year) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getYear());

            stmt.execute();
            return true;

        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Book getBook(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, title, author, year FROM books WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"));
                return book;
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
        }

    @Override
    public List<Book> getAllBooks() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, title, author, year FROM books";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            List<Book> books = new LinkedList<>();
            while(rs.next()){
                Book book = new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year"));
                books.add(book);
            }
            return books;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean updateBook(int id, String title) {
        Connection con = null;
        try{
            con = db.getConnection();
            String sql = "UPDATE books SET title = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            System.out.println("Book updated successfully!");
            return true;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
    }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Book deleted successfully!");
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
