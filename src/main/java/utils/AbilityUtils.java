package main.java.utils;

import main.java.enums.AbilityType;
import main.java.enums.ClassType;

import java.util.*;

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

    public static Map<AbilityType, Integer> getRandomStats(ClassType classType)
    {
        Random random = new Random();
        Collection<AbilityType> prims = classType.getPrimStats();
        Map<AbilityType, Integer> abilitySet = new HashMap<>();
        abilitySet = getAbilitySet();
        for(Map.Entry<AbilityType, Integer> entry : abilitySet.entrySet()) {
            if(prims.contains(entry.getKey()))
            {
                abilitySet.put(entry.getKey(), entry.getValue() + random.nextInt(5) + 4);
            }else
            {
                abilitySet.put(entry.getKey(), entry.getValue() + random.nextInt(6) - 2);
            }
        }
        return abilitySet;
    }
    public static int getModifier(int value)
    {
        return (value - 10) / 2;
    }
}
