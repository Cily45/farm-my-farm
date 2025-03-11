package models;

public class Product {
    private String name;
    private int price;
    private int quantity;
    private int initialPrice;

    public Product(String name, int price, int quantity, int initialPrice) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.initialPrice = initialPrice;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInitialPrice() {
        return initialPrice;
    }
}
