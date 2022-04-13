package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Cookie;
import utils.CSVUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookieService {
    private List<Cookie> inventory = new ArrayList<>();

    private CookieService() throws IOException {
    }

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

    public void writeNextIDToFile() throws IOException {
        String csvFile = "/Users/meredith/dev/CookieInventory.csv";
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextID))));
        writer.flush();
        writer.close();
    }

    public void writeJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("Cookies.json"), inventory);
    }

    public void loadNextID() throws FileNotFoundException {
        String csvFile = "/Users/meredith/dev/CookieInventory.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextID = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCookies() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        inventory = objectMapper.readValue(new File("Cookies.json"), new
                TypeReference<List<Cookie>>() {});
    }

}
