package com.EternalCycle.TableClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dialogue {
    private int dialogueId;
    private String speaker;
    private String text;
    private List<Choice> choices; // Links to choices (if any)
    private Integer nextDialogueId; // Can be null
    private String eventTrigger;
}
