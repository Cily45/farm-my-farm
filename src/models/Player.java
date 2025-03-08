package models;

import models.animal.BabyAnimal;
import models.vegetable.vegetable.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private long money = 500L;
    private static Player instance;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Seed> seeds = new ArrayList<>();
    private ArrayList<BabyAnimal> babyAnimals = new ArrayList<>();
    private HashMap<String, Integer> stats = new HashMap<>();

    private Land land = null;

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void initInventary() {
        initProducts();
        initStartOrganism();
    }


    public void initProducts() {
        if(products.isEmpty()) {
            Product maize = new Product("Maïs", 40, 10);
            products.add(maize);

            Product sunflower = new Product("Tournesol", 20, 0);
            products.add(sunflower);

            Product wheat = new Product("Blé", 20, 0);
            products.add(wheat);

            Product blueberry = new Product("Myrtille", 20, 0);
            products.add(blueberry);

            Product milk = new Product("Lait", 20, 0);
            products.add(milk);

            Product wool = new Product("Laine", 20, 0);
            products.add(wool);

            Product egg = new Product("Oeuf", 20, 0);
            products.add(egg);

            Product manure = new Product("Fumier", 20, 0);
            products.add(manure);
        }
    }

    public void initStartOrganism() {
        if (seeds.isEmpty()) {
            seeds.add(new Seed("Maïs", 40, 0));
            seeds.add(new Seed("Tournesol", 20, 0));
            seeds.add(new Seed("Myrtille", 30, 0));
            seeds.add(new Seed("Blé", 10, 0));
        }

        if (babyAnimals.isEmpty()) {
            babyAnimals.add(new BabyAnimal("Veau", 10, 0));
            babyAnimals.add(new BabyAnimal("Oeuf", 10, 0));
            babyAnimals.add(new BabyAnimal("Agneau", 10, 0));
            babyAnimals.add(new BabyAnimal("Poulain", 10, 0));
        }
    }

    public long getMoney() {
        return money;
    }

    public String getProductsToString() {
        StringBuilder sb = new StringBuilder();

        for (Product p : products) {
            sb.append(String.format("product, name: %s, quantity: %d, price: %d", p.getName(), p.getQuantity(), p.getPrice())).append("\n");
        }

        return sb.toString();
    }

    public String getSeedsToString() {
        StringBuilder sb = new StringBuilder();

        for (StartOrganism s : seeds) {
            sb.append(String.format("seed, name: %s, quantity: %d, price: %d", s.getType(), s.getQuantity(), s.getPrice())).append("\n");
        }
        return sb.toString();
    }

    public String getBabyAnimalsToString() {
        StringBuilder sb = new StringBuilder();

        for (StartOrganism s : babyAnimals) {
            sb.append(String.format("babyAnimal, name: %s, quantity: %d, price: %d", s.getType(), s.getQuantity(), s.getPrice())).append("\n");
        }
        return sb.toString();
    }

    public Land getLand() {
        return land;
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public ArrayList<BabyAnimal> getBabyAnimals() {
        return babyAnimals;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void setSeeds(ArrayList<Seed> seeds) {
        this.seeds = seeds;
    }

    public void setBabyAnimals(ArrayList<BabyAnimal> babyAnimals) {
        this.babyAnimals = babyAnimals;
    }

    public Product getProduct(String name) {
        return products.stream().filter(product -> product.getName().equals(name)).findFirst().orElse(null);
    }

    public void initStats(){
        stats.put("Achat de graine", 0);
        stats.put("Achat de bébé animaux", 0);
        stats.put("Vente de produit", 0);
        stats.put("Farm dolars obtenu", 0);
        stats.put("Plante mis en champs", 0);
        stats.put("Animaux mis en élevage",0);
    }

    public void init(){
        initStartOrganism();
        initInventary();
        initStats();
        initProducts();
    }
}
