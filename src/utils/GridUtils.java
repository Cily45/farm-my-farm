package utils;

public class GridUtils {
    public static int[] getGridPosition(int x, int y, int size) {
        return new int[]{x / size, y / size};
    }
}


