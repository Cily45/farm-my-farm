package models;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;


public class Land {
    private int height;
    private int width;
    private int size = 120;
    private int countColumn;
    private int countRow;
    private GridPane gridPane;
    private ArrayList<Organism> organisms = new ArrayList<>();
    private ArrayList<Weather> weathers = new ArrayList<>();
    private ArrayList<Integer[]> blockedGrids = new ArrayList<>();
    private Weather currentWeather;

    public Land(int x, int y) {
        this.height = y;
        this.width = x;
        this.countColumn = height / size;
        this.countRow = width / size;

        for (int i = countColumn - 3; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                blockedGrids.add(new Integer[]{j, i});
            }
        }
        init();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public int getSize() {
        return size;
    }

    private void init() {
        gridPane = new GridPane();
        gridPane.setPrefSize(width, height);

        for (int i = 0; i < countColumn; i++) {
            ColumnConstraints column = new ColumnConstraints(size);
            gridPane.getColumnConstraints().add(column);
        }

        for (int i = 0; i < countRow; i++) {
            RowConstraints row = new RowConstraints(size);
            gridPane.getRowConstraints().add(row);
        }

        weathers.add(new Weather(1.2, new Image("asset/belle-eclaircies.png")));
        weathers.add(new Weather(0.4, new Image("asset/neige.png")));
        weathers.add(new Weather(1, new Image("asset/nuageux.png")));
        weathers.add(new Weather(0.6, new Image("asset/orage.png")));
        weathers.add(new Weather(0.2, new Image("asset/pluie.png")));
        weathers.add(new Weather(1.4, new Image("asset/soleil.png")));
        weathers.add(new Weather(1.6, new Image("asset/arc-en-ciel.png")));
    }

    public void initBlockedGrids() {
        for (Integer[] blocked : blockedGrids) {
            Button button = new Button("Acheter\n5'000 FD");
            button.setLayoutX(blocked[0]);
            button.setLayoutY(blocked[0]);
            button.setPrefHeight(size - 10);
            button.setPrefWidth(size - 10);
            gridPane.add(button, blocked[0], blocked[1]);
            GridPane.setHalignment(button, HPos.CENTER);
            GridPane.setValignment(button, VPos.CENTER);
            button.setOnAction(event -> {
                if (Player.getInstance().getMoney() >= 5000) {
                    Player.getInstance().setMoney(Player.getInstance().getMoney() - 5000);
                    Menu.getInstance().setLabel("Terrain acheté");
                    Menu.getInstance().refreshMoney();
                    gridPane.getChildren().remove(button);
                    blockedGrids.remove(blocked);
                }
            });
        }
    }

    public void changeWeather() {
        int rand = (int) (Math.random() * weathers.size());
        currentWeather = weathers.get(rand);
        Menu.getInstance().changeWeatherImage(currentWeather.getImage());
    }

    public void addOrgganism(Organism organism) {
        organisms.add(organism);
    }

    public void removeOrganism(Organism organism) {
        organisms.remove(organism);
    }

    public String getOrganimsToString() {
        StringBuilder sb = new StringBuilder();

        for (Organism o : organisms) {
            sb.append(String.format("type: %s, name: %s, actualStade: %d, elapsedTime: %d, x: %d, y: %d", o.getType(), o.getName(), o.getActualStade(), o.getElapsedTime(), o.getX(), o.getY())).append("\n");
        }

        return sb.toString();
    }

    public boolean isFieldEmpty(int x, int y) {
        boolean isVegetable = organisms.stream().anyMatch(vegetable -> vegetable.getX() == x && vegetable.getY() == y);

        return !isVegetable;
    }

    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }

    public double getCurrentWeatherRatio() {
        return currentWeather.getRatio();
    }

    public String getBlockedGridsToString() {
        StringBuilder sb = new StringBuilder();

        for (Integer[] blocked : blockedGrids) {
            sb.append(String.format("blockedGrid, x: %d, y: %d", blocked[0], blocked[1])).append("\n");
        }

        return sb.toString();
    }

    public void setBlockedGrids(ArrayList<Integer[]> blockedGrids) {
        this.blockedGrids = blockedGrids;
    }
}
