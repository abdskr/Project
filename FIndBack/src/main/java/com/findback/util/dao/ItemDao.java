package com.findback.dao;

import com.findback.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao {

    public void addItem(String name, String category, String location, String description, String status) {
        String sql = "INSERT INTO items (title, category, location, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setString(3, location);
            stmt.setString(4, status);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Item saved to MySQL database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    public void displayAllItems() {
        String sql = "SELECT * FROM items";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n========== ALL ITEMS (FROM MYSQL) ==========");
            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.printf("ID: %d | Name: %s | Category: %s | Location: %s | Status: %s%n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getString("location"),
                        rs.getString("status"));
            }

            if (!found) {
                System.out.println("No items found in database.");
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }
}