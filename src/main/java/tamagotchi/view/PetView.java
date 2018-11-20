package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Pet;
import tamagotchi.model.PetState;


import java.util.HashMap;
import java.util.Random;

public class PetView extends ImageView {


    private Pet pet;

    private ImageView petImageView;

    public PetView(Pet pet) {
        super();
        int randomInt = new Random().nextInt(PetStatesView.getPetStatesViewHashMap().get(pet.getPetState()).getImagesUrls().length);
        Image petImage = new Image( PetStatesView.getPetStatesViewHashMap().get(pet.getPetState()).getImagesUrls()[randomInt]);
        petImageView = new ImageView(petImage);
//        super(new Image(PetStatesView.getPetStatesViewHashMap().get(pet.getPetState()).getImagesUrls()[new Random().nextInt() + 1]));

    }

    public ImageView getPetImageView() {
        return petImageView;
    }

}
