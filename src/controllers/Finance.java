package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Player;
import models.Stats;

import java.io.IOException;

public class Finance {
    @FXML
    private TableView<Stats> table;

    @FXML
    private TableColumn<Stats, String> textTable;

    @FXML
    private TableColumn<Stats, Long> numberTable;

    public void showModal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/finance.fxml"));
            Parent root = loader.load();

            Finance controller = loader.getController();

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.setTitle("Statistiques");
            modalStage.setScene(new Scene(root));

            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        ObservableList<Stats> datas = FXCollections.observableArrayList();

        if (Player.getInstance().getStats() != null) {
            datas.addAll(Player.getInstance().getStats());
        }

        table.setItems(datas);
        textTable.setCellValueFactory(new PropertyValueFactory<>("text"));
        numberTable.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }
}
