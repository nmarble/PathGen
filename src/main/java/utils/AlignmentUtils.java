package main.java.utils;

import main.java.enums.AlignmentType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import static main.java.enums.AlignmentType.GvE.*;
import static main.java.enums.AlignmentType.LvC.*;

/**
 * Created by Nick on 8/20/2017.
 */
public class AlignmentUtils {
    private static Random random = new Random();

    public static AlignmentType getRandomAlignmentType() {
        return AlignmentType.values()[random.nextInt(AlignmentType.values().length)];
    }

    public static ArrayList<AlignmentType.GvE> getValidGvE(AlignmentType alignment) {

        switch (alignment.getGve())
        {
            case GOOD:
                return new ArrayList<AlignmentType.GvE>() {{add(GOOD); add(AlignmentType.GvE.NEUTRAL);}};
            case NEUTRAL:
                return new ArrayList<AlignmentType.GvE>() {{add(GOOD); add(AlignmentType.GvE.NEUTRAL); add(EVIL);}};
            case EVIL:
                return new ArrayList<AlignmentType.GvE>() {{add(AlignmentType.GvE.NEUTRAL); add(EVIL);}};
            default:
                return null;
        }
    }
    public static ArrayList<AlignmentType.LvC> getValidLvC(AlignmentType alignment) {

        switch (alignment.getLvc())
        {
            case LAWFUL:
                return new ArrayList<AlignmentType.LvC>() {{add(LAWFUL); add(AlignmentType.LvC.NEUTRAL);}};
            case NEUTRAL:
                return new ArrayList<AlignmentType.LvC>() {{add(LAWFUL); add(AlignmentType.LvC.NEUTRAL); add(CHAOTIC);}};
            case CHAOTIC:
                return new ArrayList<AlignmentType.LvC>() {{add(AlignmentType.LvC.NEUTRAL); add(CHAOTIC);}};
            default:
                return null;
        }
    }
}