package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.DialogueDao;
import com.EternalCycle.TableClasses.Dialogue;

public class DialogueSystem {

    private final DialogueDao dialogueDao = new DialogueDao();

    public Dialogue getDialogueById(int dialogueId) {
        return dialogueDao.GetDialogueById(dialogueId);
    }
}
