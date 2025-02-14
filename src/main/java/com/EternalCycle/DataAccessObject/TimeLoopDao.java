package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.TimeLoop;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeLoopDao {
    public void CreateTimeLoop(TimeLoop timeLoop) {
        String sql = "INSERT INTO TimeLoop (current_state, reset_condition, consequences) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, timeLoop.getCurrentState());
            statement.setString(2, timeLoop.getResetCondition());
            statement.setString(3, timeLoop.getConsequences());
            statement.executeUpdate();

            System.out.println("TimeLoop inserted successfully!");

        } catch (SQLException e) {
            System.err.println("Error inserting timeLoop: " + e.getMessage());
        }
    }

    public TimeLoop GetTimeLoopById(int timeLoopId) {
        String sql = "SELECT * FROM TimeLoop WHERE time_loop_id = ?";
        TimeLoop timeLoop = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, timeLoopId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                timeLoop = new TimeLoop();
                timeLoop.setTimeLoopId(resultSet.getInt("time_loop_id"));
                timeLoop.setCurrentState(resultSet.getString("current_state"));
                timeLoop.setResetCondition(resultSet.getString("reset_condition"));
                timeLoop.setConsequences(resultSet.getString("consequences"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving timeLoop: " + e.getMessage());
        }

        return timeLoop;
    }

    public void UpdateTimeLoop(TimeLoop timeLoop) {
        String sql = "UPDATE TimeLoop SET current_state = ?, reset_condition = ?, consequences = ? WHERE time_loop_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, timeLoop.getCurrentState());
            statement.setString(2, timeLoop.getResetCondition());
            statement.setString(3, timeLoop.getConsequences());
            statement.setInt(4, timeLoop.getTimeLoopId());
            statement.executeUpdate();

            System.out.println("TimeLoop updated successfully!");

        } catch (SQLException e) {
            System.err.println("Error updating timeLoop: " + e.getMessage());
        }
    }

    public void DeleteTimeLoop(int timeLoopId) {
        String sql = "DELETE FROM TimeLoop WHERE time_loop_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, timeLoopId);
            statement.executeUpdate();

            System.out.println("TimeLoop deleted successfully!");

        } catch (SQLException e) {
            System.err.println("Error deleting timeLoop: " + e.getMessage());
        }
    }
}