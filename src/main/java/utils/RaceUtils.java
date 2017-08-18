package main.java.utils;

import main.java.enums.RaceType;

import java.util.Random;

/**
 * Created by Nick on 8/16/2017.
 */
public class RaceUtils {
    private static Random random = new Random();
    public static RaceType getRandomRace()
    {
        return RaceType.values()[random.nextInt(RaceType.values().length)];
    }
}
