package main.java.utils;

import main.java.enums.AlignmentType;

import java.util.Random;

/**
 * Created by Nick on 8/20/2017.
 */
public class AlignmentUtils {
    private static Random random = new Random();

    public static AlignmentType getRandomAlignmentType() {
        return AlignmentType.values()[random.nextInt(AlignmentType.values().length)];
    }
}