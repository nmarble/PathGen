package main.java.enums;

import java.util.Random;

/**
 * Created by Nick on 8/19/2017.
 */
public enum DiceType {
    D3(3),
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    DPERC(100);

    private int sides;
    private Random random = new Random();
    DiceType (int sides){
        this.sides = sides;
    }

    public int getMax()
    {
        return sides;
    }

    public int roll()
    {
        return random.nextInt(sides + 1);
    }

    public int rollMultiple(int rolls)
    {
        int total = 0;
        for(int roll = 0; roll < rolls; roll++)
        {
            total += roll();
        }
        return total;
    }
}
