package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Pet;

public class DialogueView extends ImageView {

    private Image dialogueImg = new Image("transparent-dialogue.png");
    private ImageView dialogueView;

    public DialogueView(Pet pet, int windowWidth, int windowHeight) {

        dialogueView = new ImageView(dialogueImg);
        this.setX(0.4 * windowWidth);         //immutable x position of dialog in the window
        this.setY(0.55 * windowHeight);         //immutable y position of dialog in the window
    }

    public void updateDialogue(Image dialogueImg) {
        dialogueView.setImage(dialogueImg);
    }

}
