package models.vegetable;

import com.sun.tools.javac.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import models.Land;
import models.Product;

public class Carrot extends Vegetable {
    private int timeToUp = 2;
    private int x, y, actualStade;
    private String[] stades = new String[] {".","c","C"};
    private Button carrotButton;
    private Land land;
    private static Product product = new Product("Carotte", 100);
    private long elapsedTime = 0;
    private String type = "carrot";

    public Carrot(Land land, int x, int y) {
        this.land = land;
        this.x = x;
        this.y = y;
        this.actualStade = 0;
        this.carrotButton = new Button(stades[actualStade]);
        initButton();
        initTimeline();
    }

    public Carrot(Land land, int actualStade, int elapsedTime, int x, int y) {
        this.land = land;
        this.x = x;
        this.y = y;
        this.actualStade = actualStade;
        this.elapsedTime = elapsedTime;
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
        elapsedTime++;
        if ((elapsedTime == timeToUp ||elapsedTime == timeToUp* 2L) && actualStade < 2) {
            actualStade++;
            carrotButton.setText(stades[actualStade]);
        }

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

    private void initTimeline() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUp()));
        timeline.setCycleCount(2*timeToUp);
        timeline.play();

    }

    private void initButton(){
        carrotButton.setLayoutX(x);
        carrotButton.setLayoutY(y);
        carrotButton.setPrefHeight(land.getSize());
        carrotButton.setPrefWidth(land.getSize());
    }

    private void getharvest(){
        product.addQuantity();
        land.removeCereal(this);
        land.getGridPane().getChildren().remove(carrotButton);
    }

    public static Product getProduct() {
        return product;
    }

    @Override
    public Long getElapsedTime() {
        return elapsedTime;
    }

    @Override
    public int getActualStade() {
        return actualStade;
    }

    @Override
    public String getType() {
        return type;
    }

    public static void setProduct(Product product) {
        Carrot.product = product;
    }
}
