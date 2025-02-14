package com.EternalCycle.SystemClasses;


import com.EternalCycle.TableClasses.Player;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginAndRegisterSystem {

    private final PlayerSystem PLAYER_SYSTEM = new PlayerSystem();
    private final Scanner SCANNER = new Scanner(System.in);
    private boolean isValidUsername(String username) {
        return Pattern.matches("^[a-zA-Z0-9_]{3,20}$", username);
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }


    public Player login() {
        System.out.println("\nLogin to Continue Your Adventure");
        System.out.println("--------------------------------");

        System.out.print("Enter your username: ");
        String username = SCANNER.nextLine();

        System.out.print("Enter your password: ");
        String password = SCANNER.nextLine();

        //For hash
        String passwordHash = hashPassword(password);

        // Username and password retrieval
        Player player = PLAYER_SYSTEM.GetPlayerByUsernameAndPassword(username, passwordHash);

        if (player != null) {
            System.out.println("\nWelcome back, " + player.getUsername() + "!");
            return player;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }
    }

    public Player register() {

        System.out.println("\nCreate a New Adventure");
        System.out.println("----------------------");

        String username;
        while (true) {
            System.out.print("Enter a username: ");
            username = SCANNER.nextLine();

            // Check if the username is valid and already exists
            if(isValidUsername(username))
                if (PLAYER_SYSTEM.IsUsernameTaken(username)) {
                    System.out.println("Username already taken. Please choose a different username.");
                } else {
                    break;
                }
            else
                {
                    System.out.println("Invalid Username. Must be 3-20 characters long and contain only letters, numbers, and underscores.");
                }
        }

        String passwordHash;
        //Validate and Hash the password (use a proper hashing library like BCrypt in a real application)
        while(true)
            {
                System.out.print("Enter a password: ");
                String password = SCANNER.nextLine();

                if(isValidPassword(password)){
                    passwordHash = hashPassword(password);
                    break;
                } else {
                    System.out.println("Invalid password. Must be at least 6 characters long.");
                }
            }

        // Register the new player
        PLAYER_SYSTEM.RegisterPlayer(username, passwordHash, "{}");

        System.out.println("\nWelcome, " + username + "! Your adventure begins now.");

        // Retrieve the newly registered player
        return PLAYER_SYSTEM.GetPlayerByUsernameAndPassword(username, passwordHash);
    }

    // Simple password hashing (for demonstration purposes only)
    private String hashPassword(String password) {
        // In a real application, use a secure hashing algorithm like BCrypt
        return Integer.toString(password.hashCode()); // Not secure! Use BCrypt instead.
    }
}
