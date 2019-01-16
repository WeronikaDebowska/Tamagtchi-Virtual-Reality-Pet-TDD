package tamagotchi.model;

import tamagotchi.view.ViewBuilder;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Pet {

    private int hunger = Stats.HUNGER.getInitialValues();
    private int happiness = Stats.HAPPINESS.getInitialValues();
    private int health = Stats.HEALTH.getInitialValues();

    private PetState petState;
    private HashMap<Stats, Integer> actualStats;

    private ViewBuilder viewBuilder;

    public Pet() {
        actualStats = new HashMap<Stats, Integer>() {{
            put(Stats.HAPPINESS, happiness);
            put(Stats.HEALTH, health);
            put(Stats.HUNGER, hunger);
        }};
        petState = updatePetState();
    }

    public void updatePet() {
        updatePetState();
        updateView();
    }

    public PetState updatePetState() {

        int averageState = calculateAverageState();

        int NORMAL_LEVEL = 80;
        int UNHAPPY_LEVEL = 50;
        int DYING_LEVEL = 30;

        if (isPetDead()) {
            petState = PetState.DEAD;
        } else if (averageState <= DYING_LEVEL) {
            petState = PetState.DYING;
        } else if ((averageState <= UNHAPPY_LEVEL)) {
            petState = PetState.UNHAPPY;
        } else if ((averageState <= NORMAL_LEVEL)) {
            petState = PetState.NORMAL;
        } else {
            petState = PetState.DELIGHTED;
        }
        return petState;
    }

    private void updateView() {
        viewBuilder.updateView();
    }

    public String getAccurateDialogueUrl() {

        String imgUrl = "";

        if (getPetState() != PetState.UNHAPPY) {
            imgUrl = petState.getDialogueUrl();
        } else {
            Stats lowestStat = findLowestStat();
            imgUrl = lowestStat.getDialogueImgUrl();
        }
        return imgUrl;
    }

    public void interact(Activity activity) {
        if (petState != PetState.DEAD) {
            calculateStats(activity);
            updateView();
        }
    }

    public boolean isPetDead() {
        return isAnyStatEqualZero();
    }

    private boolean isAnyStatEqualZero() {
        for (HashMap.Entry<Stats, Integer> singleStat : actualStats.entrySet()) {
            if (singleStat.getValue() == 0) {
                return true;
            }
        }
        return false;
    }

    private void calculateStats(Activity activity) {
        for (HashMap.Entry<Stats,Integer> singleResult : activity.getResults().entrySet()){
            updateStat(singleResult.getKey(), singleResult.getValue());
        }
    }

    private void updateStat(Stats stat, Integer points) {
        if (isStatInRange(stat)) {
            actualStats.put(stat, updateValue(stat, points));
        }
    }

    public void updateStat(Stats stat) {
        if (isStatInRange(stat)) {
            actualStats.put(stat, updateValue(stat));
            for (Map.Entry<Stats, Integer> entry : actualStats.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println();
            }
        }
    }

    private boolean isStatInRange(Stats stat) {
        return actualStats.get(stat) >= 0 && actualStats.get(stat) <= 100;
    }

    private Integer updateValue(Stats stat) {
        return max(min(actualStats.get(stat) + stat.getPointsIncreasement(), stat.getInitialValues()), 0);
    }

    private Integer updateValue(Stats stat, Integer points) {
        return max(min(actualStats.get(stat) + points, stat.getInitialValues()), 0);
    }


    private Stats findLowestStat() {
        int lowestStatValue = 100;      //initial and maximum of each stat
        Stats lowestStat = null;
        for (HashMap.Entry<Stats, Integer> singleStat : actualStats.entrySet()) {
            if (singleStat.getValue() < lowestStatValue) {
                lowestStatValue = singleStat.getValue();
                lowestStat = singleStat.getKey();
            }
        }
        return lowestStat;
    }

    private int calculateAverageState() {
        int total = countSumOfStats();
        int numberOfStats = (Stats.values().length);
        return total / numberOfStats;
    }

    private int countSumOfStats() {
        int total = 0;
        for (HashMap.Entry<Stats, Integer> singleStat : actualStats.entrySet()) {
            total += singleStat.getValue();
        }
        return total;
    }

    public PetState getPetState() {
        return petState;
    }

    public int getActualStat(Stats stat) {
        return actualStats.get(stat);
    }

    public void setViewBuilder(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
    }
}
