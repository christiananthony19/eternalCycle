package com.EternalCycle.TableClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString // Generates toString method?
public class Player {
    private int playerId;
    private String username;
    private String passwordHash;
    private String inventory; // Format: "itemId:quantity,itemId:quantity"
    private String progress; // JSON string
}

    // Example of the JSON string:
    //{
    //  "storyFlags": {
    //    "metNPC": true,
    //    "foundKeyItem": false
    //  },
    //  "unlockedLocations": [10, 15],
    //  "miscData": {
    //    "lastLogin": "2023-10-01",
    //    "preferences": {
    //      "volume": 80,
    //      "difficulty": "medium"
    //    }
    //  }
    //}
