package models.animal;

import javafx.scene.control.Button;
import models.Land;

public class Cow extends Animal {
    public Cow(Land land, int x, int y) {
        super(land, x, y);
        this.timeToUp = 2;
        this.stades = new String[]{"asset/vache-0.png", "asset/vache-1.png", "asset/vache-2.png"};
        this.elapsedTime = 0;
        this.type = "animal";
        this.name = "Vache";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.range = 20 - 1 + 1;
        this.minProduction = 1;
        this.food = "Maïs";
        this.foodNeedImagePath = "asset/faim.png";
        initButton();
        initTimeline();
    }

    public Cow(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        this.timeToUp = 60;
        this.stades = new String[]{"asset/vache-0.png", "asset/vache-1.png", "asset/vache-2.png"};
        this.type = "animal";
        this.name = "Vache";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.range = 20 - 1 + 1;
        this.minProduction = 1;
        initButton();
        initTimeline();
    }
}
