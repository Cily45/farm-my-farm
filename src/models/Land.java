package models;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

public class Land {
    private int height;
    private int width;
    private int size = 30;
    private int countColumn;
    private int countRow;
    private GridPane gridPane;
    private ArrayList<Organism> organisms = new ArrayList<>();

    public Land(int x, int y) {
        this.height = y;
        this.width = x;
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

    public ArrayList<Organism> getOrganisms() {
        return organisms;
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

    public void addOrgganism(Organism organism){
        organisms.add(organism);
    }

    public void removeOrganism(Organism organism){
        organisms.remove(organism);
    }

    public String getProductsToString(){
        StringBuilder sb = new StringBuilder();

        for(Organism o : organisms){

            sb.append(String.format("vegetable type: %s, actualStade: %d, elapsedTime: %d, x: %d, y: %d", o.getType(), o.getActualStade(), o.getElapsedTime(), o.getX(), o.getY())).append("\n");
        }

        return sb.toString();
    }

    public boolean isFieldEmpty(int x , int y){
        boolean isVegetable = organisms.stream().anyMatch(vegetable -> vegetable.getX() == x && vegetable.getY() == y);

        return !isVegetable;
    }
}
