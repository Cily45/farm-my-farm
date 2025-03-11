package models.animal;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import models.*;

public class Animal extends Organism {
    protected long elapsedTime = 0;
    protected boolean isFeed = false;
    protected String food;
    protected String foodNeedImagePath;
    protected String production;
    protected boolean isGetProduction = false;


    public Animal(Land land, int x, int y) {
        super(land, x, y);
    }

    public Animal(Land land, int actualStade, int elapsedTime, int x, int y) {
        super(land, actualStade, elapsedTime, x, y);
    }

    @Override
    protected void growUp() {
        elapsedTime++;
        if (elapsedTime == timeToUp && actualStade < etape) {
            actualStade++;
            changeImageButton(stades[actualStade]);
            elapsedTime = 0;
            isFeed = false;
            changeImageButton(foodNeedImagePath);
        }
        if (elapsedTime == timeToUp && actualStade == etape) {
            changeImageButton("/asset/mouton-0.png");
            isGetProduction = false;
            button.setOnAction(e -> {
                if (!isGetProduction) {
                    getProduction();
                    elapsedTime = 0;
                    isFeed = false;
                    initFeedButton();
                }
            });
        }
    }

    @Override
    protected void initTimeline() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> growUp()));
        timeline.setCycleCount(timeToUp);
        timeline.play();
    }


    protected void feeding() {
        Product product = Player.getInstance().getProducts().stream().filter(p -> p.getName().equals(food)).findFirst().get();

        if (product.getQuantity() > 0) {
            product.removeQuantity(1);
            isFeed = true;
            changeImageButton(stades[actualStade]);
            initTimeline();
        } else {
            Menu.getInstance().setLabel(String.format("Votre inventaire ne comporte pas assez de %s!", food));
        }
    }

    @Override
    protected void getProduction() {
        int quantity = (int) (((Math.random() * range) + 1) * land.getCurrentWeatherRatio());
        Player.getInstance().getProduct(production).addQuantity(Math.max(1, quantity));
        changeImageButton(stades[actualStade]);
        elapsedTime = 0;
        isGetProduction = true;
    }

    protected void initFeedButton() {
        changeImageButton(foodNeedImagePath);

        button.setOnAction(e -> {
            if (!isFeed) {
                feeding();
            }
        });
    }

    @Override
    protected void initButton() {
        super.initButton();
        initFeedButton();
    }
}
