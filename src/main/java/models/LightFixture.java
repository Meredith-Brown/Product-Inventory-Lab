package models;

import java.util.List;

public class LightFixture {
    private String partNumber;
    private String manufacturer;
    private String type;
    private String finish;
    private int colorCCT;
    private int lumenOutput;
    private int quantity;
    private float price;

    public  LightFixture() {}

    public LightFixture(String partNumber, String manufacturer, String type, String finish, int colorCCT,
                  int lumenOutput, int quantity, float price) {
        this.partNumber = partNumber;
        this.manufacturer = manufacturer;
        this.type = type;
        this.finish = finish;
        this.colorCCT = colorCCT;
        this.lumenOutput = lumenOutput;
        this.quantity = quantity;
        this.price = price;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getFinish() {
        return finish;
    }

    public void setColorCCT(int colorCCT) {
        this.colorCCT = colorCCT;
    }

    public int getColorCCT() {
        return colorCCT;
    }

    public void setLumenOutput(int lumenOutput) {
        this.lumenOutput = lumenOutput;
    }

    public int getLumenOutput() {
        return lumenOutput;
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
}
