package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.StatModifierDao;
import com.EternalCycle.TableClasses.StatModifier;

public class ModifierSystem {

    private final StatModifierDao modifierDao = new StatModifierDao();

    public void applyModifier(StatModifier modifier) {
        modifierDao.CreateModifier(modifier);
        System.out.println("Modifier applied successfully!");
    }

    public void removeModifier(int modifierId) {
        modifierDao.DeleteModifier(modifierId);
        System.out.println("Modifier removed successfully!");
    }
}