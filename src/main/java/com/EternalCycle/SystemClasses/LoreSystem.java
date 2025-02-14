package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.LoreDao;
import com.EternalCycle.TableClasses.Lore;

public class LoreSystem {

    private final LoreDao loreDao = new LoreDao();

    public Lore getLoreById(int loreId) {
        return loreDao.GetLoreById(loreId);
    }
}