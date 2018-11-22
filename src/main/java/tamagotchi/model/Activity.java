package tamagotchi.model;

import tamagotchi.view.ActivityButtonViewsEnum;

import java.util.HashMap;

import static tamagotchi.model.Stats.*;
import static tamagotchi.view.ActivityButtonViewsEnum.*;

public enum Activity {
    FEED_WITH_MEAT(new HashMap<Stats, Integer>(){{
        put(HUNGER, -20);
    }}, FEED_WITH_MEAT_VIEW),

    FEED_WITH_BONES(new HashMap<Stats, Integer>(){{
        put(HUNGER, -10);
        put(HAPPINESS, 10);
    }}, FEED_WITH_BONES_VIEW),

    PLAY(new HashMap<Stats, Integer>(){{
        put(HUNGER, 15);
        put(HAPPINESS, 20);
        put(HEALTH, -10);
    }}, PLAY_VIEW),

    GO_FOR_A_WALK(new HashMap<Stats, Integer>(){{
        put(HUNGER, 10);
        put(HAPPINESS, 20);
        put(HEALTH, -5);
    }}, GO_FOR_A_WALK_VIEW),

    HEAL(new HashMap<Stats, Integer>(){{
        put(HEALTH, 30);
        put(HAPPINESS, -10);
    }}, HEAL_VIEW),

    WASH(new HashMap<Stats, Integer>(){{
        put(HEALTH,10);
        put(HAPPINESS, -25);
    }}, WASH_VIEW);

    final private HashMap<Stats, Integer> ACTIVITY_RESULT;
    final private ActivityButtonViewsEnum ACTIVITY_BUTTON_IMAGE;

    Activity(HashMap<Stats, Integer> activityResult, ActivityButtonViewsEnum activityButtonViews) {
        this.ACTIVITY_RESULT = activityResult;
        this.ACTIVITY_BUTTON_IMAGE = activityButtonViews;
    }

    public HashMap<Stats,Integer> getResults() {
        return ACTIVITY_RESULT;
    }

    public String getImage() {
        return ACTIVITY_BUTTON_IMAGE.getImageUrl();
    }

}
