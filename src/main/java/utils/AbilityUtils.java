package main.java.utils;

import main.java.enums.AbilityType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Nick on 8/15/2017.
 */
public class AbilityUtils {

    public static Map<AbilityType, Integer> getAbilitySet()
    {
        Map<AbilityType, Integer> abilitySet = new HashMap<>();
        for(AbilityType type : AbilityType.values())
        {
            abilitySet.put(type, 10);
        }
        return abilitySet;
    }

    public static Map<AbilityType, Integer> getModifiers(Map<AbilityType, Integer> abilitySet)
    {
        Map<AbilityType, Integer> modifierSet = new HashMap<>();
        for(Map.Entry<AbilityType, Integer> entry : abilitySet.entrySet()) {
            modifierSet.put(entry.getKey(), getModifier(entry.getValue()));
        }
        return modifierSet;
    }

    public static int getModifier(int value)
    {
        return (value - 10) / 2;
    }
}
