package ect;

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
import models.Product;
import models.seeds.Seed;

import java.io.IOException;

public class Inventory {
    @FXML
    private TableView<Product> table;

    @FXML
    private TextField textField;

    @FXML
    private Button sellButton;

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
    private TableView<Product> table2;
    @FXML
    private TableColumn<Product, String> colName2;
    @FXML
    private TableColumn<Product, Integer> colQuantity2;

    public void showModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/inventary.fxml"));
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

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            textField.setText(String.valueOf(newValue.getQuantity()));
            sellButton.setOnAction(event -> {
                int quantity = 0;
                try{
                   quantity = Integer.parseInt(textField.getText());
                }catch (Exception e){
                    System.out.println("Erreur lors de la saisie");
                }

                if(quantity > newValue.getQuantity()) {
                    quantity = newValue.getQuantity();
                }
                Player.getInstance().setMoney(Player.getInstance().getMoney() + ((long) quantity * newValue.getPrice()));
                System.out.println((long) quantity * newValue.getPrice());
                newValue.removeQuantity(quantity);
                Menu.getInstance().refreshMoney();
                table.refresh();
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

    private void initSeedInventory() {
        colName1.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity1.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        ObservableList<Seed> datas = FXCollections.observableArrayList();

        if (Player.getInstance().getProducts() != null) {
            datas.addAll(Player.getInstance().getSeeds());
        }

        table1.setItems(datas);
    }
}
