package models.vegetable;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import models.Land;
import models.Player;
import models.Product;

public class Carrot extends Vegetable {
    private int timeToUp = 2;
    private int x, y, size, actualStade, price;
    private String[] stades = new String[] {".","c","C"};
    private Button carrotButton;
    private Land land;
    private static Product product = new Product("Carotte", 100);

    public Carrot(Land land, int x, int y, int size) {
        this.land = land;
        this.x = x;
        this.y = y;
        this.size = size;
        this.actualStade = 0;
        this.price = 0;
        this.carrotButton = new Button(stades[actualStade]);
        initButton();
        initTimeline();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void growUp() {
        actualStade++;
        carrotButton.setText(stades[actualStade]);
        if(actualStade == 2){
            carrotButton.setOnAction(e -> {
                getharvest();
            });
        }
    }

    @Override
    public Button getButton() {
        return carrotButton;
    }

    private void initTimeline(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(timeToUp), e -> growUp()));
        timeline.setCycleCount(2);
        timeline.play();
    }

    private void initButton(){
        carrotButton.setLayoutX(x);
        carrotButton.setLayoutY(y);
        carrotButton.setPrefHeight(size);
        carrotButton.setPrefWidth(size);
    }

    private void getharvest(){
        Player.addProduct(product);
        land.removeCereal(this);
        land.getGridPane().getChildren().remove(carrotButton);
    }
}
