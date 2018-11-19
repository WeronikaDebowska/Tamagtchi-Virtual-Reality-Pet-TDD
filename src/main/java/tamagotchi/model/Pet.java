package tamagotchi.model;

public class Pet {

    private int hunger;
    private int happiness;
    private int health;


    public Pet() {
        this.hunger = Stats.HUNGER.getINITIAL_VALUES();
        this.happiness = Stats.HAPPINESS.getINITIAL_VALUES();
        this.health = Stats.HEALTH.getINITIAL_VALUES();
    }





}
