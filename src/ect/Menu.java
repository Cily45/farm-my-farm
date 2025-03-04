package ect;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    @FXML
    private AnchorPane menuAnchorPane;

    @FXML
    private Button inventoryButton;

    private static Menu instance;

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    @FXML
    private void initialize() {
        inventoryButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/productInventary.fxml"));
                Parent root = loader.load();

                Stage modalStage = new Stage();
                modalStage.initModality(Modality.APPLICATION_MODAL);
                modalStage.setTitle("Inventaire");
                modalStage.setScene(new Scene(root));
                modalStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    public Button getInventoryButton() {
        return inventoryButton;
    }
}
