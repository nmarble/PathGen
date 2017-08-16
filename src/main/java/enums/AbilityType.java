package main.java.enums;

/**
 * Created by Nick on 8/15/2017.
 */
public enum AbilityType {
    STR("Strength"),
    DEX("Dexterity"),
    CON("Constitution"),
    INT("Intelligence"),
    WIS("Wisdom"),
    CHA("Charisma");

    private String fullName;

    AbilityType(String fullName)
    {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
