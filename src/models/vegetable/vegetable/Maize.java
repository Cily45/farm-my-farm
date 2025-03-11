package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;

import models.Organism;

public class Maize extends Organism {
    public Maize(Land land, int x, int y) {
        super(land, x, y);
        this.timeToUp = 40;
        this.stades = new String[]{"asset/maize-0.png", "asset/maize-1.png", "asset/maize-2.png", "asset/maize-3.png", "asset/maize-4.png", "asset/maize-5.png", "asset/maize-6.png"};
        this.elapsedTime = 0;
        this.type = "vegetable";
        this.name = "Maïs";
        this.etape = 6;
        this.range = 15 - 1;
        this.minProduction = 1;
        initButton();
        initTimeline();
    }

    public Maize(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        this.timeToUp = 40;
        this.stades = new String[]{"asset/maize-0.png", "asset/maize-1.png", "asset/maize-2.png", "asset/maize-3.png", "asset/maize-4.png", "asset/maize-5.png", "asset/maize-6.png"};
        this.type = "vegetable";
        this.name = "Maïs";
        this.button = new Button(stades[actualStade]);
        this.etape = 6;
        this.range = 15 - 1 + 1;
        this.minProduction = 1;
        initButton();
        initTimeline();
    }
}
