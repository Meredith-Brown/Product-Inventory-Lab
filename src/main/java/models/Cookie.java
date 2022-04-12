package models;

import java.util.List;

public class Cookie implements InventoryItem {
    private int id;
    private String name;
    private List<String> ingredients;
    private int calories;
    private boolean containsNuts;
    private int quantity;
    private float price;

    public  Cookie() {}

    public Cookie(String name, List<String> ingredients, int calories, boolean containsNuts,
                       int quantity, float price, int id) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.containsNuts = containsNuts;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setContainsNuts(boolean containsNuts) {
        this.containsNuts = containsNuts;
    }

    public boolean getContainsNuts() {
        return containsNuts;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getID() {
        return id;
    }
}
