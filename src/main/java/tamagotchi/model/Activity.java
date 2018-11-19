package tamagotchi.model;

import java.util.HashMap;

import static tamagotchi.model.Stats.*;

public enum Activity {
    FEED_WITH_MEAT(new HashMap<Stats, Integer>(){{
        put(HUNGER, -20);
    }},"feed-meat.png"),

    FEED_WITH_BONES(new HashMap<Stats, Integer>(){{
        put(HUNGER, -10);
        put(HAPPINESS, 10);
    }},"feed-bones.png"),

    PLAY(new HashMap<Stats, Integer>(){{
        put(HUNGER, 20);
        put(HAPPINESS, 30);
    }},"ball.png"),

    GO_FOR_A_WALK(new HashMap<Stats, Integer>(){{
        put(HUNGER, 10);
        put(HAPPINESS, 20);
    }}, "collar.png"),

    HEAL(new HashMap<Stats, Integer>(){{
        put(HEALTH, 50);
        put(HAPPINESS,-20);
    }},"heal-fik.png"),

    WASH(new HashMap<Stats, Integer>(){{
        put(HEALTH,10);
        put(HAPPINESS,-10);
    }},"soap.png");

    private String imageUrl;
    private HashMap<Stats, Integer> activityResult;

    Activity(HashMap<Stats, Integer> activityResult, String imageUrl) {
        this.activityResult = activityResult;
        this.imageUrl = imageUrl;
    }

    public HashMap<Stats, Integer> getActivityResult() {
        return activityResult;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
