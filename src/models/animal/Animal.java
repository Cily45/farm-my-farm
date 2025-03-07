package models.animal;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import models.Land;
import models.Organism;

public class Animal extends Organism {
    protected long elapsedTime = 0;
    protected boolean isFeed = false;
    protected int timeToDie = 120;
    protected int elapsedTimeFeed = 0;
    protected int timeToFeed = 60;
    protected ImageView faim = new ImageView(new Image("asset/faim.png"));
    protected String food;


    public Animal(Land land, int x, int y) {
        super(land, x, y);
        initFeedTime();
    }

    public Animal(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
    }

    public void initFeedTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUpAnimal()));
        timeline.setCycleCount(2*timeToUp);
        timeline.play();
    }

    private void growUpAnimal() {
        if(isFeed){
            if (elapsedTime == timeToUp && actualStade < etape) {
                actualStade++;
                ImageView imageView = new ImageView(new Image(stades[actualStade]));
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
        elapsedTime++;
    }

    private void feedAnimation(){
        if(elapsedTime%2 == 0){
            button.setGraphic(faim);
        }else{
            button.setGraphic(new ImageView(new Image(stades[actualStade])));
        }
    }
}
