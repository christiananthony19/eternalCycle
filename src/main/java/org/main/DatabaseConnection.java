package org.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/EternalCycle";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args){
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Connection Establish");
            }
        } catch (Exception ex) {
            System.err.println("Failed to connect to the database: " + ex.getMessage());
        }
    }
}
