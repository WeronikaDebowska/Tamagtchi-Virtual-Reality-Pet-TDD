package tamagotchi.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
        pet.setViewBuilder(viewBuilder);
        for (Stats stats : Stats.values()) {
            StatsChangesController statsChangesController = new StatsChangesController(stats, pet);
            statsChangesController.setViewBuilder(viewBuilder);
            statsChangesController.updateStats();
        }
        Scene scene = new Scene(root, WIDTH, HEIGHT);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Tamagotchi");
        primaryStage.show();


    }
}
