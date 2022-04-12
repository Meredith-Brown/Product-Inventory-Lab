package models;

public interface InventoryItem {
    int quantity = 0;
    float price = 0;

    public int getQuantity();

    public void setQuantity(int quantity);

    public float getPrice();

    public void setPrice(float price);
}
