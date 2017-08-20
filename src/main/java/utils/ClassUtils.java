package main.java.utils;

import main.java.Character;
import main.java.enums.ClassType;
import main.java.enums.SaveType;
import main.java.enums.SkillType;

import java.util.*;

import static main.java.enums.SkillType.*;

/**
 * Created by Nick on 8/16/2017.
 */
public class ClassUtils {
    private static Random random = new Random();

    public static Collection<SkillType> getClassSkills(ClassType classType) {
        switch (classType) {
            case BARBARIAN:
                return Arrays.asList(ACROBATICS, CLIMB, CRAFT, HANDLE_ANIMAL, INTIMIDATE, KNOWLEDGE_NATURE, PERCEPTION,
                        RIDE, SURVIVAL, SWIM);
            case BARD:
                return Arrays.asList(ACROBATICS, APPRAISE, BLUFF, CLIMB, CRAFT, DIPLOMACY, DISGUISE, ESCAPE_ARTIST,
                        INTIMIDATE, KNOWLEDGE_ARCANA, KNOWLEDGE_DUNGEONEERING, KNOWLEDGE_ENGINEERING, KNOWLEDGE_GEOGRAPHY,
                        KNOWLEDGE_HISTORY, KNOWLEDGE_LOCAL, KNOWLEDGE_NATURE, KNOWLEDGE_NOBILITY, KNOWLEDGE_PLANES,
                        KNOWLEDGE_RELIGION, PERCEPTION, PERFORM, PROFESSION, SENSE_MOTIVE, SLEIGHT_OF_HAND, SPELLCRAFT,
                        STEALTH, USE_MAGIC_DEVICE);
            case CLERIC:
                return Arrays.asList(APPRAISE, CRAFT, DIPLOMACY, HEAL, KNOWLEDGE_ARCANA, KNOWLEDGE_HISTORY,
                        KNOWLEDGE_NOBILITY, KNOWLEDGE_PLANES, KNOWLEDGE_RELIGION, LINGUISTICS, PROFESSION, SENSE_MOTIVE,
                        SPELLCRAFT);
            case DRUID:
                return Arrays.asList(CLIMB, CRAFT, FLY, HANDLE_ANIMAL, HEAL, KNOWLEDGE_GEOGRAPHY, KNOWLEDGE_NATURE,
                        PERCEPTION, RIDE, SPELLCRAFT, SURVIVAL, SWIM);
            case FIGHTER:
                return Arrays.asList(CLIMB, CRAFT, HANDLE_ANIMAL, INTIMIDATE, KNOWLEDGE_DUNGEONEERING,
                        KNOWLEDGE_ENGINEERING, PROFESSION, RIDE, SURVIVAL, SWIM);
            case MONK:
                return Arrays.asList(ACROBATICS, CLIMB, CRAFT, ESCAPE_ARTIST, INTIMIDATE, KNOWLEDGE_HISTORY,
                        KNOWLEDGE_RELIGION, PERCEPTION, PERFORM, PROFESSION, RIDE, SENSE_MOTIVE, STEALTH, SWIM);
            case PALADIN:
                return Arrays.asList(CRAFT, DIPLOMACY, HANDLE_ANIMAL, HEAL, KNOWLEDGE_NOBILITY, KNOWLEDGE_RELIGION,
                        PROFESSION, RIDE, SENSE_MOTIVE, SPELLCRAFT);
            case RANGER:
                return Arrays.asList(CLIMB, CRAFT, HANDLE_ANIMAL, HEAL, INTIMIDATE, KNOWLEDGE_DUNGEONEERING,
                        KNOWLEDGE_GEOGRAPHY, KNOWLEDGE_NATURE, PERCEPTION, PROFESSION, RIDE, SPELLCRAFT, STEALTH,
                        SURVIVAL, SWIM);
            case ROGUE:
                return Arrays.asList(ACROBATICS, APPRAISE, BLUFF, CLIMB, CRAFT, DIPLOMACY, DISABLE_DEVICE, DISGUISE,
                        ESCAPE_ARTIST, INTIMIDATE, KNOWLEDGE_DUNGEONEERING, KNOWLEDGE_LOCAL, LINGUISTICS, PERCEPTION,
                        PERFORM, PROFESSION, SENSE_MOTIVE, SLEIGHT_OF_HAND, STEALTH, SWIM, USE_MAGIC_DEVICE);
            case SORCERER:
                return Arrays.asList(APPRAISE, BLUFF, CRAFT, FLY, INTIMIDATE, KNOWLEDGE_ARCANA, PROFESSION, SPELLCRAFT,
                        USE_MAGIC_DEVICE);
            case WIZARD:
                return Arrays.asList(APPRAISE, CRAFT, FLY, KNOWLEDGE_ARCANA, KNOWLEDGE_DUNGEONEERING, KNOWLEDGE_ENGINEERING,
                        KNOWLEDGE_GEOGRAPHY, KNOWLEDGE_HISTORY, KNOWLEDGE_LOCAL, KNOWLEDGE_NATURE, KNOWLEDGE_NOBILITY,
                        KNOWLEDGE_PLANES, KNOWLEDGE_RELIGION, LINGUISTICS, PROFESSION, SPELLCRAFT);
            default:
                return null;
        }
    }

