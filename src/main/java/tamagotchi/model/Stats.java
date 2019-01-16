package tamagotchi.model;

public enum Stats {
    HUNGER(100, -15, 8000, "hunger.png", "hungry-dialogue.png"),
    HAPPINESS(100, -10, 7000, "happiness.png", "sad-dialogue.png"),
    HEALTH(100, -10, 10000, "health.png", "sick-dialogue.png");

    final private int INITIAL_VALUES;
    final private int POINTS_INCREASEMENT;
    final private int TIME_INTERVAL_MILISEC;

    final private String statImgUrl;

    final private String dialogueImgUrl;


    Stats(int initialValue, int increasement, int timeInterval, String statImgUrl, String dialogueImgUrl) {

        this.INITIAL_VALUES = initialValue;
        this.POINTS_INCREASEMENT = increasement;
        this.statImgUrl = statImgUrl;
        this.dialogueImgUrl = dialogueImgUrl;
        this.TIME_INTERVAL_MILISEC = timeInterval;
    }

    public int getInitialValues() {
        return INITIAL_VALUES;
    }


    public String getDialogueImgUrl() {
        return dialogueImgUrl;
    }

    public String getStatImgUrl() {
        return statImgUrl;
    }

    public int getPointsIncreasement() {
        return POINTS_INCREASEMENT;
    }

    public int getTimeInterval() {
        return TIME_INTERVAL_MILISEC;
    }

}
