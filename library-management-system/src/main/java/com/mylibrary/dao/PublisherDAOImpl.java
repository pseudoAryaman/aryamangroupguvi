package com.mylibrary.dao;

import com.mylibrary.model.Publisher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAOImpl implements PublisherDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public Publisher getById(long id) {
        Publisher publisher = null;
        String sql = "SELECT * FROM publisher WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                publisher = new Publisher(rs.getLong("id"), rs.getString("name"), rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publisher;
    }

    @Override
    public List<Publisher> getAll() {
        List<Publisher> publishers = new ArrayList<>();
        String sql = "SELECT * FROM publisher";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Publisher publisher = new Publisher(rs.getLong("id"), rs.getString("name"), rs.getString("address"));
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public void save(Publisher publisher) {
        String sql = "INSERT INTO publisher (name, address) VALUES (?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, publisher.getName());
            stmt.setString(2, publisher.getAddress());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Publisher publisher) {
        String sql = "UPDATE publisher SET name = ?, address = ? WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, publisher.getName());
            stmt.setString(2, publisher.getAddress());
            stmt.setLong(3, publisher.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM publisher WHERE id = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
