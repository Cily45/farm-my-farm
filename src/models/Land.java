package models;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import models.vegetable.Vegetable;

import java.util.ArrayList;

public class Land {
    private int height;
    private int width;
    private int size;
    private int countColumn;
    private int countRow;
    private GridPane gridPane;
    private ArrayList<Vegetable> cereals = new ArrayList<>();

    public Land(int x, int y, int size) {
        this.height = y;
        this.width = x;
        this.size = size;
        this.countColumn = height/size;
        this.countRow = width/size;
        init();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public int getSize() {
        return size;
    }

    public int getCountColumn() {
        return countColumn;
    }

    public int getCountRow() {
        return countRow;
    }

    public ArrayList<Vegetable> getCereals() {
        return cereals;
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
    }

    public void addCereal(Vegetable cereal){
        cereals.add(cereal);
    }

    public void removeCereal(Vegetable cereal){
        cereals.remove(cereal);
    }
}
