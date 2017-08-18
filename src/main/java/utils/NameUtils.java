package main.java.utils;

import main.java.CSVReader;
import main.java.enums.FileLocations;
import main.java.enums.RaceType;

import java.util.Collection;
import java.util.Random;
import static main.java.enums.FileLocations.*;
/**
 * Created by Nick on 8/17/2017.
 */
public class NameUtils {
    private static Random random = new Random();

    public static String getRandomName(RaceType classType)
    {
        switch (classType)
        {
            case HUMAN:
                return getRandomHumanName();
            case HALF_ORC:
                return getRandomOrcName();
            case ELF:
                return getRandomElfName();
            case HALF_ELF:
                return getRandomHalfElf();
            default:
                return "RANDOM";
        }
    }

    private static String getRandomHumanName()
    {
        return getRandom(HUMAN_FIRST_NAME.getName()) + " " + getRandom(HUMAN_LAST_NAME.getName());
    }

    private static String getRandomOrcName()
    {
        switch(random.nextInt(3))
        {
            case 0:
                return getRandom(ORC_NAMES.getName());
            case 1:
                return getRandom(HUMAN_FIRST_NAME.getName()) + " " + getRandom(ORC_NAMES.getName());
            case 2:
                return getRandom(ORC_NAMES.getName()) + " " + getRandom(HUMAN_LAST_NAME.getName());
            default:
                return getRandom(ORC_NAMES.getName());
        }
    }
    private static String getRandomElfName()
    {
        return getRandomElfFirst() + " " + getRandomElfLast();
    }

    private static String getRandom(String file)
    {
        Collection<String> list = CSVReader.getCSVByLine(file);
        String string = list.stream().skip((int) (list.size() * Math.random())).findFirst().get();
        return string;
    }
    private static String getRandomElfFirst()
    {
        switch(random.nextInt(3))
        {
            case 0:
                return getRandom(ELF_PREFIX.getName()) + getRandom(ELF_SUFFIX.getName());
            case 1:
                return getRandom(ELF_PREFIX.getName()) + getRandom(ELF_SUFFIX.getName()) + getRandom(ELF_SUFFIX.getName());
            case 2:
                return getRandom(ELF_SUFFIX.getName()) + "'" + getRandom(ELF_PREFIX.getName()) + getRandom(ELF_SUFFIX.getName()) + getRandom(ELF_SUFFIX.getName());
            default:
                return  "";
        }
    }
    private static String getRandomElfLast()
    {
        switch(random.nextInt(3))
        {
            case 0:
                return getRandom(ELF_FAMILY_PREFIX.getName()) + getRandom(ELF_FAMILY_SUFFIX.getName());
            case 1:
                return getRandom(ELF_FAMILY_PREFIX.getName()) + getRandom(ELF_FAMILY_SUFFIX.getName()) + getRandom(ELF_FAMILY_SUFFIX.getName());
            case 2:
                return getRandom(ELF_FAMILY_PREFIX.getName()) + getRandom(ELF_FAMILY_SUFFIX.getName()) + "'" + getRandom(ELF_SUFFIX.getName());
            default:
                return "";
        }
    }

    private static String getRandomHalfElf()
    {
        switch(random.nextInt(4))
        {
            case 0:
                return getRandomElfName();
            case 1:
                return getRandom(HUMAN_FIRST_NAME.getName()) + " " + getRandomElfLast();
            case 2:
                return getRandomElfFirst() + " " + getRandom(HUMAN_LAST_NAME.getName());
            case 3:
                return getRandomHumanName();
            default:
                return "";
        }
    }
}
