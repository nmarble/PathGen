package main.java.utils;

import main.java.Character;
import main.java.enums.AbilityType;
import main.java.enums.SaveType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Nick on 8/19/2017.
 */
public class SaveUtils {
    private static Random random = new Random();

    public static Map<SaveType, Integer> createSaveSet(int fort, int ref, int will) {
        Map<SaveType, Integer> saveSet = new HashMap<>();
        saveSet.put(SaveType.FORT, fort);
        saveSet.put(SaveType.REF, ref);
        saveSet.put(SaveType.WILL, will);
        return saveSet;
    }

    public static Map<SaveType, Integer> getTotalSave(Character character)
    {
        Map<AbilityType, Integer> modifiers = character.getAbilityMods();
        Map<SaveType, Integer> saves = character.getBaseSaves();
        Map<SaveType, Integer> totalSaves = new HashMap<>();

        saves.forEach(((saveType, integer) -> {
            totalSaves.put(saveType, integer + (modifiers.get(saveType.getPrimStat())));
        }));
        return totalSaves;
    }
}
