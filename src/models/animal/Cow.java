package models.animal;

import javafx.scene.control.Button;
import models.Land;

public class Cow extends Animal {
    public Cow(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public Cow(Land land, int actualStade, int elapsedTime, int x, int y, boolean isFeed, boolean isGetProduction) {
        super(land, actualStade, elapsedTime, x, y, isFeed, isGetProduction);
        init();
        initButton();

        if (isFeed) {
            initTimeline();
        }

    }

    private void init() {
        this.timeToUp = 90;
        this.stades = new String[]{"asset/vache-0.png", "asset/vache-1.png", "asset/vache-2.png"};
        this.type = "animal";
        this.name = "Vache";
        this.production = "Lait";
        this.button = new Button(stades[actualStade]);
        this.etape = 2;
        this.maxProduction = 2;
        this.food = "Maïs";
        this.productImagePath = "asset/vache-milk.png";
        this.foodNeedImagePath = "asset/maize-product.png";
    }
}
