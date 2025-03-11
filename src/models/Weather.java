package models;

import javafx.scene.image.Image;

public class Weather {
    private double ratio;
    private Image image;

    public Weather(double ratio, Image image) {
        this.ratio = ratio;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public double getRatio() {
        return ratio;
    }
}
