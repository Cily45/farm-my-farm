package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;
import models.Organism;


public class SunFlower extends Organism {
    public SunFlower(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public SunFlower(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        init();
        initButton();
        initTimeline();
    }

    private void init() {
        this.timeToUp = 15;
        this.stades = new String[]{"asset/sunflower-0.png", "asset/sunflower-1.png", "asset/sunflower-2.png", "asset/sunflower-3.png", "asset/sunflower-4.png"};
        this.type = "vegetable";
        this.name = "Tournesol";
        this.button = new Button(stades[actualStade]);
        this.etape = 4;
        this.maxProduction = 3;
    }
}
