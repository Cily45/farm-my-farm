import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.vegetable.Carrot;
import models.vegetable.Vegetable;
import models.Land;
import utils.GridUtils;

import java.io.IOException;

public class Main extends Application {

    @FXML
    private GridPane gridPane;

    @Override
    public void start(Stage primaryStage) throws IOException {
//        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/layout/grid.fxml")));
//        loader.setController(this);
//        Parent root = loader.load();
        int sizeLand = 600;
        int size = 60;
        Land land = new Land(sizeLand, sizeLand, size);
        GridPane root = land.getGridPane();
        Scene scene = new Scene(root, land.getHeight(), land.getWidth());

        root.setStyle("-fx-background-color: #4e0909;");


        root.setOnMouseClicked(event -> {
            int[] pos = GridUtils.getGridPosition((int) event.getX(), (int) event.getY(), land.getSize());
            Vegetable carrot = new Carrot(land, pos[0], pos[1], 60);
            root.add(carrot.getButton(), carrot.getX(), carrot.getY());
            land.addCereal(carrot);
        });



        primaryStage.setTitle("Farm my farm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}