package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tamagotchi.model.Activity;
import tamagotchi.model.ActivityButton;
import tamagotchi.model.Pet;
import tamagotchi.model.Stats;


public class ViewBuilder {

    private Pane root;
    private Pet pet;

    private Text actualHunger;
    private Text actualHappiness;

    private Text actualHealth;

    private AnchorPane petPane = new AnchorPane();

    public ViewBuilder(Pane root, Pet pet) {
        this.root = root;
        this.pet = pet;
        actualHealth = textifyIntValue(pet.getHealth());
        actualHappiness = textifyIntValue(pet.getHappiness());
        actualHunger = textifyIntValue(pet.getHunger());

        createView(root);
    }

    private void createView(Pane root) {
        showBackground();
        showButtons();
        showStatsViews();
        showStatsInNumbers();
        root.getChildren().add(petPane);
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

        final double TEXT_VERTICAL_POSITION = 90;
        final double TEXT_HORIZONTAL_POSITION = 537;
        final double DISTANCE_BETWEEN_BUTTONS = 100;

        root.getChildren().add(actualHunger);
        root.getChildren().add(actualHappiness);
        root.getChildren().add(actualHealth);
        actualHunger.setX(TEXT_HORIZONTAL_POSITION + 0 * DISTANCE_BETWEEN_BUTTONS);
        actualHunger.setY(TEXT_VERTICAL_POSITION);
        actualHappiness.setX(TEXT_HORIZONTAL_POSITION + 1 * DISTANCE_BETWEEN_BUTTONS);
        actualHappiness.setY(TEXT_VERTICAL_POSITION);
        actualHealth.setX(TEXT_HORIZONTAL_POSITION + 2 * DISTANCE_BETWEEN_BUTTONS);
        actualHealth.setY(TEXT_VERTICAL_POSITION);


//        }
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

    public void showGameOver() {
        System.out.println("GAME OVER");
    }

    private Text textifyIntValue(int intValue) {
        return new Text(((Integer) intValue).toString());
    }

    public void setActualHunger(int actualHunger) {
        this.actualHunger.setText(((Integer) actualHunger).toString());
    }

    public void setActualHappiness(int actualHappiness) {
        this.actualHappiness.setText(((Integer) actualHappiness).toString());
    }

    public void setActualHealth(int actualHealth) {
        this.actualHealth.setText(((Integer) actualHealth).toString());
    }
}
