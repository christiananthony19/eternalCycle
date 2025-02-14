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

public class StatModifier {
    private int modifierId;
    private int statId;
    private String effectType; // Buff, Debuff
    private String statAffected;
    private int value;
    private Integer duration; // Can be null
    private String source;
    private String expirationCondition;
}