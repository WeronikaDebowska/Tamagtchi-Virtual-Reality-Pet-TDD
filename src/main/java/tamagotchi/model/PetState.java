package tamagotchi.model;

public enum PetState {
    DELIGHTED(new String[]{"delighted.png", "delighted1.png"}, "delighted-dialogue.png"),
    NORMAL(new String[]{"normal.png", "normal1.png"}, "transparent-dialogue.png"),
    UNHAPPY(new String[]{"angry.png", "sad.png"}, "transparent-dialogue.png"),
    DYING(new String[]{"dying.png"}, "dying-dialogue.png"),
    DEAD(new String[]{"dying.png"}, "transparent-dialogue.png"),

    BORED(new String[]{"angry.png", "sad.png"}, "sad-dialogue.png"),
    HUNGRY(new String[]{"angry.png", "sad.png"}, "hungry-dialogue.png"),
    SICK(new String[]{"angry.png", "sad.png"}, "sick-dialogue.png"),
    ;

    final private String[] PET_STATE_IMG_URLS;
    final private String DIALOGUE_URL;

    PetState(String[] PET_STATE_IMG_URLS, String DIALOGUE_URL) {
        this.PET_STATE_IMG_URLS = PET_STATE_IMG_URLS;
        this.DIALOGUE_URL = DIALOGUE_URL;
    }

    public String[] getPetStateImgUrls() {
        return PET_STATE_IMG_URLS;
    }

    public String getDialogueUrl() {
        return DIALOGUE_URL;
    }
}



