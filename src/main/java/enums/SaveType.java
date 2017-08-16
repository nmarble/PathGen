package main.java.enums;

/**
 * Created by Nick on 8/15/2017.
 */
public enum SaveType {
    FORT("Fortitude", AbilityType.CON),
    REF("Reflex", AbilityType.DEX),
    WILL("Will", AbilityType.WIS);

    private String name;
    private AbilityType primStat;

    SaveType(String name, AbilityType prim)
    {
        this.name = name;
        this.primStat = prim;
    }

    public String getName()
    {
        return name;
    }

    public AbilityType getPrimStat() {
        return primStat;
    }
}
