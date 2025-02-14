package com.EternalCycle.DataAccessObject;
import com.EternalCycle.TableClasses.Stats;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatDao {

    public Stats GetStatByPlayerId(int playerId) {
        String sql = "SELECT * FROM Stats WHERE player_id = ?";
        Stats stat = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                stat = new Stats();
                stat.setStatId(resultSet.getInt("stat_id"));
                stat.setPlayerId(resultSet.getInt("player_id"));
                stat.setHealth(resultSet.getInt("health"));
                stat.setStamina(resultSet.getInt("stamina"));
                stat.setStrength(resultSet.getInt("strength"));
                stat.setAgility(resultSet.getInt("agility"));
                stat.setIntelligence(resultSet.getInt("intelligence"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving stat: " + e.getMessage());
        }

        return stat;
    }

    //Might need this in future
    public void CreateStat(Stats stat) {
        String sql = "INSERT INTO Stats (player_id, health, stamina, strength, agility, intelligence) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, stat.getPlayerId());
            statement.setInt(2, stat.getHealth());
            statement.setInt(3, stat.getStamina());
            statement.setInt(4, stat.getStrength());
            statement.setInt(5, stat.getAgility());
            statement.setInt(6, stat.getIntelligence());
            statement.executeUpdate();

            System.out.println("Stat created successfully!");

        } catch (SQLException e) {
            System.err.println("Error inserting stat: " + e.getMessage());
        }
    }

    public void UpdateStat(Stats stat) {
        String sql = "UPDATE Stats SET health = ?, stamina = ?, strength = ?, agility = ?, intelligence = ? WHERE player_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, stat.getHealth());
            statement.setInt(2, stat.getStamina());
            statement.setInt(3, stat.getStrength());
            statement.setInt(4, stat.getAgility());
            statement.setInt(5, stat.getIntelligence());
            statement.setInt(6, stat.getPlayerId());
            statement.executeUpdate();

            System.out.println("Stat updated successfully!");

        } catch (SQLException e) {
            System.err.println("Error updating stat: " + e.getMessage());
        }
    }
    //For future needs, might not be needed
    public void DeleteStat(int playerId) {
        String sql = "DELETE FROM Stats WHERE player_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, playerId);
            statement.executeUpdate();

            System.out.println("Stat deleted successfully!");

        } catch (SQLException e) {
            System.err.println("Error deleting stat: " + e.getMessage());
        }
    }
}