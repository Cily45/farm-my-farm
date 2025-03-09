package models.animal;

import javafx.scene.control.Button;
import models.Land;

public class Horse extends Animal {
    public Horse(Land land, int x, int y) {
        super(land, x, y);
        this.timeToUp = 50;
        this.stades = new String[]{"asset/cheval-0.png", "asset/cheval-1.png", "asset/cheval-2.png"};
        this.elapsedTime = 0;
        this.type = "animal";
        this.name = "Cheval";
        this.production = "Fumier";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.range = 10;
        this.minProduction = 1;
        this.food = "Myrtille";
        this.foodNeedImagePath = "asset/faim.png";
        initButton();
    }

    public Horse(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        this.timeToUp = 50;
        this.stades = new String[]{"asset/cheval-0.png", "asset/cheval-1.png", "asset/cheval-2.png"};
        this.elapsedTime = 0;
        this.type = "animal";
        this.name = "Cheval";
        this.production = "Fumier";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.range = 10;
        this.minProduction = 1;
        this.food = "Myrtille";
        this.foodNeedImagePath = "asset/faim.png";
        this.actualStade = actualStade;
        this.elapsedTime = elapsedTime;
        initButton();
    }
}
