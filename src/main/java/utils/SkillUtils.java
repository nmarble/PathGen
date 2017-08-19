package main.java.utils;

import main.java.Character;
import main.java.enums.AbilityType;
import main.java.enums.SkillType;

import java.util.*;

/**
 * Created by Nick on 8/15/2017.
 */
public class SkillUtils {
    private static Random random = new Random();

    public static Map<SkillType, Integer> getSkillSet() {
        Map<SkillType, Integer> skillSet = new HashMap<>();
        for (SkillType type : SkillType.values()) {
            skillSet.put(type, 0);
        }
        return skillSet;
    }

    public static int getModifier(SkillType type, Map<AbilityType, Integer> abilitySet) {
        AbilityType ability = type.getPrimaryStat();
        return AbilityUtils.getModifier(abilitySet.get(ability));
    }

    public static Map<SkillType, Integer> getRandomSkills(Character character) {
        Map<SkillType, Integer> returnSkills = character.getSkills();
        SkillType[] classSkills = character.getClassSkills().toArray(new SkillType[character.getClassSkills().size()]);
        SkillType[] allSkills = SkillType.values();
        Collection<SkillType> trainedSkills = new ArrayList<>();
        for (int index = 0; index < AbilityUtils.getModifiers(character.getAbilities()).get(AbilityType.INT) + 4; index++) {
            SkillType nextSkill = classSkills[random.nextInt(classSkills.length)];
            while (!trainedSkills.contains(nextSkill)) {
                if (trainedSkills.size() < classSkills.length) {
                    nextSkill = classSkills[random.nextInt(classSkills.length)];
                    trainedSkills.add(nextSkill);
                } else {
                    nextSkill = allSkills[random.nextInt(classSkills.length)];
                    trainedSkills.add(nextSkill);
                }
            }
        }
        for (Iterator iterator = trainedSkills.iterator(); iterator.hasNext(); ) {
            SkillType skill = (SkillType) iterator.next();
            returnSkills.put(skill, 1);
        }
        return returnSkills;
    }

    public static Map<SkillType, Integer> getTotalSkillValues(Character character) {
        Map<SkillType, Integer> returnSkills = new HashMap<>();
        Map<AbilityType, Integer> modifiers = AbilityUtils.getModifiers(character.getAbilities());
        Collection<SkillType> classSkills = character.getClassSkills();
        character.getSkills().forEach((skillType, value) ->
        {
            if (classSkills.contains(skillType) && value > 0) {
                returnSkills.put(skillType, (3 + value + modifiers.get(skillType.getPrimaryStat())));
            } else {
                returnSkills.put(skillType, value + modifiers.get(skillType.getPrimaryStat()));
            }
        });
        return returnSkills;
    }
}
