package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.DialogueDao;
import com.EternalCycle.TableClasses.Dialogue;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DialogueSystem {

    private final DialogueDao DIALOGUE_DAO; // For dynamic dialogues
    private final Map<Integer, Dialogue> JSON_DIALOGUES; // For static dialogues from JSON
    private final Scanner SCANNER;

    // Constructor to accept DialogueDao
    public DialogueSystem(DialogueDao dialogueDao) {
        this.DIALOGUE_DAO = dialogueDao;
        this.JSON_DIALOGUES = new HashMap<>();
        this.SCANNER = new Scanner(System.in);
    }

    // Load static dialogues from JSON file
    public void loadDialogues() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Dialogues.json");
            String jsonString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            inputStream.close();

            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray dialoguesArray = jsonObject.getJSONArray("dialogues");

            for (int i = 0; i < dialoguesArray.length(); i++) {
                JSONObject dialogueJson = dialoguesArray.getJSONObject(i);
                Dialogue dialogue = new Dialogue();
                dialogue.setDialogueId(dialogueJson.getInt("id"));
                dialogue.setSpeaker(dialogueJson.getString("speaker"));
                dialogue.setText(dialogueJson.getString("text"));
                dialogue.setNextDialogueId(dialogueJson.has("next_id") && !dialogueJson.isNull("next_id") ? dialogueJson.getInt("next_id") : null); // Handle null next_id
                dialogue.setEventTrigger(dialogueJson.has("event_trigger") ? dialogueJson.getString("event_trigger") : null);
                JSON_DIALOGUES.put(dialogue.getDialogueId(), dialogue); // Store in map
            }
        } catch (Exception e) {
            System.err.println("Error loading dialogues: " + e.getMessage());
        }
    }

    // Get a dialogue by ID (checks both static and dynamic dialogues)
    public Dialogue getDialogueById(int dialogueId) {
        // First, check static dialogues
        if (JSON_DIALOGUES.containsKey(dialogueId)) {
            return JSON_DIALOGUES.get(dialogueId);
        }

        // If not found in static dialogues, fetch from the database
        return DIALOGUE_DAO.getDialogueById(dialogueId);
    }

    // Display a dialogue with a typewriter effect
    public void displayDialogue(Dialogue dialogue, int delayMillis) {
        if (dialogue == null) {
            System.out.println("\n[Error: Dialogue not found.]");
            return;
        }
        System.out.println("\n[" + dialogue.getSpeaker() + "]");
        typewriterEffect(dialogue.getText(), delayMillis);

        if (dialogue.getEventTrigger() != null) {
            handleEventTrigger(dialogue.getEventTrigger());
        }

        if (dialogue.getNextDialogueId() != null) {
            System.out.println("\nEnter to continue...");
            SCANNER.nextLine(); // Wait for user input
            displayDialogue(getDialogueById(dialogue.getNextDialogueId()), delayMillis);
        } else {
            System.out.println("\n[End of dialogue.]");
        }
    }

    // Typewriter effect for text output
    private void typewriterEffect(String text, int delayMillis) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delayMillis); // Delay between characters
            } catch (InterruptedException e) {
                System.err.println("Error in typewriter effect: " + e.getMessage());
            }
        }
        System.out.println(); // Move to the next line after the text is fully displayed
    }

    // Handle event triggers (e.g., start_game, start_act_1)
    private void handleEventTrigger(String eventTrigger) {
        switch (eventTrigger) {
            case "start_game":
                System.out.println("\n[Event Triggered: Starting the game...]");
                break;
            case "start_act_1":
                System.out.println("\n[Event Triggered: Starting Act 1...]");
                break;
            default:
                System.out.println("\n[Unknown Event Trigger: " + eventTrigger + "]");
        }
    }

    // Close resources
    public void close() {
        SCANNER.close();
    }
}