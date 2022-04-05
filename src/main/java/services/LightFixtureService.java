package services;

import models.Cookie;
import models.LightFixture;
import utils.CSVUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LightFixtureService {
    private List<LightFixture> inventory = new ArrayList<>();

    private LightFixtureService() throws IOException {}

    private static LightFixtureService lightFixtureService;
    static {
        try {
            lightFixtureService = new LightFixtureService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LightFixtureService shared() {
        return lightFixtureService;
    }

    public List<LightFixture> getInventory() {
        return inventory;
    }

    private static int nextID = 1;

    public LightFixture create(String partNumber, String manufacturer, String type, String finish,
                               int colorCCT, int lumenOutput, int quantity, float price) {
        LightFixture createdLightFixture = new LightFixture(partNumber, manufacturer, type, finish,
                colorCCT, lumenOutput, quantity, price, nextID++);
        inventory.add(createdLightFixture);
        System.out.println("\n" + partNumber + " created.");
        return createdLightFixture;
    }

    public LightFixture findLightFixture(String partNumber) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getPartNumber().equals(partNumber)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    public LightFixture[] findAllLightFixtures() {
        LightFixture[] inventoryArray = new LightFixture[inventory.size()];
        inventoryArray = inventory.toArray(inventoryArray);
        return inventoryArray;
    }

    public boolean deleteLightFixture(String partNumber) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getPartNumber().equals(partNumber)) {
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }

    public void writeToFile() throws IOException {
        String csvFile = "/Users/meredith/dev/LightFixtureInventory.csv";
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextID))));
        for (LightFixture l : inventory) {
            List<String> list = new ArrayList<>();
            list.add(l.getPartNumber());
            list.add(l.getManufacturer());
            list.add(l.getType());
            list.add(l.getFinish());
            list.add(String.valueOf(l.getColorCCT()));
            list.add(String.valueOf(l.getLumenOutput()));
            list.add(String.valueOf(l.getQuantity()));
            list.add(String.valueOf(l.getPrice()));
            list.add(String.valueOf(l.getID()));
            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }

    public void loadData() throws FileNotFoundException {
        String csvFile = "/Users/meredith/dev/LightFixtureInventory.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextID = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                String[] loadedData = line.split(csvSplitBy);
                String partNumber = loadedData[0];
                String manufacturer = loadedData[1];
                String type = loadedData[2];
                String finish = loadedData[3];
                int colorCCT = Integer.parseInt(loadedData[4]);
                int lumenOutput = Integer.parseInt(loadedData[5]);
                int quantity = Integer.parseInt(loadedData[6]);
                float price = Float.parseFloat(loadedData[7]);
                int id = Integer.parseInt(loadedData[8]);
                inventory.add(new LightFixture(partNumber, manufacturer, type, finish, colorCCT,
                        lumenOutput, quantity, price, id));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
