package tamagotchi.view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tamagotchi.model.*;


public class ViewBuilder {

    private Pane root;
    private Pet pet;
    private PetView petView;

    private ImageView sceneBackground;

    private Text actualHunger;
    private Text actualHappiness;
    private Text actualHealth;

    private Text[] actualStats;

    private ImageView dialogueView;
    private Image dialogue;


    public ViewBuilder(Pane root, Pet pet) {
        this.root = root;
        this.pet = pet;
        actualHealth = textifyIntValue(pet.getActualHealth());
        actualHappiness = textifyIntValue(pet.getActualHappiness());
        actualHunger = textifyIntValue(pet.getActualHunger());
        actualStats = new Text[]{actualHunger, actualHappiness, actualHealth};

        createView();
    }

    private void createView() {
        showBackground();
        showButtons();
        showStatsViews();
        showStatsInNumbers();
        this.petView = showPet();
        attachPetViewToPet();
        showDialogue();
    }

    private void showBackground() {

        Image background = new Image("background.png");
        sceneBackground = new ImageView(background);
        addToPane(sceneBackground);
    }

    private void showButtons(){

        final double HORIZONTAL_POSITION = 200;
        final double VERTICAL_POSITION = 465;
        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

        for (ActivityEnum activity : ActivityEnum.values()) {

            Activity activityButton = createActivityButton(activity, pet);
            ActivityButtonView activityButtonView = new ActivityButtonView(activityButton);
            addToPane(activityButtonView);
            setButtonPosition(HORIZONTAL_POSITION, VERTICAL_POSITION, DISTANCE_BETWEEN_BUTTONS, count, activityButtonView);
            count++;
        }
    }

    private void showStatsViews(){

        final double HORIZONTAL_POSITION = 500;
        final double VERTICAL_POSITION = 25;

        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

        for (Stats stat : Stats.values()){
            ImageView statImage = createStatImageView(stat.getSTAT_VIEW());
            addToPane(statImage);
            statImage.setX(HORIZONTAL_POSITION + count * DISTANCE_BETWEEN_BUTTONS);
            statImage.setY(VERTICAL_POSITION);
            count++;
        }
    }

    private void setButtonPosition(double horizontalPos, double verticalPos, double distBetween, int count, ActivityButtonView activityButtonView) {
        activityButtonView.setX(horizontalPos + count * distBetween);
        activityButtonView.setY(verticalPos);
    }

    private void showStatsInNumbers() {

        final double TEXT_VERTICAL_POSITION = 90;
        final double TEXT_HORIZONTAL_POSITION = 537;
        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

        for (Text stat : actualStats) {
            addToPane(stat);
            stat.setY(TEXT_VERTICAL_POSITION);
            stat.setX(TEXT_HORIZONTAL_POSITION + count * DISTANCE_BETWEEN_BUTTONS);
            count++;
        }
    }


    private ImageView createStatImageView(StatsView stat) {
        return new ImageView(new Image(stat.getImageUrl()));
    }

    private PetView showPet() {

        PetView petView = new PetView(pet);
        ImageView petImageView = petView.getPetImageView();
        addToPane(petImageView);

        final int PET_X_CO = 190;
        final int PET_Y_CO = 270;
        petImageView.setX(PET_X_CO);
        petImageView.setY(PET_Y_CO);

        return petView;
    }

    private void showDialogue() {
        dialogue = new Image(Dialogues.TRANSPARENT_DIALOGUE.getDIALOGUE_URL());
        dialogueView = new ImageView(dialogue);
        addToPane(dialogueView);
        dialogueView.setX(370);         //immutable x position of dialog in the window
        dialogueView.setY(250);         //immutable y position of dialog in the window
    }


    private Text textifyIntValue(int intValue) {
        return new Text(((Integer) intValue).toString());
    }

    public void updatePetView() {
        petView.updatePetImageView();
    }

    public void showGameOver() {
        dialogue = new Image(Dialogues.TRANSPARENT_DIALOGUE.getDIALOGUE_URL());
        dialogueView.setImage(dialogue);

        Image gameOverImg = new Image("game-over.png");
        sceneBackground.setImage(gameOverImg);
    }

    public void updateStatsInNumbers() {
        setActualHappiness();
        setActualHealth();
        setActualHunger();
    }


    public void updateDialogue(Dialogues dialogueToDisplay) {
        dialogue = new Image(dialogueToDisplay.getDIALOGUE_URL());
        dialogueView.setImage(dialogue);
    }

    private void attachPetViewToPet() {
        pet.setPetView(petView);
    }

    private Activity createActivityButton(ActivityEnum activity, Pet pet) {
        return new Activity(activity, pet);
    }

    private <T extends Node> void addToPane(T node) {
        root.getChildren().add(node);
    }

    private void setActualHunger() {
        this.actualHunger.setText((pet.getActualStats().get(Stats.HUNGER)).toString());
    }

    private void setActualHappiness() {
        this.actualHappiness.setText((pet.getActualStats().get(Stats.HAPPINESS)).toString());
    }

    private void setActualHealth() {
        this.actualHealth.setText((pet.getActualStats().get(Stats.HEALTH)).toString());
    }
}
