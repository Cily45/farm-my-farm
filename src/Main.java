import ect.Menu;
import ect.ProductInventory;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.vegetable.Carrot;
import models.vegetable.Vegetable;
import models.Land;
import utils.GridUtils;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    int WIDTH = 600;
    int HEIGHT= 800;
    private Parent root;

    @FXML
    private Button inventoryButton;

    @FXML
    private VBox vbox;

    @Override
    public void start(Stage primaryStage) throws IOException {
        int sizeLand = 600;
        int size = 30;
        Land land = new Land(sizeLand, sizeLand, size);

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/layout/land.fxml")));
        loader.setController(this);
         root = loader.load();

        vbox.getChildren().add(Menu.getInstance().getAnchorPane());
        vbox.getChildren().add(land.getGridPane());

        Scene scene = new Scene(root, WIDTH, HEIGHT);

        land.getGridPane().setStyle("-fx-background-color: #4e0909;");

        land.getGridPane().setOnMouseClicked(event -> {
            int[] pos = GridUtils.getGridPosition((int) event.getX(), (int) event.getY(), land.getSize());
            Vegetable carrot = new Carrot(land, pos[0], pos[1], 60);
            land.getGridPane().add(carrot.getButton(), carrot.getX(), carrot.getY());
            land.addCereal(carrot);
        });

        primaryStage.setTitle("Farm my farm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Parent getRoot() {
        return root;
    }
}