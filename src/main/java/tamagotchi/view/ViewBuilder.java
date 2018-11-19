package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import tamagotchi.model.Activity;
import tamagotchi.model.ActivityButton;
import tamagotchi.model.Pet;

public class ViewBuilder {

    private Pane root;
    private Pet pet;

    public ViewBuilder(Pane root, Pet pet) {
        this.root = root;
        this.pet = pet;
        setBackground();
        setButtons();
        setStatsViews();

    }


    private void setBackground() {

        Image background = new Image("background.png");
        ImageView sceneBackground = new ImageView(background);
        root.getChildren().add(sceneBackground);
    }

    private void setButtons(){

        final double HORIZONTAL_POSITION = 200;
        final double VERTICAL_POSITION = 465;

        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

        for (Activity activity : Activity.values()){
            ActivityButton activityButton = createActivityButton(activity, pet);
            ActivityButtonView activityButtonView = new ActivityButtonView(activityButton);
            addToPane(activityButtonView);
            setButtonPosition(HORIZONTAL_POSITION, VERTICAL_POSITION, DISTANCE_BETWEEN_BUTTONS, count, activityButtonView);
            count++;
        }
    }

    private ActivityButton createActivityButton(Activity activity, Pet pet) {
        return new ActivityButton(activity, pet);
    }

    private void addToPane(ActivityButtonView activityButtonViews) {
        root.getChildren().add(activityButtonViews);
    }

    private void setButtonPosition(double horizontalPos, double verticalPos, double distBetween, int count, ActivityButtonView activityButtonView) {
        activityButtonView.setX(horizontalPos + count * distBetween);
        activityButtonView.setY(verticalPos);
    }

    private void setStatsViews(){

        final double HORIZONTAL_POSITION = 500;
        final double VERTICAL_POSITION = 25;

        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

//        Text actualStat;

        for (StatsView stat : StatsView.values()){
            ImageView statImage = createStatImageView(stat);
            root.getChildren().add(statImage);          // TODO refactor to generic method addToPane(imageView);

            statImage.setX(HORIZONTAL_POSITION + count * DISTANCE_BETWEEN_BUTTONS); // TODO refactor to generic method setPositionOnPane(imageView);
            statImage.setY(VERTICAL_POSITION);

//            actualStat = new Text (pet.getActualStat())

            count++;

        }
    }


    private ImageView createStatImageView(StatsView stat) {
        return new ImageView(new Image(stat.getImageUrl()));
    }


}
