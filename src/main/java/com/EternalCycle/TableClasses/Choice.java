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
public class Choice {
    private int choiceId;
    private String description;
    private String consequence;
    private Integer linkedLocationId; // Can be null
}
