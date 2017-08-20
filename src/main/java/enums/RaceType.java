package main.java.enums;

import static main.java.enums.SizeType.*;
/**
 * Created by Nick on 8/15/2017.
 */
public enum RaceType {
    DWARF(MEDIUM, 20),
    HUMAN(MEDIUM, 30),
    HALFLING(SMALL, 20),
    HALF_ELF(MEDIUM, 30),
    HALF_ORC(MEDIUM, 30),
    ELF(MEDIUM, 30),
    GNOME(SMALL, 20);

    private SizeType size;
    private int speed;
    RaceType(SizeType size, int speed)
    {
        this.size = size;
        this.speed = speed;
    }

    public SizeType getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }
}
