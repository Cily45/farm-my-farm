package models;

public class Field {
    private long price = 0L;
    private int x, y;

    public Field( int x, int y, long price) {
        this.x = x;
        this.y = y;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
