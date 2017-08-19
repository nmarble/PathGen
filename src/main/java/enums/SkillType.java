package main.java.enums;

import static main.java.enums.AbilityType.*;
/**
 * Created by Nick on 8/15/2017.
 */
public enum SkillType {
    ACROBATICS(DEX),
    APPRAISE(INT),
    BLUFF(CHA),
    CLIMB(STR),
    CRAFT(INT),
    DIPLOMACY(CHA),
    DISABLE_DEVICE(DEX),
    DISGUISE(CHA),
    ESCAPE_ARTIST(DEX),
    FLY(DEX),
    HANDLE_ANIMAL(CHA),
    HEAL(WIS),
    INTIMIDATE(CHA),
    KNOWLEDGE_ARCANA(INT),
    KNOWLEDGE_DUNGEONEERING(INT),
    KNOWLEDGE_ENGINEERING(INT),
    KNOWLEDGE_GEOGRAPHY(INT),
    KNOWLEDGE_HISTORY(INT),
    KNOWLEDGE_LOCAL(INT),
    KNOWLEDGE_NATURE(INT),
    KNOWLEDGE_NOBILITY(INT),
    KNOWLEDGE_PLANES(INT),
    KNOWLEDGE_RELIGION(INT),
    LINGUISTICS(INT),
    PERCEPTION(WIS),
    PERFORM(CHA),
    PROFESSION(WIS),
    RIDE(DEX),
    SENSE_MOTIVE(WIS),
    SLEIGHT_OF_HAND(DEX),
    SPELLCRAFT(INT),
    STEALTH(DEX),
    SURVIVAL(WIS),
    SWIM(STR),
    USE_MAGIC_DEVICE(CHA);

    private AbilityType primaryStat;

    SkillType(AbilityType prim) {
        this.primaryStat = prim;
    }

    public AbilityType getPrimaryStat() {
        return primaryStat;
    }
}
