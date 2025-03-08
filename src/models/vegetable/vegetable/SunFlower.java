package models.vegetable.vegetable;

import models.Land;
import javafx.scene.control.Button;
import models.Organism;


public class SunFlower extends Organism {
        public SunFlower(Land land, int x, int y) {
            super(land, x, y);
            this.timeToUp = 20;
            this.stades = new String[]{"asset/tournesol-0.png", "asset/tournesol-1.png", "asset/tournesol-2.png","asset/tournesol-3.png","asset/tournesol-4.png"};
            this.elapsedTime = 0;
            this.type = "vegetable";
            this.name= "Tournesol";
            this.etape = 4;
            this.range = 5-1;
            this.minProduction = 1;
            initButton();
            initTimeline();
        }

        public SunFlower(Land land, int actualStade, int elapsedTime, int x, int y) {
            super(land, actualStade, elapsedTime, x, y);
            this.timeToUp = 20;
            this.stades = new String[]{"asset/tournesol-0.png", "asset/tournesol-1.png", "asset/tournesol-2.png","asset/tournesol-3.png","asset/tournesol-4.png"};
            this.type = "vegetble";
            this.name= "Tournesol";
            this.button = new Button(stades[actualStade]);
            this.etape = 4;
            this.range = 5-1+1;
            this.minProduction = 1;
            initButton();
            initTimeline();
        }
}
