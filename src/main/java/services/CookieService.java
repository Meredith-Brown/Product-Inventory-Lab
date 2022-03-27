package services;

import models.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieService {
    List<Cookie> inventory = new ArrayList<>();

    public Cookie create(String name, List<String> ingredients, int calories, boolean containsNuts,
                         int quantity, float price) {
        Cookie createdCookie = new Cookie(name, ingredients, calories, containsNuts, quantity, price);
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
}