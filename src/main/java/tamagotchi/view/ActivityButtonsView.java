package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Activity;
import tamagotchi.model.Pet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityButtonsView extends ImageView {

    final private int WINDOW_WIDTH;
    final private int WINDOW_HEIGHT;
    private List<ImageView> activityButtonsList;
    private Pet pet;

    public ActivityButtonsView(Pet pet, int windowWidth, int windowHeight) {
        this.pet = pet;
        this.WINDOW_WIDTH = windowWidth;
        this.WINDOW_HEIGHT = windowHeight;
        this.activityButtonsList = Arrays
                .stream(Activity.values())
                .map(act -> createButton(act))
                .collect(Collectors.toList());
    }

    private ImageView createButton(Activity activity) {

        ImageView buttonView = new ImageView(new Image(activity.getImage()));

        final double HORIZONTAL_POSITION = 0.1 * WINDOW_WIDTH;
        final double VERTICAL_POSITION = 0.82 * WINDOW_HEIGHT;
        final double DISTANCE_BETWEEN_BUTTONS = 0.12 * WINDOW_WIDTH;

        buttonView.setX(HORIZONTAL_POSITION + activity.ordinal() * DISTANCE_BETWEEN_BUTTONS);
        buttonView.setY(VERTICAL_POSITION);
        buttonView.setOnMouseClicked(e -> pet.interact(activity));

        return buttonView;
    }

    public List<ImageView> getActivityButtonsList() {
        return activityButtonsList;
    }


}
