package controllers;

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
import models.Menu;
import models.Player;
import models.Product;
import models.animal.BabyAnimal;
import models.vegetable.vegetable.Seed;

import java.io.IOException;

public class MarketPlace {
    @FXML
    private TableView<Seed> table;

    @FXML
    private TableColumn<Seed, String> colName;

    @FXML
    private TableColumn<Seed, Integer> colQuantity;

    @FXML
    private TableColumn<Seed, Integer> colPrice;

    @FXML
    private TextField textField;

    @FXML
    private Button buyButton;

    @FXML
    private TableView<BabyAnimal> table1;

    @FXML
    private TableColumn<BabyAnimal, String> colName1;

    @FXML
    private TableColumn<BabyAnimal, Integer> colQuantity1;

    @FXML
    private TableColumn<BabyAnimal, Integer> colPrice1;

    @FXML
    private TextField textField1;

    @FXML
    private Button buyButton1;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> productCol;

    @FXML
    private TableColumn<Product, Integer> productPossederCol;

    @FXML
    private TableColumn<Product, Integer> productPriceCol;

    @FXML
    private TextField productTextField;

    @FXML
    private Button productButton;


    public void showModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/marketPlace.fxml"));
            Parent root = loader.load();

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Marché");
            modalStage.setScene(new Scene(root));

            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        initSeedInventory();
        initBabyAnimalInventory();
        initProductInventory();

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            buyButton.setOnAction(event -> {
                int quantity = 0;

                try {
                    quantity = Integer.parseInt(textField.getText());
                } catch (Exception e) {
                    System.out.println("Erreur lors de la saisie");
                }

                if ((long) quantity * newValue.getPrice() > Player.getInstance().getMoney()) {
                    quantity = (int) Math.floor((double) Player.getInstance().getMoney() / newValue.getPrice());
                }

                long price = (long) quantity * newValue.getPrice();
                Player.getInstance().setMoney(Player.getInstance().getMoney() - price);
                newValue.setQuantity(quantity);
                Menu.getInstance().refreshMoney();
                Player.getInstance().modifyStats("Achat de graine", quantity);
                Player.getInstance().modifyStats("Dépenses total", price);
                Player.getInstance().modifyStats("Dépenses en graine", price);
                table.refresh();
            });
        });

        table1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            buyButton1.setOnAction(event -> {
                int quantity = 0;

                try {
                    quantity = Integer.parseInt(textField1.getText());
                } catch (Exception e) {
                    System.out.println("Erreur lors de la saisie");
                }

                if ((long) quantity * newValue.getPrice() > Player.getInstance().getMoney()) {
                    quantity = (int) Math.floor((double) Player.getInstance().getMoney() / newValue.getPrice());
                }

                long price = (long) quantity * newValue.getPrice();
                Player.getInstance().setMoney(Player.getInstance().getMoney() - price);
                newValue.setQuantity(quantity);
                Player.getInstance().modifyStats("Achat de bébé animaux", quantity);
                Player.getInstance().modifyStats("Dépenses total", price);
                Player.getInstance().modifyStats("Dépenses en bébé animaux", price);
                Menu.getInstance().refreshMoney();
                table1.refresh();
            });
        });

        productTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            productTextField.setText(String.valueOf(newValue.getQuantity()));
            productButton.setOnAction(event -> {
                int quantity = 0;

                try {
                    quantity = Integer.parseInt(productTextField.getText());
                } catch (Exception e) {
                    System.out.println("Erreur lors de la saisie");
                }

                if (quantity >= newValue.getQuantity()) {
                    quantity = newValue.getQuantity();
                }

                long price = ((long) quantity * newValue.getPrice());
                Player.getInstance().setMoney(Player.getInstance().getMoney() + price);
                newValue.removeQuantity(quantity);
                Player.getInstance().modifyStats("Vente de produit", quantity);
                Player.getInstance().modifyStats("Farm dolars obtenu", price);
                Player.getInstance().changeMarketPrice(newValue, quantity);
                Menu.getInstance().refreshMoney();
                productTable.refresh();
            });
        });
    }

    private void initSeedInventory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        ObservableList<Seed> datas = FXCollections.observableArrayList();
        datas.addAll(Player.getInstance().getSeeds());
        table.setItems(datas);
    }

    private void initBabyAnimalInventory() {
        colName1.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice1.setCellValueFactory(new PropertyValueFactory<>("price"));
        ObservableList<BabyAnimal> datas = FXCollections.observableArrayList();
        datas.addAll(Player.getInstance().getBabyAnimals());
        table1.setItems(datas);
    }

    private void initProductInventory() {
        productCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPossederCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        ObservableList<Product> datas = FXCollections.observableArrayList();
        datas.addAll(Player.getInstance().getProducts());
        productTable.setItems(datas);
    }
}
