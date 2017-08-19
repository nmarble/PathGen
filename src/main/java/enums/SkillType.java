package main.java.enums;

/**
 * Created by Nick on 8/15/2017.
 */
public enum SkillType {
    ACROBATICS(AbilityType.DEX),
    APPRAISE(AbilityType.INT),
    BLUFF(AbilityType.CHA),
    CLIMB(AbilityType.STR),
    CRAFT(AbilityType.INT),
    DIPLOMACY(AbilityType.CHA),
    DISABLE_DEVICE(AbilityType.DEX),
    DISGUISE(AbilityType.CHA),
    ESCAPE_ARTIST(AbilityType.DEX),
    FLY(AbilityType.DEX),
    HANDLE_ANIMAL(AbilityType.CHA),
    HEAL(AbilityType.WIS),
    INTIMIDATE(AbilityType.CHA),
    KNOWLEDGE_ARCANA(AbilityType.INT),
    KNOWLEDGE_DUNGEONEERING(AbilityType.INT),
    KNOWLEDGE_ENGINEERING(AbilityType.INT),
    KNOWLEDGE_GEOGRAPHY(AbilityType.INT),
    KNOWLEDGE_HISTORY(AbilityType.INT),
    KNOWLEDGE_LOCAL(AbilityType.INT),
    KNOWLEDGE_NATURE(AbilityType.INT),
    KNOWLEDGE_NOBILITY(AbilityType.INT),
    KNOWLEDGE_PLANES(AbilityType.INT),
    KNOWLEDGE_RELIGION(AbilityType.INT),
    LINGUISTICS(AbilityType.INT),
    PERCEPTION(AbilityType.WIS),
    PERFORM(AbilityType.CHA),
    PROFESSION(AbilityType.WIS),
    RIDE(AbilityType.DEX),
    SENSE_MOTIVE(AbilityType.WIS),
    SLEIGHT_OF_HAND(AbilityType.DEX),
    SPELLCRAFT(AbilityType.INT),
    STEALTH(AbilityType.DEX),
    SURVIVAL(AbilityType.WIS),
    SWIM(AbilityType.STR),
    USE_MAGIC_DEVICE(AbilityType.CHA);

    private AbilityType primaryStat;

    SkillType(AbilityType prim) {
        this.primaryStat = prim;
    }

    public AbilityType getPrimaryStat() {
        return primaryStat;
    }
}
