package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Activity;

public class ActivityButtonView extends ImageView {

    private Activity activityButton;


    public ActivityButtonView(Activity activityButton) {
        super(new Image(activityButton.getActivity().getImage()));
        this.activityButton = activityButton;
        this.setOnMouseClicked(lambda -> {
            activityButton.execute();

        });
    }
}
