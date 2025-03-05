package save;

import ect.Player;
import models.Product;
import models.seeds.Seed;
import models.vegetable.Carrot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
            Player.getInstance().setMoneySaved(money);

            ArrayList<String> vegetables = new ArrayList<>(lines.stream().filter(line -> line.contains("vegetable")).toList());
            ArrayList<String> products = new ArrayList<>(lines.stream().filter(line -> line.contains("product")).toList());
            ArrayList<String> seeds = new ArrayList<>(lines.stream().filter(line -> line.contains("seed")).toList());

            for (String line : vegetables) {
                String[] splitLine = line.split(", ");

                switch (infoString(splitLine[1])) {
                    case "carrot":
                        Carrot carrot = new Carrot(
                                Player.getInstance().getLand(),
                                infoInt(splitLine[2]),
                                infoInt(splitLine[3]),
                                infoInt(splitLine[4]),
                                infoInt(splitLine[5])
                        );

                        Player.getInstance().getLand().getGridPane().add(carrot.getButton(), carrot.getX(), carrot.getY());
                        Player.getInstance().getLand().addCereal(carrot);
                }
            }

            for (String line : products) {
                String[] splitLine = line.split(", ");
                    Product product = new Product(
                            infoString(splitLine[1]),
                            infoInt(splitLine[3]),
                            infoInt(splitLine[2]));

                switch(product.getName()){
                    case "Carotte":
                        Carrot.setProduct(product);
                }
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
            Player.getInstance().setSeeds(seedsPlayer);
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

