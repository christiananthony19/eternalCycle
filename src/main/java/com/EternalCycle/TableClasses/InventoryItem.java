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
public class InventoryItem {
    private int playerId; // Connected to the Player class
    private int itemId; // Same as above, but Items class
    private int quantity = 1; // Default
}