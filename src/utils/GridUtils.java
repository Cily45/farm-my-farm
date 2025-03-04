package utils;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class GridUtils {
    public static int[] getGridPosition(int x, int y, int size) {

        return new int[]{x/size, y/size};
    }

    public static Node getNodeFromGrid(GridPane gridPane, int x, int y){
        for(Node node : gridPane.getChildren()){
            if(GridPane.getRowIndex(node)==x && GridPane.getColumnIndex(node)==y){
                return node;
            }
        }
        return null;
    }
}


