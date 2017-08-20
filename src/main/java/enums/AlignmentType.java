package main.java.enums;

/**
 * Created by Nick on 8/19/2017.
 */
public enum AlignmentType {
    LAWFUL_GOOD(GvE.GOOD, LvC.LAWFUL),
    LAWFUL_NEUTRAL(GvE.NEUTRAL, LvC.LAWFUL),
    LAWFUL_EVIL(GvE.EVIL, LvC.LAWFUL),
    NEUTRAL_GOOD(GvE.GOOD, LvC.NEUTRAL),
    NEUTRAL(GvE.NEUTRAL, LvC.NEUTRAL),
    NEUTRAL_EVIL(GvE.EVIL, LvC.NEUTRAL),
    CHAOTIC_GOOD(GvE.GOOD, LvC.CHAOTIC),
    CHAOTIC_NEUTRAL(GvE.NEUTRAL, LvC.CHAOTIC),
    CHAOTIC_EVIL(GvE.EVIL, LvC.CHAOTIC);

    private GvE gve;
    private LvC lvc;
    AlignmentType(GvE gve, LvC lvc)
    {
        this.gve = gve;
        this.lvc = lvc;
    }

    public GvE getGve() {
        return gve;
    }

    public LvC getLvc() {
        return lvc;
    }

    @Override
    public String toString() {
        switch (this)
        {
            case LAWFUL_EVIL:
                return "Lawful Evil";
            case LAWFUL_GOOD:
                return "Lawful Good";
            case LAWFUL_NEUTRAL:
                return "Lawful Neutral";
            case NEUTRAL:
                return "Neutral";
            case NEUTRAL_EVIL:
                return "Neutral Evil";
            case NEUTRAL_GOOD:
                return "Neutral Good";
            case CHAOTIC_EVIL:
                return "Chaotic Evil";
            case CHAOTIC_GOOD:
                return "Chaotic Good";
            case CHAOTIC_NEUTRAL:
                return "Chaotic Neutral";
            default:
                return "";
        }
    }

    public enum GvE{
        GOOD,
        NEUTRAL,
        EVIL;
    }
    public enum  LvC{
        LAWFUL,
        NEUTRAL,
        CHAOTIC;
    }
}


