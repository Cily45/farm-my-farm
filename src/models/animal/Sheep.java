package models.animal;

import javafx.scene.control.Button;
import models.Land;

public class Sheep extends Animal {
    public Sheep(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public Sheep(Land land, int actualStade, int elapsedTime, int x, int y, boolean isFeed, boolean isGetProduction) {
        super(land, actualStade, elapsedTime, x, y, isFeed, isGetProduction);
        init();
        initButton();

        if (isFeed) {
            initTimeline();
        }

    }

    private void init() {
        this.timeToUp = 45;
        this.stades = new String[]{"asset/mouton-0.png", "asset/mouton-1.png", "asset/mouton-2.png"};
        this.elapsedTime = 0;
        this.type = "animal";
        this.name = "Mouton";
        this.production = "Laine";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.maxProduction = 3;
        this.food = "Tournesol";
        this.foodNeedImagePath = "asset/sunflower-product.png";
        this.productImagePath = "asset/mouton-laine.png";
    }
}