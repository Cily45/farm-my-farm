package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;
import models.Organism;
import models.Product;

public class Blueberry extends Organism {
        public Blueberry(Land land, int x, int y) {
            super(land, x, y);
            this.timeToUp = 30;
            this.stades = new String[]{"asset/myrtille-0.png", "asset/myrtille-1.png", "asset/myrtille-2.png","asset/myrtille-3.png","asset/myrtille-4.png","asset/myrtille-5.png"};
            this.elapsedTime = 0;
            this.type = "vegetable";
            this.name= "Myrtille";
            this.etape = 5;
            this.range = 15-1;
            this.minProduction = 1;
            initButton();
            initTimeline();
        }

        public Blueberry(Land land, int actualStade, int elapsedTime, int x, int y) {
            super(land, actualStade, elapsedTime, x, y);
            this.timeToUp = 30;
            this.stades = new String[]{"asset/myrtille-0.png", "asset/myrtille-1.png", "asset/myrtille-2.png","asset/myrtille-3.png","asset/myrtille-4.png","asset/myrtille-5.png"};
            this.type = "vegetable";
            this.name= "Myrtille";
            this.etape = 5;
            this.button = new Button(stades[actualStade]);
            this.range = 15-1+1;
            this.minProduction = 1;
            initButton();
            initTimeline();
        }
}
