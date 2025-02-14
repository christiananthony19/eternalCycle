package com.EternalCycle.SystemClasses;

import com.EternalCycle.TableClasses.Player;

import java.util.Scanner;

public class Game {

    private final Player PLAYER;
    private final Scanner SCANNER;

    public Game(LoginAndRegisterSystem loginSystem) {
        this.PLAYER = loginSystem.getLoggedInPlayer();
        this.SCANNER = new Scanner(System.in);
    }

    // Method to start the game
    public void start() {
        System.out.println("\nStarting the game...");
        System.out.println("--------------------");
        System.exit(0);
        // Simulate a simple text-based game loop
//        while (true) {
//            System.out.println("\nWhat would you like to do?");
//            System.out.println("1. Explore");
//            System.out.println("2. Check Inventory");
//            System.out.println("3. Save and Quit");
//
//            int choice = SCANNER.nextInt();
//            SCANNER.nextLine(); // Consume the newline character
//
//            switch (choice) {
//                case 1:
//                    explore();
//                    break;
//                case 2:
//                    checkInventory();
//                    break;
//                case 3:
//                    saveAndQuit();
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
    }

    private void explore() {
        System.out.println("\nYou venture into the unknown...");
        // Add game logic for exploration here
        System.out.println("You find a mysterious object!");
    }

    private void checkInventory() {
        System.out.println("\nYour Inventory:");
        // Add logic to display the player's inventory here
        System.out.println("Inventory is empty for now.");
    }

    private void saveAndQuit() {
        System.out.println("\nSaving your progress...");
        // Update the player's progress in the database
        PLAYER.setProgress("{\"progress\": \"saved\"}");
        System.out.println("Progress saved. See you next time!");
        scannerClose();
    }

    // Close all resources (e.g., Scanner)
    public void scannerClose() {
        SCANNER.close();
    }
}
