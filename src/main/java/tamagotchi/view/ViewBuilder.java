package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tamagotchi.model.Activity;
import tamagotchi.model.ActivityButton;
import tamagotchi.model.Pet;
import tamagotchi.model.Stats;

public class ViewBuilder {

    private Pane root;
    private Pet pet;

    private Pane statsInNumbers = new Pane();
    private Pane petPane = new Pane();


    public ViewBuilder(Pane root, Pet pet) {
        this.root = root;
        this.pet = pet;
        showBackground();
        showButtons();
        showStatsViews();
        root.getChildren().add(statsInNumbers);
        root.getChildren().add(petPane);
        showStatsInNumbers();
        showPet();

    }


    private void showBackground() {

        Image background = new Image("background.png");
        ImageView sceneBackground = new ImageView(background);
        root.getChildren().add(sceneBackground);
    }

    private void showButtons(){

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

    private void showStatsViews(){

        final double HORIZONTAL_POSITION = 500;
        final double VERTICAL_POSITION = 25;

        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;


        for (Stats stat : Stats.values()){
            ImageView statImage = createStatImageView(stat.getSTAT_VIEW());
            root.getChildren().add(statImage);          // TODO refactor to generic method addToPane(imageView);

            statImage.setX(HORIZONTAL_POSITION + count * DISTANCE_BETWEEN_BUTTONS); // TODO refactor to generic method setPositionOnPane(imageView);
            statImage.setY(VERTICAL_POSITION);

            count++;

        }
    }

    public void showStatsInNumbers() {

        statsInNumbers.getChildren().clear();

        final double TEXT_VERTICAL_POSITION = 90;
        final double TEXT_HORIZONTAL_POSITION = 535;

        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

        for (Stats stat : Stats.values()) {

            Text actualStat;
            actualStat = new Text(Integer.toString(pet.getActualStat(stat)) + " " + "%");
            statsInNumbers.getChildren().add(actualStat);
            actualStat.setX(TEXT_HORIZONTAL_POSITION + count * DISTANCE_BETWEEN_BUTTONS);
            actualStat.setY(TEXT_VERTICAL_POSITION);
            count++;
        }
    }

    private ImageView createStatImageView(StatsView stat) {
        return new ImageView(new Image(stat.getImageUrl()));
    }

    public void showPet(){

        petPane.getChildren().clear();

        ImageView petView = new PetView(pet).getPetImageView();
        petPane.getChildren().add(petView);
        petView.setX(190);
        petView.setY(270);
    }


}
