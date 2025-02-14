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
public class Dialogue {
    private int dialogueId;
    private String speaker;
    private String text;
    private Integer choiceId; // Can be null
    private Integer nextDialogueId; // Can be null
    private String eventTrigger;
}
