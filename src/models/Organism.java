package models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public abstract class Organism {
    protected int timeToUp = 2;
    protected int x, y, actualStade, range, minProduction;
    protected String[] stades = new String[3];
    protected Button button;
    protected Land land;
    protected long elapsedTime = 0;
    protected String type;
    protected String name;
    protected int etape;


    public Organism(Land land, int x, int y) {
        this.land = land;
        this.x = x;
        this.y = y;
        this.actualStade = 0;
        this.button = new Button();
    }

    public Organism(Land land, int actualStade, int elapsedTime, int x, int y) {
        this.land = land;
        this.x = x;
        this.y = y;
        this.actualStade = actualStade;
        this.elapsedTime = elapsedTime;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void growUp() {
        elapsedTime++;

        if (elapsedTime == timeToUp && actualStade < etape) {
            actualStade++;
            Image image = new Image(stades[actualStade]);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(100);
            imageView.setFitWidth(100);
            this.button.setGraphic(imageView);
            elapsedTime = 0;
        }

        if (actualStade == etape) {
            button.setOnAction(e -> {
                getProduction();
            });
        }
    }

    public Button getButton() {
        return button;
    }

    protected void initTimeline() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUp()));
        timeline.setCycleCount(etape * timeToUp);
        timeline.play();
    }

    protected void initButton() {
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefHeight(land.getSize());
        button.setPrefWidth(land.getSize());

        Image image = new Image(stades[0]);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        this.button.setGraphic(imageView);
        this.button.setStyle("-fx-background-color: #550808");
    }

    protected void getProduction() {
        Player.getInstance().getProduct(name).addQuantity((int) (Math.random() * range) + 1);
        land.removeOrganism(this);
        land.getGridPane().getChildren().remove(button);
    }

    public Long getElapsedTime() {
        return elapsedTime;
    }

    public int getActualStade() {
        return actualStade;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
