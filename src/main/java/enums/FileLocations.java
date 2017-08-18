package main.java.enums;

/**
 * Created by Nick on 8/17/2017.
 */
public enum FileLocations {
    HUMAN_FIRST_NAME("namefiles/Human_First_Names.csv"),
    HUMAN_LAST_NAME("namefiles/Human_Last_Names.csv"),
    ORC_NAMES("namefiles/Orc_Names.csv"),
    ELF_PREFIX("namefiles/Elf_Prefix.csv"),
    ELF_SUFFIX("namefiles/Elf_Suffix.csv"),
    ELF_FAMILY_PREFIX("namefiles/Elf_Family_Prefix.csv"),
    ELF_FAMILY_SUFFIX("namefiles/Elf_Family_Suffix.csv");

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
