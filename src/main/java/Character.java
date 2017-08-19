package main.java;

import main.java.enums.*;
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
    private Sex sex;
    private int level;
    private int HP;

    public Character() {
        this.name = "TempName";
        this.abilities = AbilityUtils.getAbilitySet();
        this.skills = SkillUtils.getSkillSet();
        setClassType(ClassType.FIGHTER);
        this.sex = Sex.M;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
        this.classSkills = ClassUtils.getClassSkills(this.classType);
    }

    public Map<AbilityType, Integer> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<AbilityType, Integer> abilities) {
        this.abilities = abilities;
    }

    public Map<SkillType, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<SkillType, Integer> skills) {
        this.skills = skills;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public Collection<SkillType> getClassSkills() {
        return classSkills;
    }

    public void setClassSkills(Collection<SkillType> classSkills) {
        this.classSkills = classSkills;
    }

    public Map<SkillType, Integer> getTotalSkills() {
        return SkillUtils.getTotalSkillValues(this);
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setStartingHP() {
        this.HP = classType.getHitDie().getMax() + AbilityUtils.getModifiers(abilities).get(AbilityType.CON);
    }
}
