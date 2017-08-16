package main.java.utils;

import main.java.enums.AbilityType;
import main.java.enums.SkillType;
import main.java.utils.AbilityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nick on 8/15/2017.
 */
public class SkillUtils {
    public static Map<SkillType, Integer> getSkillSet()
    {
        Map<SkillType, Integer> skillSet = new HashMap<>();
        for(SkillType type : SkillType.values())
        {
            skillSet.put(type, 0);
        }
        return skillSet;
    }
    public static int getModifier(SkillType type, Map<AbilityType, Integer> abilitySet)
    {
        AbilityType ability = type.getPrimaryStat();
        return AbilityUtils.getModifier(abilitySet.get(ability));
    }
}
