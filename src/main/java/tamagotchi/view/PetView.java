package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Pet;
import tamagotchi.model.PetState;


import java.util.HashMap;
import java.util.Random;

public class PetView extends ImageView {


    private ImageView petImageView;
    private Image petImage;
    private Pet pet;

    private HashMap<PetState, PetStatesView> petStatesImages = new HashMap<PetState, PetStatesView>() {{
        put(PetState.DELIGHTED, PetStatesView.DELIGHTED_VIEW);
        put(PetState.NORMAL, PetStatesView.NORMAL_VIEW);
        put(PetState.UNHAPPY, PetStatesView.UNHAPPY_VIEW);
        put(PetState.SLEEPING, PetStatesView.SLEEPING_VIEW);
        put(PetState.DYING, PetStatesView.DYING_VIEW);
    }};

    PetView(Pet pet) {
        super();
        this.pet = pet;
        updatePetImageView();
    }

    void createPetImageView() {
        petImageView = new ImageView(petImage);
    }

    void updatePetImageView() {
        chooseImageAccordingToState();
        if (!isPetImageView()) {
            createPetImageView();
        } else {
            actualizePetImageView();
        }
    }

    private void chooseImageAccordingToState() {
        petImage = getRandomPetStateImg();
    }

    private void actualizePetImageView() {
        petImageView.setImage(petImage);
    }

    private boolean isPetImageView() {
        return petImageView != null;
    }

    private Image getRandomPetStateImg() {
        int randomInt = getRandomIntToChosePetImg();
        return getImage(randomInt);
    }

    private Image getImage(int randomInt) {
        return new Image(petStatesImages.get(pet.getPetState()).getImagesUrls()[randomInt]);
    }

    private int getRandomIntToChosePetImg() {
        int numberOfImagesOfState = petStatesImages.get(pet.getPetState()).getImagesUrls().length;
        return new Random().nextInt(numberOfImagesOfState);
    }

    public ImageView getPetImageView() {
        return petImageView;
    }


}
