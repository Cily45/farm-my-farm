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
import models.animal.BabyAnimal;
import models.vegetable.vegetable.Seed;

import java.io.IOException;

public class FeedInventary {
    @FXML
    private TableView<Product> table;

    @FXML
    private Button feedButton;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/feedInventary.fxml"));
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

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            feedButton.setOnAction(event -> {
                if (0 < newValue.getQuantity()) {
                    newValue.removeQuantity(1);
                    Menu.getInstance().refreshMoney();
                    table.refresh();}

            });
        });

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
}
