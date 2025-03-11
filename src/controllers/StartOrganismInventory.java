package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Player;
import models.Product;
import models.animal.*;
import models.Organism;
import models.vegetable.vegetable.*;

import java.io.IOException;

public class StartOrganismInventory {
    @FXML
    private TableView<Seed> table;

    @FXML
    private Button plantButton;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Integer> colQuantity;

    @FXML
    private TableView<BabyAnimal> table1;

    @FXML
    private Button plantButton1;

    @FXML
    private TableColumn<Product, String> colName1;

    @FXML
    private TableColumn<Product, Integer> colQuantity1;

    private int x;
    private int y;

    public void showModal(int x1, int y1) {
        this.x = x1;
        this.y = y1;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/StartOrganismInventary.fxml"));
            Parent root = loader.load();

            StartOrganismInventory controller = loader.getController();
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
        initSeedInventory();
        initBabyAnimalInventory();
    }

    public void plantSeed(String type) {
        Organism organism = null;

        switch (type) {
            case "Maïs":
                organism = new Maize(Player.getInstance().getLand(), x, y);

                break;
            case "Tournesol":
                organism = new SunFlower(Player.getInstance().getLand(), x, y);

                break;
            case "Blé":
                organism = new Wheat(Player.getInstance().getLand(), x, y);

                break;
            case "Myrtille":
                organism = new Blueberry(Player.getInstance().getLand(), x, y);

                break;
        }

        Player.getInstance().getLand().getGridPane().add(organism.getButton(), organism.getX(), organism.getY());
        GridPane.setHalignment(organism.getButton(), HPos.CENTER);
        GridPane.setValignment(organism.getButton(), VPos.CENTER);
        Player.getInstance().getLand().addOrgganism(organism);
        Player.getInstance().modifyStats("Plante mis en champs", 1);
    }

    public void installAnimal(String type) {
        Animal animal = null;

        switch (type) {
            case "Veau":
                animal = new Cow(Player.getInstance().getLand(), x, y);
                break;

            case "Oeuf":
                animal = new Chicken(Player.getInstance().getLand(), x, y);
                break;

            case "Poulain":
                animal = new Horse(Player.getInstance().getLand(), x, y);

                break;
            case "Agneau":
                animal = new Sheep(Player.getInstance().getLand(), x, y);
                break;
        }

        Player.getInstance().getLand().getGridPane().add(animal.getButton(), animal.getX(), animal.getY());

        Player.getInstance().getLand().addOrgganism(animal);
        GridPane.setHalignment(animal.getButton(), HPos.CENTER);
        GridPane.setValignment(animal.getButton(), VPos.CENTER);
        Player.getInstance().modifyStats("Animaux mis en élevage", 1);

    }

    private void initStartOrganismInventories() {
        ObservableList<Seed> datas = FXCollections.observableArrayList();
        ObservableList<BabyAnimal> datas1 = FXCollections.observableArrayList();

        if (Player.getInstance().getSeeds() != null) {
            datas.addAll(Player.getInstance().getSeeds());
        }

        if (Player.getInstance().getBabyAnimals() != null) {
            datas1.addAll(Player.getInstance().getBabyAnimals());
        }

        table.setItems(datas);
        table1.setItems(datas1);
    }

    private void initSeedInventory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        initStartOrganismInventories();

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue.getQuantity() > 0) {
                plantButton.setOnAction(event -> {
                    plantSeed(newValue.getType());
                    newValue.removeSeed(1);
                    table.refresh();
                    Stage stage = (Stage) table.getScene().getWindow();
                    stage.close();
                });
            }

        });

    }

    private void initBabyAnimalInventory() {
        colName1.setCellValueFactory(new PropertyValueFactory<>("type"));
        colQuantity1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        initStartOrganismInventories();

        table1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue.getQuantity() > 0) {
                plantButton1.setOnAction(event -> {
                    installAnimal(newValue.getType());
                    newValue.removeSeed(1);
                    table.refresh();
                    Stage stage = (Stage) table1.getScene().getWindow();
                    stage.close();
                });
            }

        });

    }
}
