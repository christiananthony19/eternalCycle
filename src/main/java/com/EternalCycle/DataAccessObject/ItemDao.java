package com.EternalCycle.DataAccessObject;
import com.EternalCycle.TableClasses.Items;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemDao {

    public Items GetItemById(int itemId) {
        String sql = "SELECT * FROM Items WHERE item_id = ?";
        Items item = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, itemId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                item = new Items();
                item.setItemId(resultSet.getInt("item_id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setType(resultSet.getString("type"));
                item.setEffect(resultSet.getString("effect"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving item: " + e.getMessage());
        }

        return item;
    }

}