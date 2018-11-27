package tamagotchi.view;

public enum Dialogues {

    DELIGHTED_DIALOGUE("delighted-dialogue.png"),
    NORMAL_DIALOGUE("transparent-dialogue.png"),
    HUNGRY_DIALOGUE("hungry-dialogue.png"),
    BORED_DIALOGUE("sad-dialogue.png"),
    SICK_DIALOGUE("sick-dialogue.png"),
    DYING_DIALOGUE("dying-dialogue.png"),
    TRANSPARENT_DIALOGUE("transparent-dialogue.png");

    final private String DIALOGUE_URL;

    Dialogues(String dialogueUrl) {
        this.DIALOGUE_URL = dialogueUrl;
    }

    public String getDIALOGUE_URL() {
        return DIALOGUE_URL;
    }
}
