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
    private ArrayList<Stats> stats = new ArrayList<>();
    private HashMap<Product, Double> currentMarketPrices = new HashMap<>();

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

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public void initProducts() {
        if (products.isEmpty()) {
            Product maize = new Product("Maïs", 300, 0, 300);
            products.add(maize);

            Product sunflower = new Product("Tournesol", 120, 0, 120);
            products.add(sunflower);

            Product wheat = new Product("Blé", 80, 0, 80);
            products.add(wheat);

            Product blueberry = new Product("Myrtille", 200, 0, 200);
            products.add(blueberry);

            Product milk = new Product("Lait", 360, 0, 360);
            products.add(milk);

            Product wool = new Product("Laine", 135, 0, 135);
            products.add(wool);

            Product egg = new Product("Oeuf", 120, 0, 120);
            products.add(egg);

            Product manure = new Product("Fumier", 180, 0, 180);
            products.add(manure);
        }
    }

    public void initStartOrganism() {
        if (seeds.isEmpty()) {
            seeds.add(new Seed("Maïs", 300, 0));
            seeds.add(new Seed("Tournesol", 120, 0));
            seeds.add(new Seed("Myrtille", 200, 0));
            seeds.add(new Seed("Blé", 80, 0));
        }

        if (babyAnimals.isEmpty()) {
            babyAnimals.add(new BabyAnimal("Veau", 1620, 0));
            babyAnimals.add(new BabyAnimal("Oeuf", 540, 0));
            babyAnimals.add(new BabyAnimal("Agneau", 810, 0));
            babyAnimals.add(new BabyAnimal("Poulain", 1080, 0));
        }
    }

    public long getMoney() {
        return money;
    }

    public String getProductsToString() {
        StringBuilder sb = new StringBuilder();

        for (Product p : products) {
            sb.append(String.format("product, name: %s, quantity: %d, price: %d, initPrice: %d", p.getName(), p.getQuantity(), p.getPrice(), p.getInitialPrice())).append("\n");
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

    private void initStats() {
        if (stats.isEmpty()) {
            stats.add(new Stats("Achat de graine", 0L));
            stats.add(new Stats("Achat de bébé animaux", 0L));
            stats.add(new Stats("Vente de produit", 0L));
            stats.add(new Stats("Farm dolars obtenu", 0L));
            stats.add(new Stats("Plante mis en champs", 0L));
            stats.add(new Stats("Animaux mis en élevage", 0L));
            stats.add(new Stats("Dépenses total", 0L));
            stats.add(new Stats("Dépenses en graine", 0L));
            stats.add(new Stats("Dépenses en bébé animaux", 0L));
        }
    }

    public void setStats(ArrayList<Stats> stats) {
        this.stats = stats;
    }

    public String getStatsToString() {
        StringBuilder sb = new StringBuilder();

        for (Stats s : stats) {
            sb.append(String.format("stats, %s, %d\n", s.getText(), s.getQuantity()));
        }

        return sb.toString();
    }

    public void modifyStats(String line, long quantity) {
        Stats stats = getStats().stream().filter(s -> s.getText().equals(line)).findFirst().get();
        stats.addQuantity(quantity);
    }

    private void initMarketPrice() {
        if (currentMarketPrices.isEmpty()) {

            for (Product product : Player.getInstance().getProducts()) {
                currentMarketPrices.put(product, 100.00);
            }

        }
    }

    public void changeMarketPrice(Product product, int quantity) {
        currentMarketPrices.replace(product, currentMarketPrices.get(product) - (quantity * (1.00 / 14.00)));
        int newPrice = (int) (product.getInitialPrice() * currentMarketPrices.get(product) / 100.00);
        product.setPrice(newPrice);

        for (Product p : currentMarketPrices.keySet()) {

            if (!p.equals(product)) {
                currentMarketPrices.replace(p, currentMarketPrices.get(p) + (quantity * (double) (1.00 / 14.00)));
                int newPrice2 = (int) (p.getInitialPrice() * currentMarketPrices.get(p) / 100.00);
                p.setPrice(newPrice2);
            }

        }

    }

    public String getCurrentMarketPriceToString() {
        StringBuilder sb = new StringBuilder();

        for (Product p : currentMarketPrices.keySet()) {
            sb.append(String.format("marketPrice, name: %s, pourcent: %.2f", p.getName(), currentMarketPrices.get(p))).append("\n");
        }

        return sb.toString();
    }

    public void setCurrentMarketPrice(HashMap<Product, Double> currentMarketPrices) {
        this.currentMarketPrices = currentMarketPrices;
    }

    public void init() {
        initStartOrganism();
        initInventary();
        initStats();
        initProducts();
        land.initLockedFields();
        initMarketPrice();
    }
}
