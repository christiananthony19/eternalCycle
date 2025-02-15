package com.EternalCycle.SystemClasses;

import com.EternalCycle.TableClasses.Player;
import com.EternalCycle.DataAccessObject.PlayerDao;
import lombok.Getter;
import java.util.Scanner;
import java.util.regex.Pattern;

@Getter

public class LoginAndRegisterSystem {

    private final PlayerDao PLAYER_DAO = new PlayerDao();
    private final Scanner SCANNER = new Scanner(System.in);
    private boolean isValidUsername(String username) {
        return Pattern.matches("^[a-zA-Z0-9_]{3,20}$", username);
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
    // this contains username and password. Gonna need to refactor this to remove the password
    private Player loggedInPlayer;
    private String registerUsername;
    private String registerPassword;

    // Method to start the login system
    public void menuStart() {
        System.out.println("Welcome to Eternal Cycle: A Text Adventure Game!");
        System.out.println("----------------------------------------------");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Continue Adventure");
            System.out.println("2. New Adventure");
            System.out.println("3. Exit");
            System.out.print("\nChoice:");

            try {
                int choice = SCANNER.nextInt();
                SCANNER.nextLine(); // Consume the newline character

                if (choice == 1) {
                    if (login()) {
                        return; // Login successful
                    }
                } else if (choice == 2) {
                    if (register()) {
                        return; // Registration successful
                    }
                } else if (choice == 3) {
                    System.out.println("Thank you for playing Eternal Cycle. Goodbye!");
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception ex) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                SCANNER.nextLine(); // Clear the invalid input
            }
        }
    }

    // Method to handle login
    private boolean login() {
        System.out.println("\nLogin to Continue Your Adventure");
        System.out.println("--------------------------------");

        System.out.print("Enter your username: ");
        String username = SCANNER.nextLine();

        System.out.print("Enter your password: ");
        String password = SCANNER.nextLine();

        // Hash the password (use a proper hashing library like BCrypt in a real application)
        String passwordHash = hashPassword(password);

        // Retrieve the player by username and password hash
        loggedInPlayer = PLAYER_DAO.GetPlayerByUsernameAndPassword(username, passwordHash);

        if (loggedInPlayer != null) {
            System.out.println("\nWelcome back, " + loggedInPlayer.getUsername() + "!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    // Method to handle registration
    private boolean register() {
        System.out.println("\nCreate a New Adventure");
        System.out.println("----------------------");


        while (true) {
            System.out.print("Enter a username: ");
            registerUsername = SCANNER.nextLine();

            // Check if the username already exists
            if(!isValidUsername(registerUsername)) {
                System.out.println("Invalid username. Must be 3-20 characters long and contain only letters, numbers, and underscores.");
            }
            else {
                if (PLAYER_DAO.GetPlayerByUsername(registerUsername) != null) {
                    System.out.println("Username already taken. Please choose a different username.");
                } else {
                    break;
                }
            }

        }
        while(true) {
            System.out.print("Enter a password: ");
            registerPassword = SCANNER.nextLine();

            if (!isValidPassword(registerPassword)) {
                System.out.println("Invalid username. Must be 3-20 characters long and contain only letters, numbers, and underscores.");
            } else {
                break;
            }
        }


        // Hash the password (use a proper hashing library like BCrypt in a real application)
        String passwordHash = hashPassword(registerPassword);

        // Register the new player
        Player player = new Player();
        player.setUsername(registerUsername);
        player.setPasswordHash(passwordHash);
        player.setProgress("{}");
        PLAYER_DAO.CreatePlayer(player);

        System.out.println("\nWelcome, " + registerUsername + "! Your adventure begins now.");

        // Retrieve the newly registered player
        loggedInPlayer = PLAYER_DAO.GetPlayerByUsernameAndPassword(registerUsername, passwordHash);
        return true;
    }

    // Simple password hashing (for demonstration purposes only)
    private String hashPassword(String password) {
        // In a real application, use a secure hashing algorithm like BCrypt
        return Integer.toString(password.hashCode()); // Not secure! Use BCrypt instead.
    }

    // Close all resources (e.g., Scanner)
    public void scannerClose() {
        SCANNER.close();
    }
}