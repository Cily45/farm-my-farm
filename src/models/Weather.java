package models;

import javafx.scene.image.Image;

public class Weather {
    private int ratio;
    private Image image;

     public Weather(int ratio, Image image) {
         this.ratio = ratio;
         this.image = image;
     }

    public Image getImage() {
        return image;
    }
}
