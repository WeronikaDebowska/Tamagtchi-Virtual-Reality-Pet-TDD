package tamagotchi.model;

import tamagotchi.view.StatsView;

public enum Stats {
    HUNGER(100, 50, 15, -15, 8000, 10, StatsView.HUNGER_VIEW),
    HAPPINESS(100, 50, 10, -10, 7000, 0, StatsView.HAPPINESS_VIEW),
    HEALTH(100, 50, 15, -10, 10000, 5, StatsView.HEALTH_VIEW);

    final private int INITIAL_VALUES;
    final private int LOW;
    final private int CRITICAL_VALUES;
    final private int POINTS_INCREASEMENT;
    final private int TIME_INTERVAL_MILISEC;

    final private StatsView STAT_VIEW;

    Stats(int initialValue, int low, int criticalValue, int increasement, int timeInterval, int incresementWhenSleeping, StatsView statsView) {
        this.INITIAL_VALUES = initialValue;
        this.LOW = low;
        this.CRITICAL_VALUES = criticalValue;
        this.STAT_VIEW = statsView;
        this.POINTS_INCREASEMENT = increasement;
        this.TIME_INTERVAL_MILISEC = timeInterval;
    }

    public int getLOW() {
        return LOW;
    }

    public int getINITIAL_VALUES() {
        return INITIAL_VALUES;
    }

    public int getCRITICAL_VALUES() {
        return CRITICAL_VALUES;
    }
    public StatsView getSTAT_VIEW() {
        return STAT_VIEW;
    }

    public int getPOINTS_INCREASEMENT() {
        return POINTS_INCREASEMENT;
    }

    public int getTIME_INTERVAL_MILISEC() {
        return TIME_INTERVAL_MILISEC;
    }

}
