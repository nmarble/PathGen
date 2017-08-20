package main.java.enums;

/**
 * Created by Nick on 8/15/2017.
 */
public enum SizeType {
    FINE(8, -8, 8, 16),
    DIMINUTIVE(4, -4, 4, 12),
    TINY(2, -2, 2, 8),
    SMALL(1, -1, 1, 4),
    MEDIUM(0, 0, 0, 0),
    LARGE(-1, 1, -1, -4),
    HUGE(-2, 2, -2, -8),
    GARGANTUAN(-4, 4, -4, -12),
    COLOSSAL(-8, 8, -8, -16);

    private int acMod;
    private int combatMod;
    private int attackMod;
    private int stealthMod;

    SizeType(int acMod, int combatMod, int attackMod, int stealthMod) {
        this.acMod = acMod;
        this.combatMod = combatMod;
        this.attackMod = attackMod;
        this.stealthMod = stealthMod;
    }

    public int getAcMod() {
        return acMod;
    }

    public int getAttackMod() {
        return attackMod;
    }

    public int getCombatMod() {
        return combatMod;
    }

    public int getStealthMod() {
        return stealthMod;
    }
}
