package tamagotchi.model;

import org.junit.jupiter.api.BeforeEach;
import tamagotchi.controller.*;
import tamagotchi.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tests {

//    @BeforeEach
//    // creating a pet
//    Pet createTestingPet(){
//        return new Pet();
//    }

    @Test
    // checking FEED_WITH_MEAT execution
    void IsFeedingWithMeatWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 100;
        int expectedHunger = initialHunger-20;
        pet.setHunger(initialHunger);

        //when
        Activity activity = Activity.FEED_WITH_MEAT;


        //then
        pet.updateStats(activity);
        int count = pet.getHunger();
        assertEquals(expectedHunger, count);
    }

    @Test
        // checking FEED_WITH_BONES execution
    void IsFeedingWithBonesWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 100;
        int expectedHunger = initialHunger - 10;
        int initialHappines = 100;
        int expectedHappiness = initialHappines + 10;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappines);

        //when
        Activity activity = Activity.FEED_WITH_BONES;

        //then
        pet.updateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking FEED_WITH_BONES execution
    void IsPlayingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 100;
        int expectedHunger = initialHunger + 20;
        int initialHappiness = 100;
        int expectedHappiness = initialHappiness + 30;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappiness);

        //when
        Activity activity = Activity.PLAY;

        //then
        pet.updateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking FEED_WITH_BONES execution
    void IsWalkingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 100;
        int expectedHunger = initialHunger + 10;
        int initialHappiness = 100;
        int expectedHappiness = initialHappiness + 20;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappiness);

        //when
        Activity activity = Activity.GO_FOR_A_WALK;

        //then
        pet.updateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking FEED_WITH_BONES execution
    void IsHealingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHealth = 100;
        int expectedHealth = initialHealth + 50;
        int initialHappiness = 100;
        int expectedHappiness = initialHappiness - 20;

        pet.setHealth(initialHealth);
        pet.setHappiness(initialHappiness);

        //when
        Activity activity = Activity.HEAL;

        //then
        pet.updateStats(activity);
        int countHealth = pet.getHealth();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHealth, countHealth);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking FEED_WITH_BONES execution
    void IsWashingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHealth = 100;
        int expectedHealth = initialHealth + 10;
        int initialHappiness = 100;
        int expectedHappiness = initialHappiness - 10;

        pet.setHealth(initialHealth);
        pet.setHappiness(initialHappiness);

        //when
        Activity activity = Activity.WASH;

        //then
        pet.updateStats(activity);
        int countHealth = pet.getHealth();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHealth, countHealth);
        assertEquals(expectedHappiness, countHappiness);
    }


}
