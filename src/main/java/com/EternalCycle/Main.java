package com.EternalCycle;

import com.EternalCycle.SystemClasses.LoginAndRegisterSystem;
import com.EternalCycle.TableClasses.Player;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

            System.out.println("Welcome to Eternal Cycle: A Text Adventure Game!");
            System.out.println("----------------------------------------------");

            LoginAndRegisterSystem loginRegisterSystem = new LoginAndRegisterSystem();

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Continue Adventure (Login)");
                System.out.println("2. New Adventure (Register)");
                System.out.println("3. Exit");
                System.out.print("\nChoice:");

                int choice = SCANNER.nextInt();
                SCANNER.nextLine(); // Consume the newline character

                Player player = null;

                switch (choice) {
                    case 1:
                        player = loginRegisterSystem.login();
                        break;
                    case 2:
                        player = loginRegisterSystem.register();
                        break;
                    case 3:
                        System.out.println("Thank you for playing Eternal Cycle. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                if (player != null) {
                    startGame(player);
                }
            }
        }

        private static void startGame(Player player) {
            System.out.println("\nStarting the game...");
            System.out.println("--------------------");
            System.exit(0);
            // Simulate a simple text-based game loop
//            while (true) {
//                System.out.println("\nWhat would you like to do?");
//                System.out.println("1. Explore");
//                System.out.println("2. Check Inventory");
//                System.out.println("3. Save and Quit");
//
//                int choice = SCANNER.nextInt();
//                SCANNER.nextLine(); // Consume the newline character
//
//                switch (choice) {
//                    case 1:
//                        Explore(player);
//                        break;
//                    case 2:
//                        CheckInventory(player);
//                        break;
//                    case 3:
//                        SaveAndQuit(player);
//                        return;
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//        }
//
//        private static void Explore(Player player) {
//            System.out.println("\nYou venture into the unknown...");
//            // Add game logic for exploration here
//            System.out.println("You find a mysterious object!");
//        }
//
//        private static void CheckInventory(Player player) {
//            System.out.println("\nYour Inventory:");
//            // Add logic to display the player's inventory here
//            System.out.println("Inventory is empty for now.");
//        }
//
//        private static void saveAndQuit(Player player) {
//            System.out.println("\nSaving your progress...");
//            // Update the player's progress in the database
//            playerSystem.updatePlayerProgress(player.getPlayerId(), "{\"progress\": \"saved\"}");
//            System.out.println("Progress saved. See you next time!");
        }
    }
