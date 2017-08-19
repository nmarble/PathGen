package main.java.enums;

/**
 * Created by Nick on 8/17/2017.
 */
public enum FileLocations {
    DWARF_MALE_SUFFIX("namefiles/Dwarf_Male_Suffix.csv"),
    DWARF_FEMALE_SUFFIX("namefiles/Dwarf_Female_Suffix.csv"),
    DWARF_PREFIX("namefiles/Dwarf_Prefix.csv"),
    DWARF_LAST_NAMES("namefiles/Dwarf_Last_Names.csv"),
    ELF_PREFIX("namefiles/Elf_Prefix.csv"),
    ELF_SUFFIX("namefiles/Elf_Suffix.csv"),
    ELF_FAMILY_PREFIX("namefiles/Elf_Family_Prefix.csv"),
    ELF_FAMILY_SUFFIX("namefiles/Elf_Family_Suffix.csv"),
    GNOME_MALE_NAMES("namefiles/Gnome_Male_Names.csv"),
    GNOME_FEMALE_NAMES("namefiles/Gnome_Female_Names.csv"),
    GNOME_LAST_NAMES("namefiles/Gnome_Last_Names.csv"),
    HALFLING_MALE_NAMES("namefiles/Halfling_Male_Names.csv"),
    HALFLING_FEMALE_NAMES("namefiles/Halfling_Female_Names.csv"),
    HALFLING_LAST_NAMES("namefiles/Halfling_Last_Names.csv"),
    HALFLING_PREFIX("namefiles/Halfling_Prefix.csv"),
    HALFLING_SUFFIX("namefiles/Halfling_Suffix.csv"),
    HUMAN_FEMALE_NAMES("namefiles/Human_Female_Names.csv"),
    HUMAN_MALE_NAMES("namefiles/Human_Male_Names.csv"),
    HUMAN_LAST_NAMES("namefiles/Human_Last_Names.csv"),
    ORC_NAMES("namefiles/Orc_Names.csv");


    private String name;
    private final String BASELOCATION = "/main/resources/";
    FileLocations(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return BASELOCATION + name;
    }
}
