package com.EternalCycle;

import com.EternalCycle.SystemClasses.LoginAndRegisterSystem;
import com.EternalCycle.SystemClasses.Game;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        LoginAndRegisterSystem loginandregisterSystem = new LoginAndRegisterSystem();
        loginandregisterSystem.menuStart(); // Start the login system

        // If login or registration is successful, start the game
        if (loginandregisterSystem.getLoggedInPlayer() != null) {
            Game game = new Game(loginandregisterSystem);
            game.start();
        }

        // Close all resources
        loginandregisterSystem.scannerClose();
    }
}
