package tamagotchi.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tamagotchi.model.Pet;
import tamagotchi.model.Stats;
import tamagotchi.view.ViewBuilder;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        final int WIDTH = 840;             //window width
        final int HEIGHT = 560;             //window height

        Pane root = new Pane();
        Pet pet = new Pet();
        ViewBuilder viewBuilder = new ViewBuilder(root, pet);
        attachViewBuilderToPet(pet, viewBuilder);
        createControllersForAllStats(pet, viewBuilder);
        Scene scene = new Scene(root, WIDTH, HEIGHT);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Tamagotchi");
        primaryStage.show();


    }

    private void attachViewBuilderToPet(Pet pet, ViewBuilder viewBuilder) {
        pet.setViewBuilder(viewBuilder);
    }

    private void createControllersForAllStats(Pet pet, ViewBuilder viewBuilder) {
        for (Stats stats : Stats.values()) {
            StatsChangesController statsChangesController = new StatsChangesController(stats, pet);
            statsChangesController.setViewBuilder(viewBuilder);
            statsChangesController.changeStatsInTime();
        }
    }
}
