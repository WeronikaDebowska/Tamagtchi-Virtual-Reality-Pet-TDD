package tamagotchi.model;

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
        int initialHunger = 50;
        int expectedHunger = initialHunger-20;
        pet.setHunger(initialHunger);

        //when
        ActivityEnum activity = ActivityEnum.FEED_WITH_MEAT;

        //then
        pet.calculateStats(activity);
        int count = pet.getHunger();
        assertEquals(expectedHunger, count);
    }

    @Test
        // checking FEED_WITH_BONES execution
    void IsFeedingWithBonesWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 50;
        int expectedHunger = initialHunger - 10;
        int initialHappines = 50;
        int expectedHappiness = initialHappines + 10;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappines);

        //when
        ActivityEnum activity = ActivityEnum.FEED_WITH_BONES;

        //then
        pet.calculateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking PLAY execution
    void IsPlayingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 50;
        int expectedHunger = initialHunger + 20;
        int initialHappiness = 50;
        int expectedHappiness = initialHappiness + 30;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.PLAY;

        //then
        pet.calculateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking GO_FOR_A_WALK execution
    void IsWalkingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 50;
        int expectedHunger = initialHunger + 10;
        int initialHappiness = 50;
        int expectedHappiness = initialHappiness + 20;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.GO_FOR_A_WALK;

        //then
        pet.calculateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking HEAL execution
    void IsHealingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHealth = 50;
        int expectedHealth = initialHealth + 30;
        int initialHappiness = 50;
        int expectedHappiness = initialHappiness - 20;

        pet.setHealth(initialHealth);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.HEAL;

        //then
        pet.calculateStats(activity);
        int countHealth = pet.getHealth();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHealth, countHealth);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking WASH execution
    void IsWashingWorking(){

        Pet pet = new Pet();

        //GIVEN
        int initialHealth = 50;
        int expectedHealth = initialHealth + 10;
        int initialHappiness = 50;
        int expectedHappiness = initialHappiness - 5;

        pet.setHealth(initialHealth);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.WASH;

        //then
        pet.calculateStats(activity);
        int countHealth = pet.getHealth();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHealth, countHealth);
        assertEquals(expectedHappiness, countHappiness);
    }


    @Test
        // checking FEED_WITH_MEAT execution on boundary conditions
    void CheckFeedingWithMeatBoundaryConditions(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 10;
        int expectedHunger = 0;     //hunger not lower than 0
        pet.setHunger(initialHunger);

        //when
        ActivityEnum activity = ActivityEnum.FEED_WITH_MEAT;

        //then
        pet.calculateStats(activity);
        int count = pet.getHunger();
        assertEquals(expectedHunger, count);
    }

    @Test
        // checking FEED_WITH_BONES execution on boundary conditions
    void CheckFeedingWithBonesBoundaryConditions(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 5;
        int expectedHunger = 0;
        int initialHappiness = 95;
        int expectedHappiness = 100;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.FEED_WITH_BONES;

        //then
        pet.calculateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking PLAYING execution on boundary conditions
    void CheckPlayingBoundaryConditions(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 100;
        int expectedHunger = 100;
        int initialHappiness = 100;
        int expectedHappiness = 100;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.PLAY;

        //then
        pet.calculateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking GO_FRO_A_WALK execution on boundary conditions
    void CheckWalkingBoundaryConditions(){

        Pet pet = new Pet();

        //GIVEN
        int initialHunger = 95;
        int expectedHunger = 100;
        int initialHappiness = 85;
        int expectedHappiness = 100;

        pet.setHunger(initialHunger);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.GO_FOR_A_WALK;

        //then
        pet.calculateStats(activity);
        int countHunger = pet.getHunger();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHunger, countHunger);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking HEAL execution on boundary conditions
    void CheckHealingBoundaryConditions(){

        Pet pet = new Pet();

        //GIVEN
        int initialHealth = 90;
        int expectedHealth = 100;
        int initialHappiness = 15;
        int expectedHappiness = 0;

        pet.setHealth(initialHealth);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.HEAL;

        //then
        pet.calculateStats(activity);
        int countHealth = pet.getHealth();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHealth, countHealth);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking WASH execution on boundary conditions
    void CheckWashingBoundaryConditions(){

        Pet pet = new Pet();

        //GIVEN
        int initialHealth = 95;
        int expectedHealth = 100;
        int initialHappiness = 3;
        int expectedHappiness = 0;

        pet.setHealth(initialHealth);
        pet.setHappiness(initialHappiness);

        //when
        ActivityEnum activity = ActivityEnum.WASH;

        //then
        pet.calculateStats(activity);
        int countHealth = pet.getHealth();
        int countHappiness = pet.getHappiness();
        assertEquals(expectedHealth, countHealth);
        assertEquals(expectedHappiness, countHappiness);
    }

    @Test
        // checking initial PetStates
    void IsNormalStateInitially(){

        Pet pet = new Pet();

        //given
        PetState expectedPetState = PetState.NORMAL;

        //then
        PetState actualState = pet.getPetState();
        assertEquals(actualState, expectedPetState);
    }

    @Test
        // checking PetStates setting properly according to high Hunger level
    void CheckHungerResultsInStates(){

        Pet pet = new Pet();

        //given
        int hungerCausingUnhappyState = 31;
        PetState expectedPetState = PetState.UNHAPPY;

        //when
        pet.setHunger(hungerCausingUnhappyState);
        pet.updatePetState();

        //then
        PetState actualState = pet.getPetState();
        assertEquals(actualState, expectedPetState);
    }

    @Test
        // checking PetStates setting properly according to low Happiness level
    void CheckHappinessResultsInStates(){

        Pet pet = new Pet();

        //given
        int happinessCausingUnhappyState = 69;
        PetState expectedPetState = PetState.UNHAPPY;

        //when
        pet.setHappiness(happinessCausingUnhappyState);
        pet.updatePetState();

        //then
        PetState actualState = pet.getPetState();
        assertEquals(actualState, expectedPetState);
    }

    @Test
        // checking PetStates setting properly according to low Health level
    void CheckHealthResultsInStates(){

        Pet pet = new Pet();

        //given
        int healthCausingUnhappyState = 49;
        PetState expectedPetState = PetState.UNHAPPY;

        //when
        pet.setHealth(healthCausingUnhappyState);
        pet.updatePetState();

        //then
        PetState actualState = pet.getPetState();
        assertEquals(actualState, expectedPetState);
    }

    @Test
        // checking PetStates setting properly according to low averageState level
    void CheckAverageStateResultsInUnhappyState(){

        Pet pet = new Pet();

        //given
        int hunger = 29;
        int happiness = 71;
        int health = 63;
        PetState expectedPetState = PetState.UNHAPPY;

        //when
        pet.setHunger(hunger);
        pet.setHappiness(happiness);
        pet.setHealth(health);
        pet.updatePetState();

        //then
        PetState actualState = pet.getPetState();
        assertEquals(actualState, expectedPetState);
    }

    @Test
        // checking PetStates setting properly according to critically low averageState level
    void CheckAverageStateResultsInDyingState(){

        Pet pet = new Pet();

        //given
        int hunger = 81;
        int happiness = 19;
        int health = 19;
        PetState expectedPetState = PetState.DYING;

        //when
        pet.setHunger(hunger);
        pet.setHappiness(happiness);
        pet.setHealth(health);
        pet.updatePetState();

        //then
        PetState actualState = pet.getPetState();
        assertEquals(actualState, expectedPetState);
    }

    @Test
        // checking PetStates setting properly according to high averageState level
    void CheckAverageStateResultsInDelightedState(){

        Pet pet = new Pet();

        //given
        int hunger = 10;
        int happiness = 95;
        int health = 91;
        PetState expectedPetState = PetState.DELIGHTED;

        //when
        pet.setHunger(hunger);
        pet.setHappiness(happiness);
        pet.setHealth(health);
        pet.updatePetState();

        //then
        PetState actualState = pet.getPetState();
        assertEquals(actualState, expectedPetState);
    }

}
