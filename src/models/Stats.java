package models;

public class Stats {
    private String text;
    private long quantity = 0;

    public Stats(String text, long quantity) {
        this.text = text;
        this.quantity = quantity;
    }

    public String getText() {
        return text;
    }

    public long getQuantity() {
        return quantity;
    }

    public void addQuantity(long quantity) {
        this.quantity += quantity;
    }
}
