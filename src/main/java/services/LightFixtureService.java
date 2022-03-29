package services;

import models.LightFixture;

import java.util.ArrayList;
import java.util.List;

public class LightFixtureService {
    List<LightFixture> inventory = new ArrayList<>();

    public LightFixture create(String partNumber, String manufacturer, String type, String finish,
                               int colorCCT, int lumenOutput, int quantity, float price) {
        LightFixture createdLightFixture = new LightFixture(partNumber, manufacturer, type, finish,
                colorCCT, lumenOutput, quantity, price);
        inventory.add(createdLightFixture);
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
}
