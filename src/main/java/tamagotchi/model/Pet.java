package tamagotchi.model;

import tamagotchi.view.ViewBuilder;

import java.util.HashMap;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Pet {

    private int hunger;
    private int happiness;
    private int health;

    private PetState petState;

    private ViewBuilder viewBuilder;

    public Pet() {
        this.hunger = Stats.HUNGER.getINITIAL_VALUES();
        this.happiness = Stats.HAPPINESS.getINITIAL_VALUES();
        this.health = Stats.HEALTH.getINITIAL_VALUES();
        this.petState = PetState.NORMAL;
    }



    public void updatePet(Activity activity){
        if (isPetAlive()) {
            calculateStats(activity);
            viewBuilder.showStatsInNumbers();
            updatePetState();
            viewBuilder.showPet();
        }
    }

    void calculateStats(Activity activity) {
        for (HashMap.Entry<Stats,Integer> singleResult : activity.getResults().entrySet()){
            calculateSinglePetStat(singleResult.getKey(), singleResult.getValue());
        }
    }

    public void calculateSinglePetStat(Stats stats, Integer points) {
        switch (stats){
            case HAPPINESS:
                if (happiness >= 0 && happiness <= 100) {       //points in percents
                    happiness = (max(min(getHappiness() + points, Stats.HAPPINESS.getINITIAL_VALUES()), 0));
                }
                break;
            case HEALTH:
                if (health >= 0 && health <= 100) {
                    health = (min(getHealth() + points, Stats.HEALTH.getINITIAL_VALUES()));
                }
                break;
            case HUNGER:
                if (hunger >= 0 && hunger < 100) {
                    hunger = (min(max(getHunger() + points, Stats.HUNGER.getINITIAL_VALUES()), 100));
                }
                break;
        }
        checkEndGame();
    }

    private void checkEndGame() {
        if (!isPetAlive()) {
            viewBuilder.showGameOver();
        }
    }

    public boolean isPetAlive() {
        return (happiness != 0 && health != 0 && hunger != 100);
    }

    public void updatePetState() {
        int averageState = (getHappiness() + (100 - getHunger()) + getHealth())/(Stats.values().length);
        System.out.println(averageState);

        boolean isPetHungry = getHunger() > Stats.HUNGER.getCRITICAL_VALUES();
        boolean isPetSad = getHappiness() < Stats.HAPPINESS.getCRITICAL_VALUES();
        boolean isPetSick = getHealth() < Stats.HEALTH.getCRITICAL_VALUES();

        boolean isPetInAgony = averageState < 20;
        boolean isPetUnhappy = averageState >= 20 && averageState < 70;
        boolean isPetNormal = averageState >= 70 && averageState < 95;
        boolean isPetDelighted = averageState >= 95;

        if (isPetInAgony)  {
            petState = PetState.DYING;
        } else if(isPetDelighted) {
            petState = PetState.DELIGHTED;
        } else if (isPetNormal) {
            petState = PetState.NORMAL;
        } else if ((isPetHungry || isPetSick || isPetSad || isPetUnhappy) ){
            petState = PetState.UNHAPPY;
        }

        System.out.println(petState);
    }

    public int getActualStat(Stats stat){
        switch (stat){
            case HAPPINESS:
                return getHappiness();
            case HUNGER:
                return getHunger();
            case HEALTH:
                return getHealth();
        }
        return 0;
    }

    public void setViewBuilder(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
    }

    public PetState getPetState() {
        return petState;
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
