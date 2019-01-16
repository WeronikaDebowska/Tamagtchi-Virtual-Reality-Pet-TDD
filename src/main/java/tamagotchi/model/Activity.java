package tamagotchi.model;

import java.util.HashMap;

import static tamagotchi.model.Stats.*;

public enum Activity {
    FEED_WITH_MEAT(new HashMap<Stats, Integer>() {{
        put(HUNGER, 20);
    }}, "feed-meat.png"),

    FEED_WITH_BONES(new HashMap<Stats, Integer>() {{
        put(HUNGER, 10);
        put(HAPPINESS, 10);
    }}, "feed-bones.png"),

    PLAY(new HashMap<Stats, Integer>() {{
        put(HUNGER, -15);
        put(HAPPINESS, 20);
        put(HEALTH, -10);
    }}, "ball.png"),

    GO_FOR_A_WALK(new HashMap<Stats, Integer>() {{
        put(HUNGER, -10);
        put(HAPPINESS, 20);
        put(HEALTH, -5);
    }}, "collar.png"),

    HEAL(new HashMap<Stats, Integer>() {{
        put(HEALTH, 30);
        put(HAPPINESS, -10);
    }}, "heal-fik.png"),

    WASH(new HashMap<Stats, Integer>() {{
        put(HEALTH, 10);
        put(HAPPINESS, -25);
    }}, "medicine.png");

    final private HashMap<Stats, Integer> ACTIVITY_RESULT;
    final private String activityButtonUrl;

    Activity(HashMap<Stats, Integer> activityResult, String activityButtonUrl) {
        this.ACTIVITY_RESULT = activityResult;
        this.activityButtonUrl = activityButtonUrl;
    }

    public HashMap<Stats, Integer> getResults() {
        return ACTIVITY_RESULT;
    }

    public String getImage() {
        return activityButtonUrl;
    }

}
