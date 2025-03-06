package ect;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import save.SaveFarm;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class Menu {
    @FXML
    private AnchorPane menuAnchorPane;

    @FXML
    private Button inventoryProductButton;

    @FXML
    private Button inventorySeedButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button marketButton;

    @FXML
    private Label money;

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
        inventoryProductButton.setOnAction(event -> {
            new Inventory().showModal();
        });

        saveButton.setOnAction(event -> {
            SaveFarm.saveFarm();
        });

        marketButton.setOnAction(event -> {
            new MarketPlace().showModal();
        });


    }

    public AnchorPane getAnchorPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/menu.fxml"));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Button getInventoryProductButton() {
        return inventoryProductButton;
    }

    public void refreshMoney() {
        money.setText(String.format("%d FD", Player.getInstance().getMoney()));
    }
}
