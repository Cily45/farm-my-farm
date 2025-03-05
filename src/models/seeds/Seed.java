package models.seeds;

public class Seed {
    private String type;
    private int price;
    private int quantity;

    public Seed(String type, int price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeOneSeed(){
        quantity -= 1;
    }
}