package tamagotchi.view;

public enum StatsView {

    HUNGER_VIEW("hunger.png"),
    HAPPINESS_VIEW("happiness.png"),
    HEALTH_VIEW("health.png");

    private String imageUrl;

    StatsView(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
