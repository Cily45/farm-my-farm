package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Menu;
import models.Player;
import models.Product;
import models.animal.BabyAnimal;
import models.vegetable.vegetable.Seed;

import java.io.IOException;

public class Inventory {
    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, Integer> colQuantity;
    @FXML
    private TableView<Seed> table1;
    @FXML
    private TableColumn<Seed, String> colName1;
    @FXML
    private TableColumn<Seed, Integer> colQuantity1;
    @FXML
    private TableView<BabyAnimal> table2;
    @FXML
    private TableColumn<BabyAnimal, String> colName2;
    @FXML
    private TableColumn<BabyAnimal, Integer> colQuantity2;

    public void showModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/inventary.fxml"));
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
        initProductInventory();
        initSeedInventory();
        initBabyAnimalInventory();
    }

    private void initProductInventory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        ObservableList<Product> datas = FXCollections.observableArrayList();

        if (Player.getInstance().getProducts() != null) {
            datas.addAll(Player.getInstance().getProducts());
        }

        table.setItems(datas);
    }

    private void initSeedInventory() {
        colName1.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity1.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        ObservableList<Seed> datas = FXCollections.observableArrayList();

        if (Player.getInstance().getProducts() != null) {
            datas.addAll(Player.getInstance().getSeeds());
        }

        table1.setItems(datas);
    }

    private void initBabyAnimalInventory() {
        colName2.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity2.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        ObservableList<BabyAnimal> datas = FXCollections.observableArrayList();

        if (Player.getInstance().getProducts() != null) {
            datas.addAll(Player.getInstance().getBabyAnimals());
        }

        table2.setItems(datas);
    }
}
