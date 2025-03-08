package models;

import controllers.Inventory;
import controllers.MarketPlace;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import utils.save.SaveFarm;

import java.io.IOException;

public class Menu {
    @FXML
    private AnchorPane menuAnchorPane;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button inventorySeedButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button marketButton;

    @FXML
    private Label money;

    @FXML
    private ImageView weatherImageView;

    @FXML
    private Label infoLabel;

    private static Menu instance;

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    @FXML
    private void initialize() {
        refreshMoney();
        inventoryButton.setOnAction(event -> {
            new Inventory().showModal();
        });

        saveButton.setOnAction(event -> {
            setLabel(SaveFarm.saveFarm());
        });

        marketButton.setOnAction(event -> {
            new MarketPlace().showModal();
        });

        weather();
    }

    public AnchorPane getAnchorPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/menu.fxml"));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void changeWeatherImage(Image weatherImage) {
        weatherImageView.setImage(weatherImage);
    }


    private void weather() {
        Player.getInstance().getLand().changeWeather();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(60), e -> Player.getInstance().getLand().changeWeather()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public Button getInventoryButton() {
        return inventoryButton;
    }

    public void refreshMoney() {
        money.setText(String.format("%d FD", Player.getInstance().getMoney()));
    }

    public void setLabel(String content){
        infoLabel.setText(content);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> infoLabel.setText("")));
        timeline.setCycleCount(1);
        timeline.play();
    }
}
