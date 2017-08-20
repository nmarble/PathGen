package main.java.npc;

import main.java.Character;
import main.java.npc.enums.Goal;

/**
 * Created by Nick on 8/15/2017.
 */
public class NPCCharacter extends Character{

    private Goal goal;

    public NPCCharacter() {
        super();
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
