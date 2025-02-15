package com.EternalCycle;

import com.EternalCycle.SystemClasses.LoginAndRegisterSystem;
import com.EternalCycle.SystemClasses.DialogueSystem;
import com.EternalCycle.SystemClasses.Game;
import com.EternalCycle.DataAccessObject.DialogueDao;
import com.EternalCycle.Database.DatabaseConnection;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialize DAO and systems
        DialogueDao dialogueDao = new DialogueDao();
        LoginAndRegisterSystem loginAndRegisterSystem = new LoginAndRegisterSystem();
        DialogueSystem dialogueSystem = new DialogueSystem(dialogueDao); // Pass DialogueDao to DialogueSystem

        // Load static dialogues from JSON
        dialogueSystem.loadDialogues();

        // Start the login system
        loginAndRegisterSystem.menuStart();

        // Display the opening dialogues with a typewriter effect (static dialogue from JSON)
        dialogueSystem.displayDialogue(dialogueSystem.getDialogueById(1), 10);

        // If login or registration is successful, start the game
        if (loginAndRegisterSystem.getLoggedInPlayer() != null) {
            Game game = new Game(loginAndRegisterSystem, dialogueSystem); // Pass DialogueSystem to Game
            game.start();
        }

        // Close all resources
        dialogueSystem.close();
        loginAndRegisterSystem.scannerClose();
        SCANNER.close();
    }
}