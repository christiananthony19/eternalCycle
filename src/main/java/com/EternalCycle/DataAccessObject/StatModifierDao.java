package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.StatModifier;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatModifierDao {
    public void CreateModifier(StatModifier modifier) {
        String sql = "INSERT INTO Modifiers (stat_id, effect_type, stat_affected, value, duration, source, expiration_condition) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, modifier.getStatId());
            statement.setString(2, modifier.getEffectType());
            statement.setString(3, modifier.getStatAffected());
            statement.setInt(4, modifier.getValue());
            statement.setInt(5, modifier.getDuration());
            statement.setString(6, modifier.getSource());
            statement.setString(7, modifier.getExpirationCondition());
            statement.executeUpdate();

            System.out.println("Modifier inserted successfully!");

        } catch (SQLException e) {
            System.err.println("Error inserting modifier: " + e.getMessage());
        }
    }

    public StatModifier GetModifierById(int modifierId) {
        String sql = "SELECT * FROM Modifiers WHERE modifier_id = ?";
        StatModifier modifier = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, modifierId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                modifier = new StatModifier();
                modifier.setModifierId(resultSet.getInt("modifier_id"));
                modifier.setStatId(resultSet.getInt("stat_id"));
                modifier.setEffectType(resultSet.getString("effect_type"));
                modifier.setStatAffected(resultSet.getString("stat_affected"));
                modifier.setValue(resultSet.getInt("value"));
                modifier.setDuration(resultSet.getInt("duration"));
                modifier.setSource(resultSet.getString("source"));
                modifier.setExpirationCondition(resultSet.getString("expiration_condition"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving modifier: " + e.getMessage());
        }

        return modifier;
    }

    public void UpdateModifier(StatModifier modifier) {
        String sql = "UPDATE Modifiers SET stat_id = ?, effect_type = ?, stat_affected = ?, value = ?, duration = ?, source = ?, expiration_condition = ? WHERE modifier_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, modifier.getStatId());
            statement.setString(2, modifier.getEffectType());
            statement.setString(3, modifier.getStatAffected());
            statement.setInt(4, modifier.getValue());
            statement.setInt(5, modifier.getDuration());
            statement.setString(6, modifier.getSource());
            statement.setString(7, modifier.getExpirationCondition());
            statement.setInt(8, modifier.getModifierId());
            statement.executeUpdate();

            System.out.println("Modifier updated successfully!");

        } catch (SQLException e) {
            System.err.println("Error updating modifier: " + e.getMessage());
        }
    }

    public void DeleteModifier(int modifierId) {
        String sql = "DELETE FROM Modifiers WHERE modifier_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, modifierId);
            statement.executeUpdate();

            System.out.println("Modifier deleted successfully!");

        } catch (SQLException e) {
            System.err.println("Error deleting modifier: " + e.getMessage());
        }
    }
}
