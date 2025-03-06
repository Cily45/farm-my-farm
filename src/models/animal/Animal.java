package models.animal;

import javafx.scene.control.Button;
import models.Land;
import models.Organism;
import models.Product;

public class Animal extends Organism {
    protected boolean isFeed = false;
    protected int timeToDie = 120;
    protected int elapsedTimeFeed = 0;
    protected int timeToFeed = 60;
    private int timeToUp = 2;
    private int x, y, actualStade;
    private String[] stades = new String[3];
    private Button button;
    private Land land;
    private static Product product;
    private long elapsedTime = 0;
    private String type;
    private String name;

    public Animal(Land land, int x, int y, int timeToUp, String[] stades, Product product, String type, String name) {
        super(land, x, y, timeToUp, stades, product, type, name);
    }

//    @Override
//    public void growUp() {
//        elapsedTime++;
//        if ((elapsedTime == timeToUp ||elapsedTime == timeToUp* 2L) && actualStade < 2 && isFeed) {
//            actualStade++;
//            button.setText(stades[actualStade]);
//        }
//
//        if(actualStade == 2){
//            button.setOnAction(e -> {
//
//            });
//        }
//    }
//
//    public void animalDead(){
//        land.removeOrganism(this);
//        land.getGridPane().getChildren().remove(button);
//    }
//
//    public void initFeedTime(){
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUp()));
//        timeline.setCycleCount(2*timeToUp);
//        timeline.play();
//    }
//
//    public void initDeathTime(){
//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUp()));
//        timeline.setCycleCount(timeToDie);
//        timeline.play();
//    }
//
//    public void death(){}
}
