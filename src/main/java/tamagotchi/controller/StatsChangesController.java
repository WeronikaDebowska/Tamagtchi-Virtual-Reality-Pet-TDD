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
            Executors.newScheduledThreadPool(10);
    private Stats stat;
    private Pet pet;
    private ViewBuilder viewBuilder;
    private ScheduledFuture<?> gameUpdating;

    public StatsChangesController(Stats stat, Pet pet) {
        this.stat = stat;
        this.pet = pet;
    }


    public void changeStatsInTime() {

        if (pet.isPetAlive()) {

            final Runnable changeStats = new Runnable() {
                public void run() {

                    if (pet.isPetAlive()) {
                        pet.updateStat(stat);
                        viewBuilder.updateStatsInNumbers();
                        pet.updatePet();
                        pet.updateDialogue();
                    }
                }
            };

            long initialDelay = 5000;
            gameUpdating = scheduler.scheduleAtFixedRate(changeStats, initialDelay, stat.getTIME_INTERVAL_MILISEC(), MILLISECONDS);
        }
    }

    public void setViewBuilder(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
    }

}
