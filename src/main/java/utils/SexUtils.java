package main.java.utils;

import main.java.enums.Sex;

import java.util.Random;

/**
 * Created by Nick on 8/18/2017.
 */
public class SexUtils {
    private static Random random = new Random();

    public static Sex getRandomSex() {
        Sex[] sexes = Sex.values();
        return sexes[random.nextInt(sexes.length)];
    }
}
