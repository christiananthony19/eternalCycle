package com.EternalCycle.DataAccessObject;
import com.EternalCycle.TableClasses.Player;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDao {

    public Player GetPlayerById(int playerId) {
        String sql = "SELECT * FROM Players WHERE player_id = ?";
        Player player = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                player = new Player();
                player.setPlayerId(resultSet.getInt("player_id"));
                player.setUsername(resultSet.getString("username"));
                player.setPasswordHash(resultSet.getString("password_hash"));
                player.setProgress(resultSet.getString("progress"));
                player.setInventory(resultSet.getString("inventory")); // Load inventory as a string, not JSON
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving player: " + e.getMessage());
        }

        return player;
    }
    public void CreatePlayer(Player player) {
        String sql = "INSERT INTO Players (username, password_hash, progress, inventory) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, player.getUsername());
            statement.setString(2, player.getPasswordHash());
            statement.setString(3, player.getProgress());
            statement.setString(4, player.getInventory()); // Store as string
            statement.executeUpdate();

            System.out.println("Player successfully created!");

        } catch (SQLException e) {
            System.err.println("Player not available: " + e.getMessage());
        }
    }
    //might come in handy
    public void UpdatePlayer(Player player) {
        String sql = "UPDATE Players SET username = ?, password_hash = ?, progress = ?, inventory = ? WHERE player_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, player.getUsername());
            statement.setString(2, player.getPasswordHash());
            statement.setString(3, player.getProgress());
            statement.setString(4, player.getInventory()); //
            statement.setInt(5, player.getPlayerId());
            statement.executeUpdate();

            System.out.println("Player updated successfully!");

        } catch (SQLException e) {
            System.err.println("Error updating player: " + e.getMessage());
        }
    }

    public void deletePlayer(int playerId) {
        String sql = "DELETE FROM Players WHERE player_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, playerId);
            statement.executeUpdate();

            System.out.println("Player deleted successfully!");

        } catch (SQLException e) {
            System.err.println("Error deleting player: " + e.getMessage());
        }
    }
}