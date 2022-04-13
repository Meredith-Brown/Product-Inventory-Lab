package services;

import models.Cookie;
import models.LightFixture;

import java.util.HashSet;
import java.util.Set;

public class ReportGenerator {
    private CookieService cookieService = CookieService.shared();
    private LightFixtureService lightFixtureService = LightFixtureService.shared();

    public void listNutFreeCookies() {
        for (Cookie cookie : cookieService.getInventory()) {
            if (cookie.getContainsNuts() == false) {
                System.out.println(cookie.getName());
            }
        }
    }

    public void getFixturesByType() {
        Set<String> types = new HashSet<>();
        for (LightFixture light : lightFixtureService.getInventory()) {
            types.add(light.getType());
        }
        for (String type : types) {
            System.out.println(type);
            System.out.println("-------------------------------------------------");
            for (int i = 0; i < lightFixtureService.getInventory().size(); i++) {
                if (lightFixtureService.getInventory().get(i).getType() == type) {
                    System.out.println(lightFixtureService.getInventory().get(i).getManufacturer() +
                            lightFixtureService.getInventory().get(i).getPartNumber() + ", Qty.: " +
                            lightFixtureService.getInventory().get(i).getQuantity());
                }
            }
            System.out.println("=================================================");
        }
    }

}
