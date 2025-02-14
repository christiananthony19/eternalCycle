package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Puzzle;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PuzzlesDao {

    // Retrieve all puzzles for a specific location
    public List<Puzzle> GetPuzzlesByLocationId(int locationId) {
        String sql = "SELECT * FROM Puzzles WHERE location_id = ?";
        List<Puzzle> puzzles = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, locationId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Puzzle puzzle = new Puzzle();
                puzzle.setPuzzleId(resultSet.getInt("puzzle_id"));
                puzzle.setLocationId(resultSet.getInt("location_id"));
                puzzle.setDescription(resultSet.getString("description"));
                puzzle.setSolution(resultSet.getString("solution"));
                puzzle.setReward(resultSet.getString("reward"));
                puzzles.add(puzzle);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving puzzles: " + e.getMessage());
        }

        return puzzles;
    }

    // Retrieve puzzle by ID
    public Puzzle GetPuzzleById(int puzzleId) {
        String sql = "SELECT * FROM Puzzles WHERE puzzle_id = ?";
        Puzzle puzzle = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, puzzleId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                puzzle = new Puzzle();
                puzzle.setPuzzleId(resultSet.getInt("puzzle_id"));
                puzzle.setLocationId(resultSet.getInt("location_id"));
                puzzle.setDescription(resultSet.getString("description"));
                puzzle.setSolution(resultSet.getString("solution"));
                puzzle.setReward(resultSet.getString("reward"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving puzzle: " + e.getMessage());
        }

        return puzzle;
    }
}