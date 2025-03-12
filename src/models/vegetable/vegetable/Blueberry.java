package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;
import models.Organism;

public class Blueberry extends Organism {
    public Blueberry(Land land, int x, int y) {
        super(land, x, y);
        init();
        initButton();
        initTimeline();
    }

    public Blueberry(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        init();
        initButton();
        initTimeline();
    }

    private void init(){
        this.timeToUp = 20;
        this.stades = new String[]{"asset/blueberry-0.png", "asset/blueberry-1.png", "asset/blueberry-2.png", "asset/blueberry-3.png", "asset/blueberry-4.png", "asset/blueberry-5.png"};
        this.type = "vegetable";
        this.name = "Myrtille";
        this.etape = 5;
        this.button = new Button(stades[actualStade]);
        this.maxProduction = 4;
    }
}
