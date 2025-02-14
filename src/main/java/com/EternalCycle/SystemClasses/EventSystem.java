package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.EventDao;
import com.EternalCycle.TableClasses.Event;

public class EventSystem {

    private final EventDao eventDao = new EventDao();

    public Event getEventById(int eventId) {
        return eventDao.GetEventById(eventId);
    }
}