package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.TimeLoopDao;
import com.EternalCycle.TableClasses.TimeLoop;

public class TimeLoopSystem {

    private final TimeLoopDao timeLoopDao = new TimeLoopDao();

    public TimeLoop getTimeLoopById(int timeLoopId) {
        return timeLoopDao.GetTimeLoopById(timeLoopId);
    }
}
