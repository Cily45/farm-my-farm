package ect;

import models.Product;
import models.seeds.Seed;

import java.util.HashMap;

public class Player {
    private HashMap<Product, Integer> products = new HashMap<>();
    private int money = 0;
    private static Player instance;

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.put(product, products.get(product) == null ? 1 : products.get(product) + 1);
    }

    public void sellProduct(Product product, int amount) {
        money += product.getPrice() * amount;
        products.put(product, products.get(product) == null ? 0 : products.get(product) - amount);
    }

    public void buyProduct(Seed seed, int amount) {
        money -= seed.getPrice() * amount;
    }

    public int getMoney() {
        return money;
    }
}
