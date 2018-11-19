package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tamagotchi.model.Activity;
import tamagotchi.model.Executive;


public class ActivityButton extends ImageView implements Executive {

    private Activity activity;

    public ActivityButton(Activity activity){

        super(new Image(activity.getImageUrl()));
        this.activity = activity;
        this.setOnMouseClicked(lambda -> {
            this.execute();
        });
    }



    @Override
    public void execute() {
        System.out.println(activity.toString());
//
//        for (Map.Entry<Stats, Integer> singleResult : activity.getActivityResult().entrySet()){
//            singleResult.
//        }


    }
}
