package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Choice;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChoiceDao {

    public Choice GetChoiceById(int choiceId) {
        String sql = "SELECT * FROM Choices WHERE choice_id = ?";
        Choice choice = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, choiceId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                choice = new Choice();
                choice.setChoiceId(resultSet.getInt("choice_id"));
                choice.setDescription(resultSet.getString("description"));
                choice.setConsequence(resultSet.getString("consequence"));
                choice.setLinkedLocationId(resultSet.getInt("linked_location_id"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving choice: " + e.getMessage());
        }

        return choice;
    }
}