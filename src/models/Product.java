package models;

import java.util.ArrayList;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void addQuantity() {
        quantity += 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

}
