package tamagotchi.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tamagotchi.model.*;
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
        ViewBuilder viewBuilder = new ViewBuilder(root, pet, WIDTH, HEIGHT);
        pet.setViewBuilder(viewBuilder);

        new StatsChangesController(pet, viewBuilder);

        Scene scene = new Scene(root, WIDTH, HEIGHT);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Tamagotchi. Virtual Reality Pet");
        primaryStage.show();

    }

}
