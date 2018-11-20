package tamagotchi.view;

import tamagotchi.model.PetState;

import java.util.HashMap;

public enum PetStatesView {
    DELIGHTED(new String[]{"delighted.png", "delighted1.png"}),
    NORMAL(new String[]{"normal.png"}),
    UNHAPPY(new String[]{"angry.png", "sad.png"}),
    SLEEPING(new String[]{"sleeping.png"}),
    DYING(new String[]{"dying.png"});

    private String[] imagesUrls;

    private static HashMap<PetState, PetStatesView> petStatesViewHashMap = new HashMap<PetState, PetStatesView> (){{
        put(PetState.DELIGHTED, PetStatesView.DELIGHTED);
        put(PetState.NORMAL, PetStatesView.NORMAL);
        put(PetState.UNHAPPY, PetStatesView.UNHAPPY);
        put(PetState.SLEEPING, PetStatesView.SLEEPING);
        put(PetState.DYING, PetStatesView.DYING);
    }};

    PetStatesView(String[] imagesUrls) {
        this.imagesUrls = imagesUrls;
    }

    public String[] getImagesUrls() {
        return imagesUrls;
    }

    public static HashMap<PetState, PetStatesView> getPetStatesViewHashMap() {
        return petStatesViewHashMap;
    }
}
