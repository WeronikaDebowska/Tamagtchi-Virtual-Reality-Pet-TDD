package tamagotchi.controller;

import tamagotchi.model.Pet;
import tamagotchi.model.Stats;
import tamagotchi.view.ViewBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class StatsChangesController {

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(5);
    private Stats stat;
    private Pet pet;
    private ViewBuilder viewBuilder;
    private ScheduledFuture<?> gameUpdating;

    public StatsChangesController(Stats stat, Pet pet) {
        this.stat = stat;
        this.pet = pet;
    }


    public void updateStats() {

        if (pet.isPetAlive()) {

            final Runnable gameUpdate = new Runnable() {
                public void run() {

                    if (pet.isPetAlive()) {
                        pet.calculateSinglePetStat(stat, stat.getPOINTS_INCREASEMENT());
                        switch (stat) {
                            case HAPPINESS:
                                viewBuilder.setActualHappiness(pet.getHappiness());
                                break;
                            case HUNGER:
                                viewBuilder.setActualHunger(pet.getHunger());
                                break;
                            case HEALTH:
                                viewBuilder.setActualHealth(pet.getHealth());
                                break;
                        }
                        pet.updatePetState();
                    }
                }
            };

            long initialDelay = 2000;
            gameUpdating = scheduler.scheduleAtFixedRate(gameUpdate, initialDelay, stat.getTIME_INTERVAL_MILISEC(), MILLISECONDS);
        }
    }

    public void setViewBuilder(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
    }

}
