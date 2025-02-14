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
public class Stats {
    private int statId;
    private int playerId;
    private int health = 100;
    private int stamina = 100;
    private int strength = 10;
    private int agility = 10;
    private int intelligence = 10;
}
