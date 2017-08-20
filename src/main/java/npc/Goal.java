package main.java.npc;

import main.java.enums.AlignmentType;

/**
 * Created by Nick on 8/19/2017.
 */
public enum Goal {
    WEALTH(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.NEUTRAL),
    MARRIAGE(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.LAWFUL),
    CHILDREN(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.NEUTRAL),
    FAME(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.NEUTRAL),
    REVENGE(AlignmentType.GvE.EVIL, AlignmentType.LvC.CHAOTIC),
    ORDER(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.LAWFUL),
    DEFEND(AlignmentType.GvE.GOOD, AlignmentType.LvC.NEUTRAL),
    DRUGS(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.CHAOTIC),
    HEAL(AlignmentType.GvE.GOOD, AlignmentType.LvC.LAWFUL),
    ADVENTURE(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.NEUTRAL),
    RESEARCH(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.LAWFUL),
    CHAOS(AlignmentType.GvE.EVIL, AlignmentType.LvC.CHAOTIC),
    WORK(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.LAWFUL),
    CREATE(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.LAWFUL),
    STEAL(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.CHAOTIC),
    TEACH(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.LAWFUL),
    GAMBLE(AlignmentType.GvE.NEUTRAL, AlignmentType.LvC.CHAOTIC),
    KILL(AlignmentType.GvE.EVIL, AlignmentType.LvC.CHAOTIC),
    SABATOGE(AlignmentType.GvE.EVIL, AlignmentType.LvC.CHAOTIC);

    private AlignmentType.GvE gve;
    private AlignmentType.LvC lvc;
    Goal(AlignmentType.GvE gve, AlignmentType.LvC lvc) {
        this.gve = gve;
        this.lvc = lvc;
    }

    public AlignmentType.LvC getLvc() {
        return lvc;
    }

    public AlignmentType.GvE getGve() {
        return gve;
    }
}
