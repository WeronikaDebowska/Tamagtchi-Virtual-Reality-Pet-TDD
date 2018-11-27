package tamagotchi.model;

import javafx.scene.image.ImageView;
import tamagotchi.view.ViewBuilder;


public class Activity extends ImageView implements Executive {

    final private ActivityEnum ACTIVITY;
    final private Pet PET;
    private ViewBuilder viewBuilder;

    public Activity(ActivityEnum activity, Pet pet) {

        this.ACTIVITY = activity;
        this.PET = pet;

    }

    @Override
    public void execute() {
//        PET.updatePet(ACTIVITY);

        if (PET.getPetState() != PetState.DEAD) {
            PET.calculateStats(ACTIVITY);
            PET.updatePet();

        }
    }

    public ActivityEnum getActivity() {
        return ACTIVITY;
    }


    public void setViewBuilder(ViewBuilder viewBuilder) {
        this.viewBuilder = viewBuilder;
    }
}
