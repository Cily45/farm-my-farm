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

import java.io.IOException;

public class ProductInventory {
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

    public void showModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/productInventary.fxml"));
            Parent root = loader.load();

            ProductInventory controller = loader.getController();

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Inventaire");
            modalStage.setScene(new Scene(root));

            modalStage.showAndWait(); // On attend la fermeture de la fenêtre
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        initProductInventory();

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
                Player.getInstance().setMoney((long) quantity * newValue.getPrice());
                System.out.println((long) quantity * newValue.getPrice());
                newValue.removeQuantity(quantity);
                Menu.getInstance().refreshMoney();
                table.refresh();
            });
        });

        }

    private void initProductInventory() {
        ObservableList<Product> datas = FXCollections.observableArrayList();

        if (Player.getInstance().getProducts() != null) {
            datas.addAll(Player.getInstance().getProducts());
        }

        table.setItems(datas);
    }
}
