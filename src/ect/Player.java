package ect;

import models.Land;
import models.Product;
import models.StartOrganism;
import models.animal.Animal;
import models.animal.BabyAnimal;
import models.vegetable.vegetable.Carrot;
import models.vegetable.vegetable.Corn;
import models.vegetable.vegetable.Seed;

import java.util.ArrayList;

public class Player {
    private long money = 500L;
    private static Player instance;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Seed> seeds = new ArrayList<>();
    private ArrayList<BabyAnimal> babyAnimals = new ArrayList<>();

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
        products.add(Carrot.getProduct());
        products.add(Corn.getProduct());
        products.add(Animal.getProduct());
        System.out.println(Carrot.getProduct().getPrice());
    }

    public void initStartOrganism() {
        if (seeds.isEmpty()) {
            seeds.add(new Seed("Carotte", 10, 5));
            seeds.add(new Seed("Maïs", 50, 5));
        }
        if (babyAnimals.isEmpty()) {
            babyAnimals.add(new BabyAnimal("Bébé animal", 10, 5));
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

    public String getAnimalToString() {
        StringBuilder sb = new StringBuilder();

        for (StartOrganism s : seeds) {
            sb.append(String.format("animal, name: %s, quantity: %d, price: %d", s.getType(), s.getQuantity(), s.getPrice())).append("\n");
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

    public void setMoney(long money) {
        this.money = money;
    }

    public void setSeeds(ArrayList<Seed> seeds) {

        this.seeds = seeds;
    }
    public void setBabyAnimals(ArrayList<BabyAnimal> babyAnimals) {this.babyAnimals = babyAnimals;}

    public void getAnimal(int x, int y) {

    }
}
