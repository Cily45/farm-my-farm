package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;
import models.Organism;
import models.Product;


public class Wheat extends Organism {

    public Wheat(Land land, int x, int y) {
        super(land, x, y);
        this.timeToUp = 10;
        this.stades = new String[]{"asset/ble-0.png", "asset/ble-1.png", "asset/ble-2.png","asset/ble-3.png","asset/ble-4.png"};
        this.elapsedTime = 0;
        this.type = "vegetable";
        this.name= "Blé";
        this.etape = 4;
        this.range = 10-1;
        this.minProduction = 1;
        initButton();
        initTimeline();
    }

    public Wheat(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
        this.timeToUp = 10;
        this.stades = new String[]{"asset/ble-0.png", "asset/ble-1.png", "asset/ble-2.png","asset/ble-3.png","asset/ble-4.png"};
        this.type = "vegetble";
        this.name= "Blé";
        this.button = new Button(stades[actualStade]);
        this.etape = 4;
        this.range = 10-1+1;
        this.minProduction = 1;
        initButton();
        initTimeline();
    }


}
