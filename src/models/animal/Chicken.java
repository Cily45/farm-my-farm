package models.animal;

import javafx.scene.control.Button;
import models.Land;

public class Chicken extends Animal {
    public Chicken(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public Chicken(Land land, int actualStade, int elapsedTime, int x, int y, boolean isFeed, boolean isGetProduction) {
        super(land, actualStade, elapsedTime, x, y, isFeed, isGetProduction);
        init();
        initButton();

        if (isFeed) {
            initTimeline();
        }

    }

    private void init() {
        this.timeToUp = 30;
        this.stades = new String[]{"asset/poule-0.png", "asset/poule-1.png", "asset/poule-2.png"};
        this.type = "animal";
        this.name = "Poule";
        this.production = "Oeuf";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.maxProduction = 2;
        this.food = "Blé";
        this.productImagePath = "asset/poule-oeuf.png";
        this.foodNeedImagePath = "asset/wheat-product.png";
    }
}
