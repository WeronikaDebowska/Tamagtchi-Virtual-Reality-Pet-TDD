package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Activity;
import tamagotchi.model.ActivityButton;

public class ActivityButtonView extends ImageView {

    private ActivityButton activityButton;


    public ActivityButtonView(ActivityButton activityButton) {
        super(new Image(activityButton.getActivity().getImage()));
        this.activityButton = activityButton;
        this.setOnMouseClicked(lambda -> {
            activityButton.execute();
        });
    }
}
