package tamagotchi.view;


public enum ActivityButtonViewsEnum {
    FEED_WITH_MEAT_VIEW("feed-meat.png"),

    FEED_WITH_BONES_VIEW("feed-bones.png"),

    PLAY_VIEW("ball.png"),

    GO_FOR_A_WALK_VIEW("collar.png"),

    HEAL_VIEW("heal-fik.png"),

    WASH_VIEW("soap.png");

    private String imageUrl;
    ActivityButtonViewsEnum(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}

