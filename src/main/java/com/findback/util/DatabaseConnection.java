package com.findback.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Added allowPublicKeyRetrieval=true to the URL
    private static final String URL = "jdbc:mysql://localhost:3306/findback_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "YOUR_ROOT_PASSWORD"; // Ensure your root password is set here

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}