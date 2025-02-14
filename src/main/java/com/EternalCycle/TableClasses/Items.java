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

public class Items {
    private int itemId;
    private String name;
    private String description;
    private String type; // Consumable, Equipment, Key Item
    private String effect;
}
