package tamagotchi.view;

public enum PetStatesView {


    DELIGHTED_VIEW(new String[]{"delighted.png", "delighted1.png"}),
    NORMAL_VIEW(new String[]{"normal.png", "normal1.png"}),
    UNHAPPY_VIEW(new String[]{"angry.png", "sad.png"}),
    SLEEPING_VIEW(new String[]{"sleeping.png"}),
    DYING_VIEW(new String[]{"dying.png"});

    private String[] PetStatesImgUrls;

    PetStatesView(String[] PetStatesImgUrls) {
        this.PetStatesImgUrls = PetStatesImgUrls;
    }

    public String[] getImagesUrls() {
        return PetStatesImgUrls;
    }

}
