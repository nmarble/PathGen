package main.java.enums;

/**
 * Created by Nick on 8/17/2017.
 */
public enum FileLocations {
    HUMAN_FIRST_NAME("namefiles/Human_First_Names.csv"),
    HUMAN_LAST_NAME("namefiles/Human_Last_Names.csv");

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
