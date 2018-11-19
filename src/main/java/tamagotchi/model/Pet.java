package tamagotchi.model;

import java.util.HashMap;

public class Pet {

    private int hunger;
    private int happiness;
    private int health;

    public Pet() {
        this.hunger = Stats.HUNGER.getINITIAL_VALUES();
        this.happiness = Stats.HAPPINESS.getINITIAL_VALUES();
        this.health = Stats.HEALTH.getINITIAL_VALUES();
    }


    public void updateStats(Activity activity){
        for (HashMap.Entry<Stats,Integer> singleResult : activity.getResults().entrySet()){
            updatePetStats(singleResult.getKey(), singleResult.getValue());
        }
    }

    private void updatePetStats(Stats stats, Integer points){
        switch (stats){
            case HAPPINESS:
                setHappiness(getHappiness() + points);
                break;
            case HEALTH:
                setHealth(getHealth() + points);
                break;
            case HUNGER:
                setHunger(getHunger() + points);
                break;
        }
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


}
