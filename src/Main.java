import models.Menu;
import models.Organism;
import models.Player;
import controllers.StartOrganismInventory;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Land;
import utils.save.ReloadFarm;
import utils.GridUtils;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    int WIDTH = 600;
    int HEIGHT = 800;
    private Parent root;

    @FXML
    private Button inventoryButton;

    @FXML
    private VBox vbox;

    @Override
    public void start(Stage primaryStage) throws IOException {
        int sizeLand = 600;
        Land land = new Land(sizeLand, sizeLand);

        Player.getInstance().setLand(land);
        ReloadFarm.ReloadFarm();
        Player.getInstance().init();

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/views/land.fxml")));
        loader.setController(this);
        root = loader.load();

        vbox.getChildren().add(Menu.getInstance().getAnchorPane());
        vbox.getChildren().add(land.getGridPane());

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        land.getGridPane().setStyle("-fx-background-color: #1e6e1a;" + "-fx-background-image: url('asset/herbe.jpg'); " +
                "-fx-background-size: cover; " + "-fx-background-color: transparent;");

        land.getGridPane().setOnMouseClicked(event -> {
            int[] pos = GridUtils.getGridPosition((int) event.getX(), (int) event.getY(), land.getSize());

            if (land.isFieldEmpty(pos[0], pos[1])) {
                new StartOrganismInventory().showModal(pos[0], pos[1]);
            }

        });

        primaryStage.setTitle("Farm my farm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}