package tamagotchi.model;

public enum Stats {
    HUNGER(0,100),
    HAPPINESS(100,0),
    HEALTH(100,0);

    final private int INITIAL_VALUES;

    final private int CRITICAL_VALUES;

    Stats(int initialValue, int criticalValue){
        this.INITIAL_VALUES = initialValue;

        this.CRITICAL_VALUES = criticalValue;
    }

    public int getINITIAL_VALUES() {
        return INITIAL_VALUES;
    }

    public int getCRITICAL_VALUES() {
        return CRITICAL_VALUES;
    }

}