    public static ClassType getRandomClass() {
        return ClassType.values()[random.nextInt(ClassType.values().length)];
    }

    public static Map<SaveType, Integer> getBaseSaves(Character character)
    {
        int level = character.getLevel();
        switch (character.getClassType())
        {
            case BARBARIAN:
                return SaveUtils.createSaveSet(getPrimSave(level), getSecondarySave(level), getSecondarySave(level));
            case BARD:
                return SaveUtils.createSaveSet(getSecondarySave(level), getPrimSave(level), getPrimSave(level));
            case CLERIC:
                return SaveUtils.createSaveSet(getPrimSave(level), getSecondarySave(level), getPrimSave(level));
            case DRUID:
                return SaveUtils.createSaveSet(getPrimSave(level), getSecondarySave(level), getPrimSave(level));
            case FIGHTER:
                return SaveUtils.createSaveSet(getPrimSave(level), getSecondarySave(level), getSecondarySave(level));
            case MONK:
                return SaveUtils.createSaveSet(getPrimSave(level), getPrimSave(level), getPrimSave(level));
            case PALADIN:
                return SaveUtils.createSaveSet(getPrimSave(level), getSecondarySave(level), getPrimSave(level));
            case RANGER:
                return SaveUtils.createSaveSet(getPrimSave(level), getPrimSave(level), getSecondarySave(level));
            case ROGUE:
                return SaveUtils.createSaveSet(getPrimSave(level), getSecondarySave(level), getSecondarySave(level));
            case SORCERER:
                return SaveUtils.createSaveSet(getSecondarySave(level), getSecondarySave(level), getPrimSave(level));
            case WIZARD:
                return SaveUtils.createSaveSet(getSecondarySave(level), getSecondarySave(level), getPrimSave(level));
            default:
                return null;
        }
    }
    public static Collection<Integer> getBaseAttack(Character character)
    {
        int level = character.getLevel();
        switch (character.getClassType())
        {
            case BARBARIAN:
                return getBaseAttackBest(level);
            case BARD:
                return getBaseAttackNormal(level);
            case CLERIC:
                return getBaseAttackNormal(level);
            case DRUID:
                return getBaseAttackNormal(level);
            case FIGHTER:
                return getBaseAttackBest(level);
            case MONK:
                return getBaseAttackNormal(level);
            case PALADIN:
                return getBaseAttackBest(level);
            case RANGER:
                return getBaseAttackBest(level);
            case ROGUE:
                return getBaseAttackNormal(level);
            case SORCERER:
                return getBaseAttackWorst(level);
            case WIZARD:
                return getBaseAttackWorst(level);
            default:
                return null;
        }
    }
    private static int getPrimSave(int level)
    {
        return 2 + (level / 2);
    }
    private static int getSecondarySave(int level)
    {
        return level / 3;
    }
    private static Collection<Integer> getBaseAttackBest(int level)
    {
        Collection<Integer> baseAttacks = new ArrayList<>();
        baseAttacks.add(level);
        if (level >= 6)
        {
            baseAttacks.add(level - 5);
        }
        if (level >= 11)
        {
            baseAttacks.add(level - 10);
        }
        if (level >= 16)
        {
            baseAttacks.add(level - 15);
        }
        return baseAttacks;
    }
    private static Collection<Integer> getBaseAttackNormal(int level)
    {
        Collection<Integer> baseAttacks = new ArrayList<>();
        baseAttacks.add((int) (level * .75));
        if (level >= 8)
        {
            baseAttacks.add((int) (level * .75) - 5);
        }
        if (level >= 15)
        {
            baseAttacks.add((int) (level * .75) - 10);
        }

        return baseAttacks;
    }
    private static Collection<Integer> getBaseAttackWorst(int level)
    {
        Collection<Integer> baseAttacks = new ArrayList<>();
        baseAttacks.add((int) (level * .5));
        if (level >= 12)
        {
            baseAttacks.add((int) (level * .5) - 5);
        }
        return baseAttacks;
    }

}

