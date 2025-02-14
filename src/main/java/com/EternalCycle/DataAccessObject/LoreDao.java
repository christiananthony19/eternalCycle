package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Lore;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoreDao {

    public Lore GetLoreById(int loreId) {
        String sql = "SELECT * FROM Lore WHERE lore_id = ?";
        Lore lore = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, loreId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                lore = new Lore();
                lore.setLoreId(resultSet.getInt("lore_id"));
                lore.setTitle(resultSet.getString("title"));
                lore.setDescription(resultSet.getString("description"));
                lore.setUnlockCondition(resultSet.getString("unlock_condition"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving lore: " + e.getMessage());
        }

        return lore;
    }
}