package ect;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import save.SaveFarm;

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
            new ProductInventory().showModal();
        });

//        inventorySeedButton.setOnAction(event -> {
//            new SeedInventory().showModal();
//        });

        saveButton.setOnAction(event -> {
            SaveFarm.saveFarm();
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
