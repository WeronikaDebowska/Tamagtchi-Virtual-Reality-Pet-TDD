package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Pet;
import java.util.Random;

public class PetView extends ImageView {

    private ImageView petImageView;
    private Image petImage;
    private Pet pet;
    final private int WINDOW_WIDTH;
    final private int WINDOW_HEIGHT;


    public PetView(Pet pet, int windowWidth, int windowHeight) {
        super();
        this.pet = pet;
        this.WINDOW_WIDTH = windowWidth;
        this.WINDOW_HEIGHT = windowHeight;
        setInitialImage();
    }

    void createPetImageView() {
        petImageView = new ImageView(petImage);

        final double PET_X_CO = 0.22 * WINDOW_WIDTH;
        final double PET_Y_CO = 0.49 * WINDOW_HEIGHT;
        petImageView.setX(PET_X_CO);
        petImageView.setY(PET_Y_CO);
    }

    void setInitialImage() {
        if (!isPetImageView()) {
            createPetImageView();
        }
        actualizePetImageView(new Image("delighted.png"));
    }

    public void updatePetImageView() {
        chooseImageAccordingToState();
        petImageView.setImage(petImage);
    }

    private void chooseImageAccordingToState() {
        int numberOfImagesOfState = pet.getPetState().getPetStateImgUrls().length;
        int randomInt = new Random().nextInt(numberOfImagesOfState);
        petImage = new Image(pet.getPetState().getPetStateImgUrls()[randomInt]);
    }

    private void actualizePetImageView(Image image) {
        petImageView.setImage(image);
    }

    private boolean isPetImageView() {
        return petImageView != null;
    }

    public ImageView getPetImageView() {
        return petImageView;
    }

    public Image getPetImage() {
        return petImage;
    }
}
