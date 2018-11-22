package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import tamagotchi.model.*;


public class ViewBuilder {

    private Pane root;
    private Pet pet;
    private PetView petView;

    private Text actualHunger;
    private Text actualHappiness;
    private Text actualHealth;

    private Text[] actualStats = new Text[]{actualHappiness, actualHealth, actualHunger};


    public ViewBuilder(Pane root, Pet pet) {
        this.root = root;
        this.pet = pet;
        actualHealth = textifyIntValue(pet.getHealth());
        actualHappiness = textifyIntValue(pet.getHappiness());
        actualHunger = textifyIntValue(pet.getHunger());
        createView();
    }

    private void createView() {
        showBackground();
        showButtons();
        showStatsViews();
        showStatsInNumbers();
        this.petView = showPet();
        pet.setPetView(petView);
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

        root.getChildren().add(actualHunger);
        root.getChildren().add(actualHappiness);
        root.getChildren().add(actualHealth);

        final double TEXT_VERTICAL_POSITION = 90;
        final double TEXT_HORIZONTAL_POSITION = 537;
        final double DISTANCE_BETWEEN_BUTTONS = 100;

        actualHunger.setX(TEXT_HORIZONTAL_POSITION + 0 * DISTANCE_BETWEEN_BUTTONS);
        actualHunger.setFill(Color.FORESTGREEN);
        actualHunger.setY(TEXT_VERTICAL_POSITION);
        actualHappiness.setX(TEXT_HORIZONTAL_POSITION + 1 * DISTANCE_BETWEEN_BUTTONS);
        actualHappiness.setFill(Color.FORESTGREEN);
        actualHappiness.setY(TEXT_VERTICAL_POSITION);
        actualHealth.setX(TEXT_HORIZONTAL_POSITION + 2 * DISTANCE_BETWEEN_BUTTONS);
        actualHealth.setFill(Color.FORESTGREEN);
        actualHealth.setY(TEXT_VERTICAL_POSITION);
    }


    private ImageView createStatImageView(StatsView stat) {
        return new ImageView(new Image(stat.getImageUrl()));
    }

    public PetView showPet() {

        PetView petView = new PetView(pet);
        ImageView petImageView = petView.getPetImageView();
        root.getChildren().add(petImageView);
        petImageView.setX(190);
        petImageView.setY(270);

        return petView;
    }

    public void updatePetView() {
        petView.updatePetImageView();
    }

    public void showGameOver() {
        System.out.println("GAME OVER");
        Image gameOverImg = new Image("game-over.png");
        ImageView gameOver = new ImageView(gameOverImg);
        root.getChildren().add(gameOver);
    }

    private Text textifyIntValue(int intValue) {
        return new Text(((Integer) intValue).toString());
    }

    public void setActualHunger() {
        this.actualHunger.setText(((Integer) pet.getHunger()).toString());
    }

    public void setActualHappiness() {
        this.actualHappiness.setText(((Integer) pet.getHappiness()).toString());
    }

    public void setActualHealth() {
        this.actualHealth.setText(((Integer) pet.getHealth()).toString());
    }

    public void updateStatsInNumbers() {
        setActualHappiness();
        setActualHealth();
        setActualHunger();
    }
}
