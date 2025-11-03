package com.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void createTables() {
        String createUserTable = """
                CREATE TABLE IF NOT EXISTS user_profile (
                id TEXT PRIMARY KEY,
                passwordHash TEXT NOT NULL,
                salt TEXT NOT NULL,
                createdAt TEXT NOT NULL,
                updatedAt TEXT NOT NULL
                );
                                """;

        String createPasswordTable = """
                CREATE TABLE IF NOT EXISTS passwords(
                id TEXT PRIMARY KEY,
                userId TEXT NOT NULL,
                service TEXT NOT NULL,
                encryptedPassword TEXT NOT NULL,
                iv TEXT NOT NULL,
                FOREIGN KEY(userId) REFERENCES user_profile(id)
                );
                """;

        try (
                Connection conn = Database.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(createUserTable);
            stmt.execute(createPasswordTable);
            System.out.println("Tables créées !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}