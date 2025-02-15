package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Dialogue;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DialogueDao {

    // Get a dialogue by ID
    public Dialogue getDialogueById(int dialogueId) {
        String sql = "SELECT * FROM dialogue WHERE dialogue_id = ?";
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
                dialogue.setNextDialogueId(resultSet.getInt("next_dialogue_id"));
                dialogue.setEventTrigger(resultSet.getString("event_trigger"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving dialogue: " + e.getMessage());
        }

        return dialogue;
    }

    // Get all dialogues (optional, if needed)
    public List<Dialogue> getAllDialogues() {
        String sql = "SELECT * FROM dialogue";
        List<Dialogue> dialogues = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Dialogue dialogue = new Dialogue();
                dialogue.setDialogueId(resultSet.getInt("dialogue_id"));
                dialogue.setSpeaker(resultSet.getString("speaker"));
                dialogue.setText(resultSet.getString("text"));
                dialogue.setNextDialogueId(resultSet.getInt("next_dialogue_id"));
                dialogue.setEventTrigger(resultSet.getString("event_trigger"));
                dialogues.add(dialogue);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving dialogues: " + e.getMessage());
        }

        return dialogues;
    }
}