package tamagotchi.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.view.Executive;


public class ActivityButton extends ImageView implements Executive {

    private Activity activity;
    private Pet pet;

    public ActivityButton(Activity activity, Pet pet){

        this.activity = activity;
        this.pet = pet;
    }

    @Override
    public void execute() {
        System.out.println(activity.toString());
        pet.updateStats(activity);
//        activity.update();


    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Activity getActivity() {
        return activity;
    }
}
