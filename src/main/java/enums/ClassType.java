package main.java.enums;

import java.util.Arrays;
import java.util.Collection;


/**
 * Created by Nick on 8/15/2017.
 */
public enum ClassType {
    BARD(Arrays.asList(AbilityType.CHA)),
    BARBARIAN(Arrays.asList(AbilityType.STR, AbilityType.CON)),
    CLERIC(Arrays.asList(AbilityType.WIS, AbilityType.CHA)),
    DRUID(Arrays.asList(AbilityType.WIS)),
    FIGHTER(Arrays.asList(AbilityType.STR, AbilityType.DEX)),
    MONK(Arrays.asList(AbilityType.STR, AbilityType.DEX, AbilityType.WIS)),
    PALADIN(Arrays.asList(AbilityType.STR, AbilityType.CHA)),
    RANGER(Arrays.asList(AbilityType.STR, AbilityType.DEX, AbilityType.WIS)),
    ROGUE(Arrays.asList(AbilityType.DEX)),
    SORCERER(Arrays.asList(AbilityType.CHA)),
    WIZARD(Arrays.asList(AbilityType.INT));

    private Collection<AbilityType> primStats;
    ClassType(Collection<AbilityType> primStats)
    {
        this.primStats = primStats;
    }

    public Collection<AbilityType> getPrimStats() {
        return primStats;
    }
}
