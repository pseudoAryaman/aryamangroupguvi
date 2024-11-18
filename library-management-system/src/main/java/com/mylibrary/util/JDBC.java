package com.mylibrary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";  // Change this based on your DB configuration
    private static final String USER = "root";  // Your DB username
    private static final String PASSWORD = "password";  // Your DB password

    // JDBC Connection
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private JDBC() {}

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");  // For MySQL 8.0 and above
                // Open a connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("JDBC Driver not found.", e);
            }
        }
        return connection;
    }

    // Method to close resources (Connection, Statement, ResultSet)
    public static void close(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
