package main.java.utils;

import main.java.CSVReader;
import main.java.enums.FileLocations;
import main.java.enums.RaceType;

import java.util.Collection;
import java.util.Random;

/**
 * Created by Nick on 8/17/2017.
 */
public class NameUtils {
    Random random = new Random();

    public static String getRandomName(RaceType classType)
    {
        switch (classType)
        {
            case HUMAN:
                return getRandomHumanName();
            default:
                return "RANDOM";
        }
    }

    private static String getRandomHumanName()
    {
        Collection<String> firstNames = CSVReader.getCSVByLine(FileLocations.HUMAN_FIRST_NAME.getName());
        String firstName = firstNames.stream().skip((int) (firstNames.size() * Math.random())).findFirst().get();
        Collection<String> lastNames = CSVReader.getCSVByLine(FileLocations.HUMAN_LAST_NAME.getName());
        String lastName = lastNames.stream().skip((int) (lastNames.size() * Math.random())).findFirst().get();
        return firstName + " " + lastName;
    }
}
