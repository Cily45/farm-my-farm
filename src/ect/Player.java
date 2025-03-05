package ect;

import models.Land;
import models.Product;
import models.seeds.Seed;
import models.vegetable.Carrot;

import java.util.ArrayList;

public class Player {
    private long money = 500L;
    private static Player instance;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Seed> seeds = new ArrayList<>();
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

    public void initInventary(){
        initProducts();
        initSeeds();
    }

    public void initProducts(){
        products.add(Carrot.getProduct());
    }

    public void initSeeds(){
        if(seeds.isEmpty()){
            seeds.add(new Seed("Carotte", 10 , 5));
        }
    }

//    public void sellProduct(Product product, int amount) {
//        money += product.getPrice() * amount;
//        products.put(product, products.get(product) == null ? 0 : products.get(product) - amount);
//    }
//
//    public void buyProduct(Seed seed, int amount) {
//        money -= seed.getPrice() * amount;
//    }

    public long getMoney() {
        return money;
    }

    public String getProductsToString(){
        StringBuilder sb = new StringBuilder();

        for(Product p : products){
            sb.append(String.format("product, name: %s, quantity: %d, price: %d", p.getName() , p.getQuantity(), p.getPrice())).append("\n");
        }


        return sb.toString();
    }

    public String getSeedsToString(){
        StringBuilder sb = new StringBuilder();

        for(Seed s : seeds){
            sb.append(String.format("seed, name: %s, quantity: %d, price: %d", s.getType() , s.getQuantity(), s.getPrice())).append("\n");
        }


        return sb.toString();
    }

    public Land getLand() {
        return land;
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public void setMoney(long money) {
        this.money += money;
    }

    public void setMoneySaved(long money) {
        this.money = money;
    }

    public void setSeeds(ArrayList<Seed> seeds) {
        this.seeds = seeds;
    }
}
