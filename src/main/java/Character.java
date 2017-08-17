package main.java;

import main.java.enums.AbilityType;
import main.java.enums.ClassType;
import main.java.enums.RaceType;
import main.java.enums.SkillType;
import main.java.utils.AbilityUtils;
import main.java.utils.ClassUtils;
import main.java.utils.SkillUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Nick on 8/15/2017.
 */
public class Character {

    private String name;
    private ClassType classType;
    private Map<AbilityType, Integer> abilities;
    private Map<SkillType, Integer> skills;
    private RaceType raceType;
    private Collection<SkillType> classSkills;

    public Character(String name)
    {
        this.name = name;
        this.abilities = AbilityUtils.getAbilitySet();
        this.skills = SkillUtils.getSkillSet();
        setClassType(ClassType.FIGHTER);
    }

    public String getName()
    {
        return name;
    }

    public ClassType getClassType() {
        return classType;
    }

    public Map<AbilityType, Integer> getAbilities() {
        return abilities;
    }

    public Map<SkillType, Integer> getSkills() {
        return skills;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassType(ClassType classType)
    {
        this.classType = classType;
        this.classSkills = ClassUtils.getClassSkills(this.classType);
    }

    public void setAbilities(Map<AbilityType, Integer> abilities) {
        this.abilities = abilities;
    }

    public void setSkills(Map<SkillType, Integer> skills)
    {
        this.skills = skills;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public void setClassSkills(Collection<SkillType> classSkills) {
        this.classSkills = classSkills;
    }

    public Collection<SkillType> getClassSkills()
    {
        return classSkills;
    }

    public Map<SkillType, Integer> getTotalSkills()
    {
        return SkillUtils.getTotalSkillValues(this);
    }
}
