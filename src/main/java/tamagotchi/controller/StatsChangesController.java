package tamagotchi.controller;


import tamagotchi.model.Pet;
import tamagotchi.model.Stats;
import tamagotchi.view.ViewBuilder;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class StatsChangesController {

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(3);

    private Pet pet;
    private ViewBuilder viewBuilder;
    private ScheduledFuture<?> gameUpdating;

    StatsChangesController(Pet pet, ViewBuilder viewBuilder) {
        this.pet = pet;
        this.viewBuilder = viewBuilder;
        startChangingAllStats();
    }

    private void startChangingAllStats() {
        Arrays
                .stream(Stats.values())
                .peek(stat -> changeStatsInTime(stat))
                .collect(Collectors.toList());
    }


    public void changeStatsInTime(Stats stat) {

        if (!pet.isPetDead()) {

            final Runnable changeStats = new Runnable() {
                public void run() {

                    if (!pet.isPetDead()) {
                        pet.updateStat(stat);
                        pet.updatePet();
                        viewBuilder.updateView();
                    }
                }
            };

            long initialDelay = 5000;
            gameUpdating = scheduler.scheduleAtFixedRate(changeStats, initialDelay, stat.getTimeInterval(), MILLISECONDS);
        }
    }

}
