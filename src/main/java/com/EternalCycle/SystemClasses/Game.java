package com.EternalCycle.SystemClasses;

import com.EternalCycle.TableClasses.Player;
import java.util.Scanner;

public class Game {

    private final Player PLAYER;
    private final Scanner SCANNER;
    private final DialogueSystem DIALOGUE_SYSTEM;

    // Constructor to accept LoginAndRegisterSystem and DialogueSystem
    public Game(LoginAndRegisterSystem loginSystem, DialogueSystem dialogueSystem) {
        this.PLAYER = loginSystem.getLoggedInPlayer();
        this.SCANNER = new Scanner(System.in);
        this.DIALOGUE_SYSTEM = dialogueSystem;
    }

    // Method to start the game
    public void start() {
        System.out.println("\nStarting the game...");
        System.out.println("--------------------");

        // Display the first gameplay dialogue (e.g., dialogue ID 12)
        DIALOGUE_SYSTEM.displayDialogue(DIALOGUE_SYSTEM.getDialogueById(12), 50);
        System.exit(0);

        // Example: Player interaction loop
//        while (true) {
//            System.out.println("\nWhat would you like to do?");
//            System.out.println("1. Explore the Hamlet");
//            System.out.println("2. Visit the Barracks");
//            System.out.println("3. Check Inventory");
//            System.out.println("4. Quit Game");
//
//            int choice = SCANNER.nextInt();
//            SCANNER.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    exploreHamlet();
//                    break;
//                case 2:
//                    visitBarracks();
//                    break;
//                case 3:
//                    checkInventory();
//                    break;
//                case 4:
//                    System.out.println("Exiting the game...");
//                    scannerClose();
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    // Example method: Explore the Hamlet
//    private void exploreHamlet() {
//        System.out.println("\nYou explore the Hamlet...");
//        // Display a dynamic dialogue (e.g., fetched from the database)
//        DIALOGUE_SYSTEM.displayDialogue(DIALOGUE_SYSTEM.getDialogueById(13), 50);
//    }
//
//    // Example method: Visit the Barracks
//    private void visitBarracks() {
//        System.out.println("\nYou visit the Barracks...");
//        // Display a dynamic dialogue (e.g., fetched from the database)
//        DIALOGUE_SYSTEM.displayDialogue(DIALOGUE_SYSTEM.getDialogueById(14), 50);
//    }
//
//    // Example method: Check Inventory
//    private void checkInventory() {
//        System.out.println("\nYou check your inventory...");
//        // Display a dynamic dialogue (e.g., fetched from the database)
//        DIALOGUE_SYSTEM.displayDialogue(DIALOGUE_SYSTEM.getDialogueById(15), 50);
//    }

        // Close all resources (e.g., Scanner)

    }
    public void scannerClose () {
        SCANNER.close();
    }
}