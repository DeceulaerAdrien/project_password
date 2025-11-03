package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:sqlite:password_manager.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connection SQLite établie");
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion SQLite : " + e.getMessage());
        }
    }
}
