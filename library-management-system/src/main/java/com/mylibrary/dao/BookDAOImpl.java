package com.mylibrary.dao;

import com.mylibrary.model.Book;
import com.mylibrary.model.Author;
import com.mylibrary.model.Category;
import com.mylibrary.model.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/library_db";  // Your DB URL
    private static final String USER = "root";                                  // DB username
    private static final String PASSWORD = "password";                          // DB password

    // Establish a connection to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public Book getById(long id) {
        Book book = null;
        String sql = "SELECT b.*, a.name AS author_name, c.name AS category_name, p.name AS publisher_name " +
                     "FROM book b " +
                     "JOIN author a ON b.author_id = a.id " +
                     "JOIN category c ON b.category_id = c.id " +
                     "JOIN publisher p ON b.publisher_id = p.id " +
                     "WHERE b.id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Author author = new Author(rs.getLong("author_id"), rs.getString("author_name"), null);
                Category category = new Category(rs.getLong("category_id"), rs.getString("category_name"));
                Publisher publisher = new Publisher(rs.getLong("publisher_id"), rs.getString("publisher_name"), null);
                book = new Book(rs.getLong("id"), rs.getString("title"), author, category, publisher,
                                rs.getDate("publish_date"), rs.getString("isbn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT b.*, a.name AS author_name, c.name AS category_name, p.name AS publisher_name " +
                     "FROM book b " +
                     "JOIN author a ON b.author_id = a.id " +
                     "JOIN category c ON b.category_id = c.id " +
                     "JOIN publisher p ON b.publisher_id = p.id";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Author author = new Author(rs.getLong("author_id"), rs.getString("author_name"), null);
                Category category = new Category(rs.getLong("category_id"), rs.getString("category_name"));
                Publisher publisher = new Publisher(rs.getLong("publisher_id"), rs.getString("publisher_name"), null);
                Book book = new Book(rs.getLong("id"), rs.getString("title"), author, category, publisher,
                                     rs.getDate("publish_date"), rs.getString("isbn"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void save(Book book) {
        String sql = "INSERT INTO book (title, author_id, category_id, publisher_id, publish_date, isbn) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, book.getTitle());
            stmt.setLong(2, book.getAuthor().getId());
            stmt.setLong(3, book.getCategory().getId());
            stmt.setLong(4, book.getPublisher().getId());
            stmt.setDate(5, new java.sql.Date(book.getPublishDate().getTime()));  // Convert to SQL Date
            stmt.setString(6, book.getIsbn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book book) {
        String sql = "UPDATE book SET title = ?, author_id = ?, category_id = ?, publisher_id = ?, publish_date = ?, isbn = ? " +
                     "WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, book.getTitle());
            stmt.setLong(2, book.getAuthor().getId());
            stmt.setLong(3, book.getCategory().getId());
            stmt.setLong(4, book.getPublisher().getId());
            stmt.setDate(5, new java.sql.Date(book.getPublishDate().getTime()));  // Convert to SQL Date
            stmt.setString(6, book.getIsbn());
            stmt.setLong(7, book.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM book WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> searchByKeyword(String keyword) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT b.*, a.name AS author_name, c.name AS category_name, p.name AS publisher_name " +
                     "FROM book b " +
                     "JOIN author a ON b.author_id = a.id " +
                     "JOIN category c ON b.category_id = c.id " +
                     "JOIN publisher p ON b.publisher_id = p.id " +
                     "WHERE b.title LIKE ? OR a.name LIKE ? OR c.name LIKE ? OR p.name LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            String searchTerm = "%" + keyword + "%";
            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);
            stmt.setString(3, searchTerm);
            stmt.setString(4, searchTerm);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Author author = new Author(rs.getLong("author_id"), rs.getString("author_name"), null);
                Category category = new Category(rs.getLong("category_id"), rs.getString("category_name"));
                Publisher publisher = new Publisher(rs.getLong("publisher_id"), rs.getString("publisher_name"), null);
                Book book = new Book(rs.getLong("id"), rs.getString("title"), author, category, publisher,
                                     rs.getDate("publish_date"), rs.getString("isbn"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
