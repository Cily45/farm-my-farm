package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;

import models.Organism;

public class Maize extends Organism {
    public Maize(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public Maize(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        init();
        initButton();
        initTimeline();
    }

    private void init() {
        this.timeToUp = 30;
        this.stades = new String[]{"asset/maize-0.png", "asset/maize-1.png", "asset/maize-2.png", "asset/maize-3.png", "asset/maize-4.png", "asset/maize-5.png", "asset/maize-6.png"};
        this.type = "vegetable";
        this.name = "Maïs";
        this.button = new Button(stades[actualStade]);
        this.etape = 6;
        this.maxProduction = 3;
    }
}
