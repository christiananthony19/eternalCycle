package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.ItemDao;
import com.EternalCycle.TableClasses.Items;

import java.util.List;

public class ItemSystem {

    private final ItemDao itemDao = new ItemDao();

    public Items getItemById(int itemId) {
        return itemDao.GetItemById(itemId);
    }
}
