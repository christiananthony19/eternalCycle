package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Dialogue;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DialogueDao {

    public Dialogue GetDialogueById(int dialogueId) {
        String sql = "SELECT * FROM Dialogue WHERE dialogue_id = ?";
        Dialogue dialogue = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, dialogueId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                dialogue = new Dialogue();
                dialogue.setDialogueId(resultSet.getInt("dialogue_id"));
                dialogue.setSpeaker(resultSet.getString("speaker"));
                dialogue.setText(resultSet.getString("text"));
                dialogue.setChoiceId(resultSet.getInt("choice_id"));
                dialogue.setNextDialogueId(resultSet.getInt("next_dialogue_id"));
                dialogue.setEventTrigger(resultSet.getString("event_trigger"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving dialogue: " + e.getMessage());
        }

        return dialogue;
    }
}