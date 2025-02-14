package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Event;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDao {

    public Event GetEventById(int eventId) {
        String sql = "SELECT * FROM Events WHERE event_id = ?";
        Event event = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, eventId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                event = new Event();
                event.setEventId(resultSet.getInt("event_id"));
                event.setName(resultSet.getString("name"));
                event.setTriggerCondition(resultSet.getString("trigger_condition"));
                event.setOutcome(resultSet.getString("outcome"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving event: " + e.getMessage());
        }

        return event;
    }
}
