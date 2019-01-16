package tamagotchi.controller;

import tamagotchi.model.Pet;
import tamagotchi.view.*;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class PetController {

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(10);
    private Pet pet;
    private ViewBuilder viewBuilder;
    private ScheduledFuture<?> petUpdating;

    PetController(Pet pet, ViewBuilder viewBuilder) {
        this.pet = pet;
        this.viewBuilder = viewBuilder;
    }


    void updatePetStateInTime() {

        if (!pet.isPetDead()) {

            final Runnable changePetView = new Runnable() {
                public void run() {
                    pet.updatePetState();
                    System.out.println(pet.getPetState().toString());

                    if (!pet.isPetDead()) {
                        viewBuilder.updatePetView();
//                        viewBuilder.updateDialogue();
                    }
                }
            };
            petUpdating = scheduler.scheduleAtFixedRate(changePetView, 5000, 500, MILLISECONDS);
        }
    }
}
