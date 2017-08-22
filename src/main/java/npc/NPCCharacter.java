package main.java.npc;

import main.java.Character;
import main.java.npc.enums.Goal;

import java.util.Collection;

/**
 * Created by Nick on 8/15/2017.
 */
public class NPCCharacter extends Character{

    private Goal goal;

    private Collection<NPCCharacter> parents;

    private Collection<NPCCharacter> children;

    public NPCCharacter() {
        super();
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Collection<NPCCharacter> getParents() {
        return parents;
    }

    public Collection<NPCCharacter> getChildren() {
        return children;
    }

    public void setParents(Collection<NPCCharacter> parents) {
        this.parents = parents;
    }

    public void setChildren(Collection<NPCCharacter> children) {
        this.children = children;
    }
}
