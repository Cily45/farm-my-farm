package models.vegetable.vegetable;

import models.Land;
import models.Organism;
import models.Product;

public class Corn extends Organism {
    public Corn(Land land, int x, int y, int timeToUp, String[] stades, Product product, String type, String name) {
        super(land, x, y, timeToUp, stades, product, type, name);
    }

    public Corn(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
    }
}
