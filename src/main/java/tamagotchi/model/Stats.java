package tamagotchi.model;

import javafx.scene.text.Text;
import tamagotchi.view.StatsView;

public enum Stats {
    HUNGER(0, 30, StatsView.HUNGER_VIEW, 10, 5000),
    HAPPINESS(100, 70, StatsView.HAPPINESS_VIEW, -10, 4000),
    HEALTH(100, 50, StatsView.HEALTH_VIEW, -10, 6000);

    final private int INITIAL_VALUES;
    final private int CRITICAL_VALUES;
    final private int POINTS_INCREASEMENT;

    final private int TIME_INTERVAL_MILISEC;

    final private StatsView STAT_VIEW;

    Stats(int initialValue, int criticalValue, StatsView statsView, int increasement, int time) {
        this.INITIAL_VALUES = initialValue;
        this.CRITICAL_VALUES = criticalValue;
        this.STAT_VIEW = statsView;
        this.POINTS_INCREASEMENT = increasement;
        this.TIME_INTERVAL_MILISEC = time;
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
