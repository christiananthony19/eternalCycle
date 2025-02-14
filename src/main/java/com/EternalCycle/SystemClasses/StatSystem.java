package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.StatDao;
import com.EternalCycle.TableClasses.Stats;

public class StatSystem {

    private final StatDao statDao = new StatDao();

    public Stats GetStatByPlayerId(int playerId) {
        return statDao.GetStatByPlayerId(playerId);
    }

    public void UpdateStat(Stats stat) {
        statDao.UpdateStat(stat);
    }
}
