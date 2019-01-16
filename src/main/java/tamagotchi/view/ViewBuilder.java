package tamagotchi.view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import tamagotchi.model.*;

import java.util.List;


public class ViewBuilder implements Viewer {

    final private Pane ROOT;
    final private Pet PET;

    final private int WINDOW_WIDTH;
    final private int WINDOW_HEIGHT;

    private PetView petView;
    private ImageView petImageView;

    private ImageView sceneBackground;

    private StatsView statsView;
    private ActivityButtonsView activityButtonsList;

    private DialogueView dialogueView;

    private Image dialogue;


    public ViewBuilder(Pane root, Pet pet, int windowWidth, int windowHeight) {
        this.ROOT = root;
        this.PET = pet;
        this.WINDOW_WIDTH = windowWidth;
        this.WINDOW_HEIGHT = windowHeight;

        activityButtonsList = new ActivityButtonsView(PET, WINDOW_WIDTH, WINDOW_HEIGHT);
        dialogueView = new DialogueView(PET, WINDOW_WIDTH, WINDOW_HEIGHT);
        statsView = new StatsView(PET, WINDOW_WIDTH, WINDOW_HEIGHT);
        petView = new PetView(PET, WINDOW_WIDTH, WINDOW_HEIGHT);
        petImageView = petView.getPetImageView();

        createView();
    }

    private void createView() {
        showBackground();
        showButtons();
        showStatsViews();
        showStatsInNumbers();
        showPet();
        showDialogue();
    }

    public void updateView() {

        if (!PET.isPetDead()) {
            updatePetView();
            updateDialogue();
            updateStatsInNumbers();
        } else {
            showGameOver();
        }
    }

    private void showBackground() {
        Image background = new Image("background.png");
        sceneBackground = new ImageView(background);
        addToPane(sceneBackground);
    }

    private void showButtons(){
        addToPane(activityButtonsList.getActivityButtonsList());
    }

    private void showStatsViews(){
        addToPane(statsView.getStatsViewList());
    }

    private void showStatsInNumbers() {
        addToPane(statsView.getStatTexts());
    }

    private void showPet() {
        addToPane(petImageView);
    }

    private void showDialogue() {
        addToPane(dialogueView);
    }

    public void updatePetView() {
        petView.updatePetImageView();
        petImageView.setImage(petView.getPetImage());
    }

    public void updateStatsInNumbers() {
        statsView.updateStatText();
    }

    public void updateDialogue() {
        dialogue = new Image(PET.getAccurateDialogueUrl());
        dialogueView.setImage(dialogue);
    }

    public void showGameOver() {
        dialogue = new Image("transparent-dialogue.png");
        dialogueView.updateDialogue(dialogue);

        Image gameOverImg = new Image("game-over.png");
        sceneBackground.setImage(gameOverImg);
    }

    private <T extends Node> void addToPane(T node) {
        ROOT.getChildren().add(node);
    }

    private <T extends Node> void addToPane(List<T> nodes) {
        ROOT.getChildren().addAll(nodes);
    }
}
