package models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.util.Duration;
import models.animal.Animal;

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
    private Weather currentWeather;

    public Land(int x, int y) {
        this.height = y;
        this.width = x;
        this.countColumn = height/size;
        this.countRow = width/size;
        init();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public int getSize() {
        return size;
    }

    private void init(){
        gridPane = new GridPane();
        gridPane.setPrefSize(width, height);

        for(int i = 0; i < countColumn; i++){
            ColumnConstraints column = new ColumnConstraints(size);
            gridPane.getColumnConstraints().add(column);
        }

        for(int i = 0; i < countRow; i++){
            RowConstraints row = new RowConstraints(size);
            gridPane.getRowConstraints().add(row);
        }
        weathers.add(new Weather(1, new Image("asset/belle-eclaircies.png")));
        weathers.add(new Weather(1, new Image("asset/neige.png")));
        weathers.add(new Weather(1, new Image("asset/nuageux.png")));
        weathers.add(new Weather(1, new Image("asset/orage.png")));
        weathers.add(new Weather(1, new Image("asset/pluie.png")));
        weathers.add(new Weather(1, new Image("asset/soleil.png")));
        weathers.add(new Weather(1, new Image("asset/arc-en-ciel.png")));
    }

    public void changeWeather(){
        int rand = (int) (Math.random() * weathers.size());
        currentWeather = weathers.get(rand);
        Menu.getInstance().changeWeatherImage(currentWeather.getImage());
    }

    public void addOrgganism(Organism organism){

        organisms.add(organism);
    }

    public void removeOrganism(Organism organism){
        organisms.remove(organism);
    }

    public String getProductsToString(){
        StringBuilder sb = new StringBuilder();

        for(Organism o : organisms){
            sb.append(String.format("type: %s, name: %s, actualStade: %d, elapsedTime: %d, x: %d, y: %d", o.getType(), o.getName(), o.getActualStade(), o.getElapsedTime(), o.getX(), o.getY())).append("\n");
        }

        return sb.toString();
    }

    public boolean isFieldEmpty(int x , int y){
        boolean isVegetable = organisms.stream().anyMatch(vegetable -> vegetable.getX() == x && vegetable.getY() == y);

        return !isVegetable;
    }

    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }
}
