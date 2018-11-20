package tamagotchi.model;

import javafx.scene.text.Text;
import tamagotchi.view.StatsView;

public enum Stats {
    HUNGER(0,30, StatsView.HUNGER_VIEW),
    HAPPINESS(100,70, StatsView.HAPPINESS_VIEW),
    HEALTH(100,50, StatsView.HEALTH_VIEW);

    final private int INITIAL_VALUES;
    final private int CRITICAL_VALUES;

    final private StatsView STAT_VIEW;

    Stats(int initialValue, int criticalValue, StatsView statsView){
        this.INITIAL_VALUES = initialValue;
        this.CRITICAL_VALUES = criticalValue;
        this.STAT_VIEW = statsView;
//        this.STAT_VIEW.setText(new Text(Integer.toString(INITIAL_VALUES)));
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


}
