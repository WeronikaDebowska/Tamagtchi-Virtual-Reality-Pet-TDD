package tamagotchi.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import tamagotchi.model.Pet;
import tamagotchi.model.Stats;

import java.util.*;
import java.util.stream.Collectors;

public class StatsView extends ImageView {

    final private int WINDOW_WIDTH;
    final private int WINDOW_HEIGHT;
    private List<ImageView> statsViewList;
    private List<Text> statTextList = new ArrayList<>();
    private Pet pet;

    public StatsView(Pet pet, int windowWidth, int windowHeight) {

        this.pet = pet;
        this.WINDOW_WIDTH = windowWidth;
        this.WINDOW_HEIGHT = windowHeight;
        createStatsImages();
        createStatsTexts();

    }

    private void createStatsImages() {
        statsViewList = Arrays
                .stream(Stats.values())
                .map(this::createStatImage)
                .collect(Collectors.toList());

    }


    private ImageView createStatImage(Stats stat) {
        ImageView statView = new ImageView(new Image(stat.getStatImgUrl()));

        final double HORIZONTAL_POSITION = 0.55 * WINDOW_WIDTH;
        final double VERTICAL_POSITION = 0.05 * WINDOW_HEIGHT;
        final double DISTANCE_BETWEEN_BUTTONS = 0.12 * WINDOW_WIDTH;

        statView.setX(HORIZONTAL_POSITION + stat.ordinal() * DISTANCE_BETWEEN_BUTTONS);
        statView.setY(VERTICAL_POSITION);

        return statView;
    }

    private void createStatsTexts() {
        Arrays.stream(Stats.values())
                .peek(stat -> addToList(createStatText(stat)))
                .collect(Collectors.toList());

    }

    private Text createStatText(Stats stat) {

        Text statText = new Text(Integer.toString(pet.getActualStat(stat)));

        final double TEXT_VERTICAL_POSITION = 0.17 * WINDOW_HEIGHT;
        final double TEXT_HORIZONTAL_POSITION = 0.595 * WINDOW_WIDTH;
        final double DISTANCE_BETWEEN_BUTTONS = 0.12 * WINDOW_WIDTH;

        statText.setY(TEXT_VERTICAL_POSITION);
        statText.setX(TEXT_HORIZONTAL_POSITION + stat.ordinal() * DISTANCE_BETWEEN_BUTTONS);

        return statText;
    }

    private void addToList(Text text) {
        statTextList.add(text);
    }

    public void updateStatText() {
        Arrays.stream(Stats.values())
                .peek(this::updateStatText)
                .collect(Collectors.toList());
        ;

    }

    private void updateStatText(Stats stat) {
        statTextList.get(stat.ordinal()).setText(Integer.toString(pet.getActualStat(stat)));
    }

    public List<ImageView> getStatsViewList() {
        return statsViewList;
    }

    public List<Text> getStatTexts() {
        return statTextList;
    }
}
