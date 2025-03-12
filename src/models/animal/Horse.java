package models.animal;

import javafx.scene.control.Button;
import models.Land;

public class Horse extends Animal {
    public Horse(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public Horse(Land land, int actualStade, int elapsedTime, int x, int y, boolean isFeed, boolean isGetProduction) {
        super(land, actualStade, elapsedTime, x, y, isFeed, isGetProduction);
        init();
        initButton();
        initTimeline();
    }

    private void init() {
        this.timeToUp = 60;
        this.stades = new String[]{"asset/cheval-0.png", "asset/cheval-1.png", "asset/cheval-2.png"};
        this.type = "animal";
        this.name = "Cheval";
        this.production = "Fumier";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.maxProduction = 3;
        this.food = "Myrtille";
        this.foodNeedImagePath = "asset/blueberry-product.png";
        this.productImagePath = "asset/cheval-fumier.png";
    }
}
