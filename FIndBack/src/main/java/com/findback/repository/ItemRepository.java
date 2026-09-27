package com.findback.repository;

import com.findback.database.DatabaseConnection;
import com.findback.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

        public List<Item> findAll() {

    List<Item> items = new ArrayList<>();

    String sql = """
            SELECT id, title, category, location, status, date_reported
            FROM items
            ORDER BY id
            """;

    try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()
    ) {

        while (resultSet.next()) {

            Item item = new Item(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("category"),
                    resultSet.getString("location"),
                    resultSet.getString("status"),
                    resultSet.getTimestamp("date_reported")
                            .toLocalDateTime()
            );

            items.add(item);
        }

    } catch (SQLException e) {

        System.out.println("Failed to retrieve items.");
        e.printStackTrace();
    }

    return items;
}

    public void save(Item item) {

        String sql = """
                INSERT INTO items
                (title, category, location, status)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(
                                sql,
                                PreparedStatement.RETURN_GENERATED_KEYS
                        )
        ) {

            statement.setString(1, item.getTitle());
            statement.setString(2, item.getCategory());
            statement.setString(3, item.getLocation());
            statement.setString(4, item.getStatus());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {

                if (generatedKeys.next()) {

                    int generatedId = generatedKeys.getInt(1);

                    item.setId(generatedId);

                    System.out.println(
                            "Database generated ID: " + generatedId
                    );

                }
            }

        } catch (SQLException e) {

            System.out.println("Failed to save item.");

            e.printStackTrace();
        }
    }

    public List<Item> search(String keyword) {

    List<Item> items = new ArrayList<>();

    String sql = """
            SELECT id, title, category, location, status, date_reported
            FROM items
            WHERE title LIKE ?
               OR category LIKE ?
               OR location LIKE ?
            ORDER BY id
            """;

    try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
    ) {

        String searchPattern = "%" + keyword + "%";

        statement.setString(1, searchPattern);
        statement.setString(2, searchPattern);
        statement.setString(3, searchPattern);

        try (ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Item item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("category"),
                        resultSet.getString("location"),
                        resultSet.getString("status"),
                        resultSet.getTimestamp("date_reported")
                                .toLocalDateTime()
                );

                items.add(item);
            }
        }

    } catch (SQLException e) {

        System.out.println("Failed to search items.");
        e.printStackTrace();
    }

    return items;
}
}