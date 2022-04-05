package services;

import models.Cookie;
import utils.CSVUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookieService {
    private List<Cookie> inventory = new ArrayList<>();

    private CookieService() throws IOException {}

    private static CookieService cookieService;
    static {
        try {
            cookieService = new CookieService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CookieService shared() {
        return cookieService;
    }

    public List<Cookie> getInventory() {
        return inventory;
    }

    private static int nextID = 1;

    public Cookie create(String name, List<String> ingredients, int calories, boolean containsNuts,
                         int quantity, float price) {
        Cookie createdCookie = new Cookie(name, ingredients, calories, containsNuts, quantity, price, nextID++);
        inventory.add(createdCookie);
        return createdCookie;
    }

    public Cookie findCookie(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(name)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    public Cookie[] findAllCookies() {
        Cookie[] inventoryArray = new Cookie[inventory.size()];
        inventoryArray = inventory.toArray(inventoryArray);
        return inventoryArray;
    }

    public boolean deleteCookie(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(name)) {
                inventory.remove(i);
                return true;
            }
        }
        return false;
    }

    public void writeToFile() throws IOException {
        String csvFile = "/Users/meredith/dev/CookieInventory.csv";
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextID))));
        for (Cookie c : inventory) {
            List<String> list = new ArrayList<>();
            list.add(c.getName());
            list.add(String.valueOf(c.getIngredients()));
            list.add(String.valueOf(c.getCalories()));
            list.add(String.valueOf(c.getContainsNuts()));
            list.add(String.valueOf(c.getQuantity()));
            list.add(String.valueOf(c.getPrice()));
            list.add(String.valueOf(c.getID()));
            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }

    public void loadData() throws FileNotFoundException {
        String csvFile = "/Users/meredith/dev/CookieInventory.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextID = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                String[] loadedData = line.split(csvSplitBy);
                String name = loadedData[0];
                List<String> ingredients = new ArrayList<>();
                for (int i = 1; i < loadedData.length - 5; i++) {
                    ingredients.add(loadedData[i]);
                }
                int calories = Integer.parseInt(loadedData[loadedData.length-5]);
                boolean containsNuts = Boolean.parseBoolean(loadedData[loadedData.length-4]);
                int quantity = Integer.parseInt(loadedData[loadedData.length-3]);
                float price = Float.parseFloat(loadedData[loadedData.length-2]);
                int id = Integer.parseInt(loadedData[loadedData.length-1]);
                inventory.add(new Cookie(name, ingredients, calories, containsNuts, quantity, price, id));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}