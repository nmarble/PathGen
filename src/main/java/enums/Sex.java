package main.java.enums;

/**
 * Created by Nick on 8/18/2017.
 */
public enum Sex {
    F("Female"),
    M("Male");

    private String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
