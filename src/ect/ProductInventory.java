package ect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ProductInventory extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/layout/productInventary.fxml")));
        loader.setController(this);
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 800);
        stage.setScene(scene);
        stage.setTitle("Product Inventory");
        stage.show();

    }
}
