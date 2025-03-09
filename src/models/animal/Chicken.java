package models.animal;

import javafx.scene.control.Button;
import models.Land;

public class Chicken extends Animal {
    public Chicken(Land land, int x, int y) {
        super(land, x, y);
        this.timeToUp = 10;
        this.stades = new String[]{"asset/poule-0.png", "asset/poule-1.png", "asset/poule-2.png"};
        this.elapsedTime = 0;
        this.type = "animal";
        this.name = "Poule";
        this.production = "Oeuf";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.range = 1;
        this.minProduction = 1;
        this.food = "Blé";
        this.foodNeedImagePath = "asset/faim.png";
        initButton();
    }

    public Chicken(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        this.timeToUp = 10;
        this.stades = new String[]{"asset/poule-0.png", "asset/poule-1.png", "asset/poule-2.png"};
        this.elapsedTime = 0;
        this.type = "animal";
        this.name = "Poule";
        this.production = "Oeuf";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.range = 1;
        this.minProduction = 1;
        this.food = "Blé";
        this.foodNeedImagePath = "asset/faim.png";
        this.actualStade = actualStade;
        this.elapsedTime = elapsedTime;
        initButton();
    }
}
