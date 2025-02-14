package com.EternalCycle.DataAccessObject;

import com.EternalCycle.TableClasses.Locations;
import com.EternalCycle.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class LocationDao {

    public Locations GetLocationById(int locationId) {
        String sql = "SELECT * FROM Locations WHERE location_id = ?";
        Locations location = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, locationId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                location = new Locations();
                location.setLocationId(resultSet.getInt("location_id"));
                location.setName(resultSet.getString("name"));
                location.setDescription(resultSet.getString("description"));
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving location: " + e.getMessage());
        }

        return location;
    }

    public List<Locations> getAllLocations() {
        String sql = "SELECT * FROM Locations";
        List<Locations> locations = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Locations location = new Locations();
                location.setLocationId(resultSet.getInt("location_id"));
                location.setName(resultSet.getString("name"));
                location.setDescription(resultSet.getString("description"));
                locations.add(location);
            }

        } catch (SQLException e) {
            System.err.println("Error retrieving locations: " + e.getMessage());
        }

        return locations;
    }
}
