package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.ChoiceDao;
import com.EternalCycle.TableClasses.Choice;

public class ChoiceSystem {

    private final ChoiceDao choiceDao = new ChoiceDao();

    public Choice getChoiceById(int choiceId) {
        return choiceDao.GetChoiceById(choiceId);
    }
}