package main.java.enums;

import java.util.Arrays;
import java.util.Collection;
import static main.java.enums.AbilityType.*;
import static main.java.enums.DiceType.*;


/**
 * Created by Nick on 8/15/2017.
 */
public enum ClassType {
    BARD(Arrays.asList(CHA), D8, 6),
    BARBARIAN(Arrays.asList(STR, CON), D12, 4),
    CLERIC(Arrays.asList(WIS, CHA), D8, 2),
    DRUID(Arrays.asList(WIS), D8, 4),
    FIGHTER(Arrays.asList(STR, DEX), D10, 2),
    MONK(Arrays.asList(STR, DEX, WIS), D8, 4),
    PALADIN(Arrays.asList(STR, CHA), D10, 2),
    RANGER(Arrays.asList(STR, DEX, WIS), D10, 6),
    ROGUE(Arrays.asList(DEX), D8, 8),
    SORCERER(Arrays.asList(CHA), D6, 2),
    WIZARD(Arrays.asList(INT), D6, 2);

    private Collection<AbilityType> primStats;
    private DiceType hitDie;
    private int skillPerLevel;

    ClassType(Collection<AbilityType> primStats, DiceType die, int skillPerLevel) {
        this.primStats = primStats;
        this.hitDie = die;
        this.skillPerLevel = skillPerLevel;
    }

    public Collection<AbilityType> getPrimStats() {
        return primStats;
    }

    public DiceType getHitDie() {
        return hitDie;
    }

    public int getSkillPerLevel() {
        return skillPerLevel;
    }
}
