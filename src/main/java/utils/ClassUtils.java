package main.java.utils;

import main.java.enums.ClassType;
import main.java.enums.SkillType;
import static main.java.enums.SkillType.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Nick on 8/16/2017.
 */
public class ClassUtils {
    public static Collection<SkillType> getClassSkills(ClassType classType)
    {
        switch (classType)
        {
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
}
