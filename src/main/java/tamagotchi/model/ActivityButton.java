package tamagotchi.model;

import javafx.scene.image.ImageView;


public class ActivityButton extends ImageView implements Executive {

    final private Activity ACTIVITY;
    final private Pet PET;

    public ActivityButton(Activity activity, Pet pet){

        this.ACTIVITY = activity;
        this.PET = pet;
    }

    @Override
    public void execute() {
        PET.updatePet(ACTIVITY);
    }

    public Activity getActivity() {
        return ACTIVITY;
    }
}
