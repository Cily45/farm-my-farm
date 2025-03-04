package models;

import models.seeds.Seed;

import java.util.HashMap;

public class Player {
    private static HashMap<Product, Integer> products = new HashMap<>();
    private static int money = 0;

    public static void addProduct(Product product) {
        products.put(product, products.get(product) == null ? 1 : products.get(product) + 1);

        for (Product p : products.keySet()) {
            System.out.println(p.getName() + ": " + products.get(p));
        }
    }

    public static void sellProduct(Product product, int amount) {
        money += product.getPrice() * amount;
        products.put(product, products.get(product) == null ? 0 : products.get(product) - amount);
    }

    public static void buyProduct(Seed seed, int amount) {
        money -= seed.getPrice() * amount;
    }
}
