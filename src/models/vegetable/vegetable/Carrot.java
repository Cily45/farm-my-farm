package models.vegetable.vegetable;

import javafx.scene.control.Button;
import models.Land;
import models.Product;
import models.Organism;

public class Carrot extends Organism {
    public Carrot(Land land, int x, int y, int timeToUp, String[] stades, Product product, String type, String name) {
        super(land, x, y, timeToUp, stades, product, type, name);
    }

    public Carrot(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
    }
}
