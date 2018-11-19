package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import tamagotchi.model.Activity;

public class ViewBuilder {

    private Pane root;

    public ViewBuilder(Pane root) {
        this.root = root;
        setBackground();
        setButtons();
        setStatsViews();
    }


    private void setBackground() {

        Image background = new Image("background.png");
        ImageView sceneBackground = new ImageView(background);
        root.getChildren().add(sceneBackground);
    }

    private void setButtons(){

        final double HORIZONTAL_POSITION = 200;
        final double VERTICAL_POSITION = 465;

        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

        for (Activity activity : Activity.values()){
            ActivityButton activityButton = createActivityButton(activity);
            addToPane(activityButton);
            setButtonPosition(HORIZONTAL_POSITION, VERTICAL_POSITION, DISTANCE_BETWEEN_BUTTONS, count, activityButton);
            count++;
        }
    }

    private ActivityButton createActivityButton(Activity activity) {
        return new ActivityButton(activity);
    }

    private void addToPane(ActivityButton activityButton) {
        root.getChildren().add(activityButton);
    }

    private void setButtonPosition(double HORIZONTAL_POSITION, double VERTICAL_POSITION, double DISTANCE_BETWEEN_BUTTONS, int count, ActivityButton activityButton) {
        activityButton.setX(HORIZONTAL_POSITION + count * DISTANCE_BETWEEN_BUTTONS);
        activityButton.setY(VERTICAL_POSITION);
    }

    private void setStatsViews(){

        final double HORIZONTAL_POSITION = 500;
        final double VERTICAL_POSITION = 25;

        final double DISTANCE_BETWEEN_BUTTONS = 100;

        int count = 0;

//        Text actualStat;

        for (StatsView stat : StatsView.values()){
            ImageView statImage = createStatImageView(stat);
            root.getChildren().add(statImage);          // TODO refactor to generic method addToPane(imageView);

            statImage.setX(HORIZONTAL_POSITION + count * DISTANCE_BETWEEN_BUTTONS); // TODO refactor to generic method setPositionOnPane(imageView);
            statImage.setY(VERTICAL_POSITION);

//            actualStat = new Text (pet.getActualStat())

            count++;

        }
    }


    private ImageView createStatImageView(StatsView stat) {
        return new ImageView(new Image(stat.getImageUrl()));
    }


}
