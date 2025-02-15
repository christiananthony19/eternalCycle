package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Choice;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoiceDao {

    public Choice getChoiceById(int choiceId) {
        String sql = "SELECT * FROM choices WHERE choice_id = ?";
        Choice choice = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, choiceId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                choice = new Choice();
                choice.setChoiceId(resultSet.getInt("choice_id"));
                choice.setDialogueId(resultSet.getInt("dialogue_id"));
                choice.setDescription(resultSet.getString("description"));
                choice.setConsequence(resultSet.getString("consequence"));
                choice.setNextDialogueId(resultSet.getInt("next_dialogue_id"));
                choice.setLinkedLocationId(resultSet.getInt("linked_location_id"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving choice: " + e.getMessage());
        }

        return choice;
    }

    public List<Choice> getChoicesByDialogueId(int dialogueId) {
        String sql = "SELECT * FROM choices WHERE dialogue_id = ?";
        List<Choice> choices = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, dialogueId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Choice choice = new Choice();
                choice.setChoiceId(resultSet.getInt("choice_id"));
                choice.setDialogueId(resultSet.getInt("dialogue_id"));
                choice.setDescription(resultSet.getString("description"));
                choice.setConsequence(resultSet.getString("consequence"));
                choice.setNextDialogueId(resultSet.getInt("next_dialogue_id"));
                choice.setLinkedLocationId(resultSet.getInt("linked_location_id"));
                choices.add(choice);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving choices: " + e.getMessage());
        }

        return choices;
    }
}