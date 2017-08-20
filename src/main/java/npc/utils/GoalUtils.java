package main.java.npc.utils;

import main.java.enums.AlignmentType;
import main.java.npc.enums.Goal;
import main.java.utils.AlignmentUtils;

import java.util.Random;

/**
 * Created by Nick on 8/20/2017.
 */
public class GoalUtils {
    private static Random random = new Random();

    public static Goal getRandomGoal(AlignmentType alignment)
    {
        Goal[] goal = Goal.values();
        Goal newGoal = goal[random.nextInt(Goal.values().length)];
        while (!AlignmentUtils.getValidGvE(alignment).contains(newGoal.getGve()) && !AlignmentUtils.getValidLvC(alignment).contains(newGoal.getLvc()))
        {
            newGoal = goal[random.nextInt(Goal.values().length)];
        }
        return newGoal;
    }
}
