package com.EternalCycle.TableClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//WARNING: Need to edit Database and whole codebase. dialogueId and nextDialogueId is introduced.
public class Choice {
    private int choiceId;
    private int dialogueId; // Links to the parent dialogue
    private String description;
    private String consequence;
    private int nextDialogueId; // Links to the next dialogue
    private int linkedLocationId; // Can be null
}
