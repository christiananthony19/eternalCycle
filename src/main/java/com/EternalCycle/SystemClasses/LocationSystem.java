package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.LocationDao;
import com.EternalCycle.TableClasses.Locations;

import java.util.List;

public class LocationSystem {

    private final LocationDao locationDao = new LocationDao();

    public List<Locations> getAllLocations() {
        return locationDao.getAllLocations();
    }

    public Locations getLocationById(int locationId) {
        return locationDao.GetLocationById(locationId);
    }
}