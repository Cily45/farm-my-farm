package utils.save;

import models.Player;
import models.Land;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveFarm {
    public static String saveFarm() {
        String filePath = System.getProperty("user.dir") + "/data/save.txt";
        StringBuilder content = new StringBuilder();
        Land land = Player.getInstance().getLand();

        content.append(String.format("FD: %d\n", Player.getInstance().getMoney()));
        content.append(Player.getInstance().getProductsToString());
        content.append(land.getProductsToString());
        content.append(Player.getInstance().getSeedsToString());
        content.append(Player.getInstance().getBabyAnimalsToString());

        try {
            FileWriter fileReader = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
            bufferedWriter.write(content.toString());
            bufferedWriter.close();
            return "Sauvegarde effectuée";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sauvegarde échouée";
    }
}
