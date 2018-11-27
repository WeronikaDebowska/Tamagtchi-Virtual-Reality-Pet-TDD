package tamagotchi.model;


import tamagotchi.view.PetView;
import tamagotchi.view.ViewBuilder;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class Pet {

    private int hunger;
    private int happiness;
    private int health;

    private PetState petState;
    private PetView petView;

    private HashMap<Stats, Integer> actualStats;

    private ViewBuilder viewBuilder;

    public Pet() {
        hunger = Stats.HUNGER.getINITIAL_VALUES();
        happiness = Stats.HAPPINESS.getINITIAL_VALUES();
        health = Stats.HEALTH.getINITIAL_VALUES();

        actualStats = new HashMap<Stats, Integer>() {{
            put(Stats.HAPPINESS, happiness);
            put(Stats.HEALTH, health);
            put(Stats.HUNGER, hunger);
        }};
        petState = updatePetState();
    }

    public void updatePet() {
        updatePetState();
        updatePetView();
        updateDialogue();
    }

    public PetState updatePetState() {

        int averageState = calculateAverageState();

        if (isPetDead()) {
            petState = PetState.DEAD;
        } else if (isPetInAgony()) {
            petState = PetState.DYING;
        } else if (isPetDelighted(averageState)) {
            petState = PetState.DELIGHTED;
        } else if (isPetUnhappy()) {
            petState = PetState.UNHAPPY;
        } else {
            petState = PetState.NORMAL;
        }
        return petState;
    }

    private void updatePetView() {
        if (petState != PetState.DEAD) {
            viewBuilder.updateStatsInNumbers();
            viewBuilder.updatePetView();
        } else {
            viewBuilder.showGameOver();
        }
    }

    public void updateDialogue() {
        if (getPetState() != PetState.UNHAPPY) {
            showAccurateDialoque(getPetState());
        } else {
            int lowestStat = findLowestStat();
            if (lowestStat == getActualHunger()) {
                showAccurateDialoque(PetState.HUNGRY);
            } else if (lowestStat == getActualHappiness()) {
                showAccurateDialoque(PetState.BORED);
            } else if (lowestStat == getActualHealth()) {
                showAccurateDialoque(PetState.SICK);
            }
        }
    }

    private boolean isPetDead() {
        return isAnyStatEqualZero();
    }

    private boolean isPetInAgony() {                                                //checking if any stat is under critical value
        return isAnyStatUnderCriticalLevel();
    }

    private boolean isPetDelighted(int averageState) {
        return averageState >= 90;
    }

    private boolean isPetUnhappy() {                                                //checking if any stat is under low value
        return isAnyStatUnderLowLevel();
    }

    public boolean isPetAlive() {
        return petState != PetState.DEAD;
    }

    private boolean isAnyStatUnderLowLevel() {
        for (HashMap.Entry<Stats, Integer> singleStat : actualStats.entrySet()) {
            if (isSingleStatUnderLowLevel(singleStat)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSingleStatUnderLowLevel(Map.Entry<Stats, Integer> singleStat) {
        return singleStat.getValue() < singleStat.getKey().getLOW();
    }

    private boolean isAnyStatEqualZero() {
        for (HashMap.Entry<Stats, Integer> singleStat : actualStats.entrySet()) {
            if (singleStat.getValue() == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnyStatUnderCriticalLevel() {
        for (HashMap.Entry<Stats, Integer> singleStat : actualStats.entrySet()) {
            if (isSingleStatUnderCriticalLevel(singleStat)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSingleStatUnderCriticalLevel(Map.Entry<Stats, Integer> singleStat) {
        return singleStat.getValue() < singleStat.getKey().getCRITICAL_VALUES();
    }

    private void showAccurateDialoque(PetState petState) {
        viewBuilder.updateDialogue(petView.getPetDialogues().get(petState));
    }

    void calculateStats(ActivityEnum activity) {
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
        }
    }

    private boolean isStatInRange(Stats stat) {
        return actualStats.get(stat) >= 0 && actualStats.get(stat) <= 100;
    }

    private Integer updateValue(Stats stat) {
        return max(min(actualStats.get(stat) + stat.getPOINTS_INCREASEMENT(), stat.getINITIAL_VALUES()), 0);
    }

    private Integer updateValue(Stats stat, Integer points) {
        return max(min(actualStats.get(stat) + points, stat.getINITIAL_VALUES()), 0);
    }


    private int findLowestStat() {
        int lowestStat = 100;       //initial and maximum of each stat
        for (HashMap.Entry<Stats, Integer> singleStat : actualStats.entrySet()) {
            if (singleStat.getValue() < lowestStat) {
                lowestStat = singleStat.getValue();
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

    public void setViewBuilder(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
    }

    public PetState getPetState() {
        return petState;
    }

    public HashMap<Stats, Integer> getActualStats() {
        return actualStats;
    }

    public void setPetView(PetView petView) {
        this.petView = petView;
    }

    public int getActualHunger() {
        return actualStats.get(Stats.HUNGER);
    }

    public int getActualHappiness() {
        return actualStats.get(Stats.HAPPINESS);
    }

    public int getActualHealth() {
        return actualStats.get(Stats.HEALTH);
    }

    void setHunger(int hunger) {
        actualStats.put(Stats.HUNGER, hunger);
    }

    void setHappiness(int happiness) {
        actualStats.put(Stats.HAPPINESS, happiness);
    }

    void setHealth(int health) {
        actualStats.put(Stats.HEALTH, health);
    }
}
