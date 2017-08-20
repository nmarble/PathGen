package main.java.utils;

import main.java.CSVReader;
import main.java.enums.RaceType;
import main.java.enums.Sex;

import java.util.Collection;
import java.util.Random;

import static main.java.enums.FileLocations.*;

/**
 * Created by Nick on 8/17/2017.
 */
public class NameUtils {
    private static Random random = new Random();

    public static String getRandomName(Sex sex, RaceType classType) {
        switch (classType) {
            case DWARF:
                return capitializeName(getRandomDwarf(sex));
            case ELF:
                return capitializeName(getRandomElfName());
            case GNOME:
                return capitializeName(getRandomGnome(sex));
            case HALF_ELF:
                return capitializeName(getRandomHalfElf(sex));
            case HALFLING:
                return capitializeName(getRandomHalfling(sex));
            case HALF_ORC:
                return capitializeName(getRandomHalfOrcName(sex));
            case HUMAN:
                return capitializeName(getRandomHumanName(sex));
            default:
                return "RANDOM";
        }
    }

    private static String getRandomHumanName(Sex sex) {
        if (sex == Sex.M) {
            return getRandom(HUMAN_MALE_NAMES.getName()) + " " + getRandom(HUMAN_LAST_NAMES.getName());
        } else {
            return getRandom(HUMAN_FEMALE_NAMES.getName()) + " " + getRandom(HUMAN_LAST_NAMES.getName());
        }
    }

    private static String getRandomHalfOrcName(Sex sex) {
        switch (random.nextInt(3)) {
            case 0:
                return getRandom(ORC_NAMES.getName());
            case 1:
                if (sex == Sex.M) {
                    return getRandom(HUMAN_MALE_NAMES.getName()) + " " + getRandom(ORC_NAMES.getName());
                } else {
                    return getRandom(HUMAN_FEMALE_NAMES.getName()) + " " + getRandom(ORC_NAMES.getName());
                }

            case 2:
                return getRandom(ORC_NAMES.getName()) + " " + getRandom(HUMAN_LAST_NAMES.getName());
            default:
                return getRandom(ORC_NAMES.getName());
        }
    }

    private static String getRandomElfName() {
        return getRandomElfFirst() + " " + getRandomElfLast();
    }

    private static String getRandom(String file) {
        Collection<String> list = CSVReader.getCSVByLine(file);
        String string = list.stream().skip((int) (list.size() * Math.random())).findFirst().get();
        return string;
    }

    private static String getRandomElfFirst() {
        switch (random.nextInt(3)) {
            case 0:
                return getRandom(ELF_PREFIX.getName()) + getRandom(ELF_SUFFIX.getName());
            case 1:
                return getRandom(ELF_PREFIX.getName()) + getRandom(ELF_SUFFIX.getName()) + getRandom(ELF_SUFFIX.getName());
            case 2:
                return getRandom(ELF_SUFFIX.getName()) + "'" + getRandom(ELF_PREFIX.getName()) + getRandom(ELF_SUFFIX.getName()) + getRandom(ELF_SUFFIX.getName());
            default:
                return "";
        }
    }

    private static String getRandomElfLast() {
        switch (random.nextInt(3)) {
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

    private static String getRandomHalfElf(Sex sex) {
        switch (random.nextInt(4)) {
            case 0:
                return getRandomElfName();
            case 1:
                if (sex == Sex.M) {
                    return getRandom(HUMAN_MALE_NAMES.getName()) + " " + getRandomElfLast();
                } else {
                    return getRandom(HUMAN_FEMALE_NAMES.getName()) + " " + getRandomElfLast();
                }
            case 2:
                return getRandomElfFirst() + " " + getRandom(HUMAN_LAST_NAMES.getName());
            case 3:
                return getRandomHumanName(sex);
            default:
                return "";
        }
    }

    private static String getRandomDwarfFirst(Sex sex) {
        switch (random.nextInt(2)) {
            case 0:
                if (sex == Sex.M) {
                    return getRandom(DWARF_PREFIX.getName()) + getRandom(DWARF_MALE_SUFFIX.getName());
                } else {
                    return getRandom(DWARF_PREFIX.getName()) + getRandom(DWARF_FEMALE_SUFFIX.getName());
                }
            case 1:
                if (sex == Sex.M) {
                    return getRandom(DWARF_PREFIX.getName()) + getRandom(DWARF_MALE_SUFFIX.getName()) + getRandom(DWARF_MALE_SUFFIX.getName());
                } else {
                    return getRandom(DWARF_PREFIX.getName()) + getRandom(DWARF_FEMALE_SUFFIX.getName()) + getRandom(DWARF_FEMALE_SUFFIX.getName());
                }
            default:
                return "";
        }
    }

    private static String getRandomDwarf(Sex sex) {
        return getRandomDwarfFirst(sex) + " " + getRandom(DWARF_LAST_NAMES.getName());
    }

    private static String getRandomGnome(Sex sex) {
        if (sex == Sex.M) {
            return getRandom(GNOME_MALE_NAMES.getName()) + " " + getRandom(GNOME_LAST_NAMES.getName());
        } else {
            return getRandom(GNOME_FEMALE_NAMES.getName()) + " " + getRandom(GNOME_LAST_NAMES.getName());
        }
    }

    private static String getRandomHalfling(Sex sex) {
        if (sex == Sex.M) {
            return getRandomHalflingPrefix() + getRandom(HALFLING_MALE_NAMES.getName()) + getRandomHalflingSuffix() + " " + getRandomHalflingPrefix() + getRandom(HALFLING_LAST_NAMES.getName()) + getRandomHalflingSuffix();
        } else {
            return getRandomHalflingPrefix() + getRandom(HALFLING_FEMALE_NAMES.getName()) + getRandomHalflingSuffix() + " " + getRandomHalflingPrefix() + getRandom(HALFLING_LAST_NAMES.getName()) + getRandomHalflingSuffix();
        }
    }

    //Used to only have prefix some of the time
    private static String getRandomHalflingPrefix() {
        int number = random.nextInt(10);
        if (number == 0) {
            return getRandom(HALFLING_PREFIX.getName());
        } else {
            return "";
        }
    }

    //Used to only have suffix some of the time
    private static String getRandomHalflingSuffix() {
        int number = random.nextInt(10);
        if (number == 0) {
            return getRandom(HALFLING_SUFFIX.getName());
        } else {
            return "";
        }
    }

    private static String capitializeName(String name) {
        String finalName = "";
        String[] splitName = name.split("\\s+");
        for (String section : splitName) {
            finalName = finalName + " " + section.substring(0, 1).toUpperCase() + section.substring(1).toLowerCase();
        }
        return finalName.trim();
    }
}
