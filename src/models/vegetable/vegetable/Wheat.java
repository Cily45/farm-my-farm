package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;
import models.Organism;

public class Wheat extends Organism {
    public Wheat(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public Wheat(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        init();
        initButton();
        initTimeline();
    }

    private void init() {
        this.timeToUp = 10;
        this.stades = new String[]{"asset/wheat-0.png", "asset/wheat-1.png", "asset/wheat-2.png", "asset/wheat-3.png", "asset/wheat-4.png"};
        this.type = "vegetable";
        this.name = "Blé";
        this.button = new Button(stades[actualStade]);
        this.etape = 4;
        this.maxProduction = 5;
    }
}
