package tamagotchi.view;

public enum StatsView {
    HUNGER("hunger.png"),
    HAPPINESS("happiness.png"),
    HEALTH("health.png");

    private String imageUrl;

    StatsView(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
