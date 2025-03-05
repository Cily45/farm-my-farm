package ect;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Product;
import models.seeds.Seed;
import models.vegetable.Carrot;
import models.vegetable.Vegetable;

import java.io.IOException;

public class SeedInventory {
    @FXML
    private TableView<Seed> table;

    @FXML
    private TextField textField;

    @FXML
    private Button plantButton;

    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, Integer> colQuantity;

    private int x;
    private int y;

    public void showModal(int x1, int y1) {
        this.x = x1;
        this.y = y1;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/seedInventary.fxml"));
            Parent root = loader.load();

            SeedInventory controller = loader.getController();
            controller.x = x1;
            controller.y = y1;

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
        colName.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        initProductInventory();
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            plantButton.setOnAction(event -> {
                plantSeed(newValue.getType());
            });

        });

    }

    public void plantSeed(String type) {
        switch (type) {
            case "Carotte":
                Vegetable carrot = new Carrot(Player.getInstance().getLand(), x, y);
                Player.getInstance().getLand().getGridPane().add(carrot.getButton(), carrot.getX(), carrot.getY());
                Player.getInstance().getLand().addCereal(carrot);
        }
    }

    private void initProductInventory() {
        ObservableList<Seed> datas = FXCollections.observableArrayList();

        if (Player.getInstance().getProducts() != null) {
            datas.addAll(Player.getInstance().getSeeds());
        }

        table.setItems(datas);
    }
}
