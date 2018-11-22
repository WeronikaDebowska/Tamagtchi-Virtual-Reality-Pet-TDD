package tamagotchi.model;

import tamagotchi.view.PetView;
import tamagotchi.view.ViewBuilder;

import java.util.HashMap;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Pet {

    private int hunger;
    private int happiness;
    private int health;

    private boolean isPetAlive;

    private PetState petState;
    private PetView petView;

    private HashMap<Stats, Integer> actualStats = new HashMap<Stats, Integer>() {{
        put(Stats.HAPPINESS, happiness);
        put(Stats.HEALTH, health);
        put(Stats.HUNGER, hunger);

    }};

    private ViewBuilder viewBuilder;
    public Pet() {
        this.hunger = Stats.HUNGER.getINITIAL_VALUES();
        this.happiness = Stats.HAPPINESS.getINITIAL_VALUES();
        this.health = Stats.HEALTH.getINITIAL_VALUES();
        this.petState = updatePetState();
        this.isPetAlive = true;
    }

    void updatePet(Activity activity) {
        isPetStillAlive();
        if (isPetAlive) {
            calculateStats(activity);
            updatePetState();
            viewBuilder.updateStatsInNumbers();
            viewBuilder.updatePetView();
        } else {
            viewBuilder.showGameOver();
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
                updateHappiness(points);
                break;
            case HEALTH:
                updateHealth(points);
                break;
            case HUNGER:
                updateHunger(points);
                break;
        }
    }

    private void updateHunger(Integer points) {
        if (hunger >= 0 && hunger <= 100) {
            hunger = (min(max(getHunger() + points, Stats.HUNGER.getINITIAL_VALUES()), 100));
        }
    }

    private void updateHealth(Integer points) {
        if (health >= 0 && health <= 100) {
            health = (min(getHealth() + points, Stats.HEALTH.getINITIAL_VALUES()));
        }
    }

    private void updateHappiness(Integer points) {
        if (happiness >= 0 && happiness <= 100) {       //points in percents
            happiness = (max(min(getHappiness() + points, Stats.HAPPINESS.getINITIAL_VALUES()), 0));
        }
    }

    private void isPetStillAlive() {
        isPetAlive = happiness != 0 && health != 0 && hunger != 100;
        System.out.println(isPetAlive);
    }

    public boolean isPetAlive() {
        return isPetAlive;
    }

    public PetState updatePetState() {
        isPetStillAlive();
        int averageState = (getHappiness() + (100 - getHunger()) + getHealth())/(Stats.values().length);
        System.out.println(averageState);

        boolean isPetHungry = getHunger() > Stats.HUNGER.getCRITICAL_VALUES();
        boolean isPetSad = getHappiness() < Stats.HAPPINESS.getCRITICAL_VALUES();
        boolean isPetSick = getHealth() < Stats.HEALTH.getCRITICAL_VALUES();

        boolean isPetInAgony = happiness <= 10 || health <= 10 || hunger >= 90;
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
        } else {
            viewBuilder.showGameOver();
        }

        System.out.println(petState);

        return petState;
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

    void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    public void setPetView(PetView petView) {
        this.petView = petView;
    }
}
