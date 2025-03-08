package models.animal;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import models.*;

public class Animal extends Organism {
    protected long elapsedTime = 0;
    protected boolean isFeed = false;
    protected int elapsedTimeProduceProduct = 0;
    protected int timeProduceProduct = 60;
    protected ImageView faim = new ImageView(new Image("asset/faim.png"));
    protected String food;
    protected String foodNeedImagePath;


    public Animal(Land land, int x, int y) {
        super(land, x, y);
    }

    public Animal(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
    }

    protected void initFeedTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> produceProduct()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    protected void produceProduct() {
        if (isFeed) {
            if (timeProduceProduct == elapsedTime) {
                button.setOnAction(e -> {
                    getProduction();
                    elapsedTimeProduceProduct = 0;
                });
                changeImageButton(foodNeedImagePath);
            } else {
                elapsedTimeProduceProduct++;
            }
        } else {

            button.setOnAction(e -> {
                feeding();
            });
        }
    }

    @Override
    protected void growUp() {
        if (isFeed) {
            if (elapsedTime == timeToUp && actualStade < etape) {
                actualStade++;
                changeImageButton(stades[actualStade]);
                elapsedTime = 0;
                isFeed = false;
                changeImageButton(foodNeedImagePath);

                if (actualStade == etape) {
                    initFeedTime();
                }
            }elapsedTime++;
        } else {
            button.setOnAction(e -> {
                feeding();
            });
            changeImageButton(foodNeedImagePath);
        }
    }

    @Override
    protected void initTimeline() {
        if(isFeed) {
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUp()));
            timeline.setCycleCount(timeToUp);
            timeline.play();
        }
    }

    protected void feeding() {
        Product product = Player.getInstance().getProducts().stream().filter(p -> p.getName().equals(food)).findFirst().get();
        if (product.getQuantity() > 0) {
            product.removeQuantity(1);
            isFeed = true;
            changeImageButton(stades[actualStade]);
        } else {
            Menu.getInstance().setLabel(String.format("Votre inventaire ne comporte pas assez de %s!", food));
        }
    }

    @Override
    protected void getProduction() {
        int quantity = (int) (((Math.random() * range) + 1) * land.getCurrentWeatherRatio());
        Player.getInstance().getProduct(name).addQuantity(Math.max(0, quantity));
        changeImageButton(stades[actualStade]);
        elapsedTime = 0;
    }
}
