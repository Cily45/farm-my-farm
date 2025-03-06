package models;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;


public class Organism {
    private int timeToUp = 2;
    private int x, y, actualStade;
    private String[] stades = new String[3];
    private Button button;
    private Land land;
    private static Product product;
    private long elapsedTime = 0;
    private String type;
    private String name;

    public Organism(Land land, int x, int y,int timeToUp, String[] stades, Product product, String type, String name) {
        this.land = land;
        this.x = x;
        this.y = y;
        this.timeToUp = timeToUp;
        this.stades = stades;
        this.product = product;
        this.type = type;
        this.name = name;
        this.actualStade = 0;
        this.button = new Button(stades[actualStade]);
        initButton();
        initTimeline();
    }

    public Organism(Land land, int actualStade, int elapsedTime, int x, int y) {
        this.land = land;
        this.x = x;
        this.y = y;
        this.actualStade = actualStade;
        this.elapsedTime = elapsedTime;
        this.button = new Button(stades[actualStade]);
        initButton();
        initTimeline();
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public void growUp() {
        elapsedTime++;
        if ((elapsedTime == timeToUp ||elapsedTime == timeToUp* 2L) && actualStade < 2) {
            actualStade++;
            button.setText(stades[actualStade]);
        }

        if(actualStade == 2){
            button.setOnAction(e -> {
                getharvest();
            });
        }
    }

    public Button getButton() {
        return button;
    }

    private void initTimeline() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUp()));
        timeline.setCycleCount(2*timeToUp);
        timeline.play();

    }

    private void initButton(){
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setPrefHeight(land.getSize());
        button.setPrefWidth(land.getSize());
    }

    private void getharvest(){
        product.addQuantity();
        land.removeOrganism(this);
        land.getGridPane().getChildren().remove(button);
    }

    public static Product getProduct() {

        return product;
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

    public static void setProduct(Product product) {
        Organism.product = product;
    }

    public int getTimeToUp() {
        return timeToUp;
    }

    public void setTimeToUp(int timeToUp) {
        this.timeToUp = timeToUp;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setActualStade(int actualStade) {
        this.actualStade = actualStade;
    }

    public String[] getStades() {
        return stades;
    }

    public void setStades(String[] stades) {
        this.stades = stades;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public void setType(String type) {
        this.type = type;
    }
}
