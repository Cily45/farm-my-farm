package utils.save;

import models.Player;
import models.Product;
import models.animal.BabyAnimal;
import models.vegetable.vegetable.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReloadFarm {
    public static void ReloadFarm() {
        File file = new File(System.getProperty("user.dir") + "/data/save.txt");
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du fichier " + file);
        }
        if (!lines.isEmpty()) {
            String[] moneyLine = lines.get(0).split(": ");
            long money = Long.parseLong(moneyLine[1]);
            Player.getInstance().setMoney(money);

            ArrayList<String> vegetables = new ArrayList<>(lines.stream().filter(line -> line.contains("vegetable")).toList());
            ArrayList<String> products = new ArrayList<>(lines.stream().filter(line -> line.contains("product")).toList());
            ArrayList<String> seeds = new ArrayList<>(lines.stream().filter(line -> line.contains("seed")).toList());
            ArrayList<String> babyAnimals = new ArrayList<>(lines.stream().filter(line -> line.contains("babyAnimal")).toList());

            for (String line : vegetables) {
                String[] splitLine = line.split(", ");
                switch (infoString(splitLine[1])) {
                    case "Maïs":
                        Maize corn = new Maize(
                                Player.getInstance().getLand(),
                                infoInt(splitLine[2]),
                                infoInt(splitLine[3]),
                                infoInt(splitLine[4]),
                                infoInt(splitLine[5])
                        );

                        Player.getInstance().getLand().getGridPane().add(corn.getButton(), corn.getX(), corn.getY());
                        Player.getInstance().getLand().addOrgganism(corn);
                        break;

                    case "Blé":
                        Wheat wheat = new Wheat(
                                Player.getInstance().getLand(),
                                infoInt(splitLine[2]),
                                infoInt(splitLine[3]),
                                infoInt(splitLine[4]),
                                infoInt(splitLine[5])
                        );

                        Player.getInstance().getLand().getGridPane().add(wheat.getButton(), wheat.getX(), wheat.getY());
                        Player.getInstance().getLand().addOrgganism(wheat);
                        break;

                    case "Myrtille":
                        Blueberry blueberry = new Blueberry(
                                Player.getInstance().getLand(),
                                infoInt(splitLine[2]),
                                infoInt(splitLine[3]),
                                infoInt(splitLine[4]),
                                infoInt(splitLine[5])
                        );

                        Player.getInstance().getLand().getGridPane().add(blueberry.getButton(), blueberry.getX(), blueberry.getY());
                        Player.getInstance().getLand().addOrgganism(blueberry);
                        break;

                    case "Tournesol":
                        SunFlower sunflower = new SunFlower(
                                Player.getInstance().getLand(),
                                infoInt(splitLine[2]),
                                infoInt(splitLine[3]),
                                infoInt(splitLine[4]),
                                infoInt(splitLine[5])
                        );

                        Player.getInstance().getLand().getGridPane().add(sunflower.getButton(), sunflower.getX(), sunflower.getY());
                        Player.getInstance().getLand().addOrgganism(sunflower);
                        break;
                }
            }

            ArrayList<Product> productsPlayer = new ArrayList<>();
            for (String line : products) {
                String[] splitLine = line.split(", ");
                Product product = new Product(
                        infoString(splitLine[1]),
                        infoInt(splitLine[3]),
                        infoInt(splitLine[2]));

                productsPlayer.add(product);
            }

            ArrayList<Seed> seedsPlayer = new ArrayList<>();
            for (String line : seeds) {
                String[] splitLine = line.split(", ");
                Seed seed = new Seed(
                        infoString(splitLine[1]),
                        infoInt(splitLine[3]),
                        infoInt(splitLine[2]));

                seedsPlayer.add(seed);
            }

            ArrayList<BabyAnimal> babyAnimalPlayer = new ArrayList<>();
            for (String line : babyAnimals) {
                String[] splitLine = line.split(", ");
                BabyAnimal babyAnimal = new BabyAnimal(
                        infoString(splitLine[1]),
                        infoInt(splitLine[3]),
                        infoInt(splitLine[2]));

                babyAnimalPlayer.add(babyAnimal);
            }

            Player.getInstance().setSeeds(seedsPlayer);
            Player.getInstance().setBabyAnimals(babyAnimalPlayer);
        }
    }

    private static String infoString(String line) {
        String[] splitLine = line.split(": ");
        return splitLine[1];
    }

    private static int infoInt(String line) {
        String[] splitLine = line.split(": ");
        return Integer.parseInt(splitLine[1].trim());
    }
}

