package controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Product;

import java.io.IOException;

public class FeedInventary   {
    @FXML
    private Button feedButton;

    @FXML
    private TableColumn<Product, Integer> colQuantity;
    private int x;
    private int y;

    public void showModal(int x1, int y1) {
        this.x = x1;
        this.y = y1;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/feedInventary.fxml"));
            Parent root = loader.load();

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Inventaire");
            modalStage.setScene(new Scene(root));

            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {

    }
}
