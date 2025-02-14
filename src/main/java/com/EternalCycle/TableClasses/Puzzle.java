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
public class Puzzle {
    private int puzzleId;
    private int locationId;
    private String description;
    private String solution;
    private String reward;
}