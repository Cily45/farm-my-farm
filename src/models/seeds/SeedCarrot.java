package models.seeds;

import models.vegetable.Carrot;

public class SeedCarrot extends Seed {
    private int price;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void plant(){
    }
}
