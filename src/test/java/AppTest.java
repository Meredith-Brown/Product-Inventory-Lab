import models.Cookie;
import models.LightFixture;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.CookieService;
import services.LightFixtureService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AppTest {
    App app = new App();
    CookieService cookieService = CookieService.shared();
    String[] ingredients = {"Flour", "Sugar", "Butter"};
    List<String> ingredientsList = Arrays.asList(ingredients);
    LightFixtureService lightFixtureService = LightFixtureService.shared();

    @Test
    void updateProduct1() { // test update cookie - name
        // given
        Cookie cookie = cookieService.create("SugarTest", ingredientsList, 150,
                false, 23, 2.00f);
        String productToUpdate = "Cookie";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("SugarTest");
        fieldAndNewInput.add("Name");
        String expected = "SugarTest - Unfrosted";
        fieldAndNewInput.add(expected);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        String actual = cookieService.findCookie(expected).getName();
        Assert.assertEquals(expected, actual);
        // clear
        cookieService.deleteCookie("SugarTest - Unfrosted");
    }

    @Test
    void updateProduct2() { // test update cookie - calories
        // given
        Cookie cookie = cookieService.create("SugarTest", ingredientsList, 150,
                false, 23, 2.00f);
        String productToUpdate = "Cookie";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("SugarTest");
        fieldAndNewInput.add("Calories");
        String expectedString = "225";
        fieldAndNewInput.add(expectedString);
        int expected = Integer.parseInt(expectedString);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        int actual = cookieService.findCookie("SugarTest").getCalories();
        Assert.assertEquals(expected, actual);
        // clear
        cookieService.deleteCookie("SugarTest");
    }

    @Test
    void updateProduct3() { // test update cookie - contains nuts
        // given
        Cookie cookie = cookieService.create("updateProduct3-AppTest", ingredientsList, 150,
                false, 23, 2.00f);
        String productToUpdate = "Cookie";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("updateProduct3-AppTest");
        fieldAndNewInput.add("Contains Nuts?");
        String expectedString = "true";
        fieldAndNewInput.add(expectedString);
        boolean expected = Boolean.parseBoolean(expectedString);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        boolean actual = cookieService.findCookie("updateProduct3-AppTest").getContainsNuts();
        Assert.assertEquals(expected, actual);
        // clear
        cookieService.deleteCookie("updateProduct3-AppTest");
    }

    @Test
    void updateProduct4() { // test update cookie - quantity
        // given
        Cookie cookie = cookieService.create("updateProduct4-AppTest", ingredientsList, 150,
                false, 23, 2.00f);
        String productToUpdate = "Cookie";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("updateProduct4-AppTest");
        fieldAndNewInput.add("Quantity In Stock");
        String expectedString = "47";
        fieldAndNewInput.add(expectedString);
        int expected = Integer.parseInt(expectedString);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        int actual = cookieService.findCookie("updateProduct4-AppTest").getQuantity();
        Assert.assertEquals(expected, actual);
        // clear
        cookieService.deleteCookie("updateProduct4-AppTest");
    }

    @Test
    void updateProduct5() { // test update cookie - price
        // given
        Cookie cookie = cookieService.create("updateProduct5-AppTest", ingredientsList, 150,
                false, 23, 2.00f);
        String productToUpdate = "Cookie";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("updateProduct5-AppTest");
        fieldAndNewInput.add("Price");
        String expectedString = "2.25";
        fieldAndNewInput.add(expectedString);
        float expected = Float.parseFloat(expectedString);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        float actual = cookieService.findCookie("updateProduct5-AppTest").getPrice();
        Assert.assertEquals(expected, actual, 0.01);
        // clear
        cookieService.deleteCookie("updateProduct5-AppTest");
    }

    @Test
    void updateProduct6() { // test update light fixture - part number
        // given
        LightFixture lightFixture = lightFixtureService.create("AppTest6-UPDATE", "Lithonia",
                "2X2", "White", 3500, 3000, 80, 91.25f);
        String productToUpdate = "Light Fixture";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("AppTest6-UPDATE");
        fieldAndNewInput.add("Part Number");
        String expected = "AppTest6";
        fieldAndNewInput.add(expected);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        String actual = lightFixtureService.findLightFixture(expected).getPartNumber();
        Assert.assertEquals(expected, actual);
        // clear
        lightFixtureService.deleteLightFixture("AppTest6");
    }

    @Test
    void updateProduct7() { // test update light fixture - manufacturer
        // given
        LightFixture lightFixture = lightFixtureService.create("AppTest7", "Lithonia",
                "2X2", "White", 3500, 3000, 80, 91.25f);
        String productToUpdate = "Light Fixture";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("AppTest7");
        fieldAndNewInput.add("Manufacturer");
        String expected = "Acuity";
        fieldAndNewInput.add(expected);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        String actual = lightFixtureService.findLightFixture("AppTest7").getManufacturer();
        Assert.assertEquals(expected, actual);
        // clear
        lightFixtureService.deleteLightFixture("AppTest7");
    }

    @Test
    void updateProduct8() { // test update light fixture - type
        // given
        LightFixture lightFixture = lightFixtureService.create("AppTest8", "Lithonia",
                "2X2", "White", 3500, 3000, 80, 91.25f);
        String productToUpdate = "Light Fixture";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("AppTest8");
        fieldAndNewInput.add("Type");
        String expected = "Troffer";
        fieldAndNewInput.add(expected);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        String actual = lightFixtureService.findLightFixture("AppTest8").getType();
        Assert.assertEquals(expected, actual);
        // clear
        lightFixtureService.deleteLightFixture("AppTest8");
    }

    @Test
    void updateProduct9() { // test update light fixture - finish
        // given
        LightFixture lightFixture = lightFixtureService.create("AppTest9", "Lithonia",
                "2X2", "White", 3500, 3000, 80, 91.25f);
        String productToUpdate = "Light Fixture";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("AppTest9");
        fieldAndNewInput.add("Finish");
        String expected = "Matte White";
        fieldAndNewInput.add(expected);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        String actual = lightFixtureService.findLightFixture("AppTest9").getFinish();
        Assert.assertEquals(expected, actual);
        // clear
        lightFixtureService.deleteLightFixture("AppTest9");
    }

    @Test
    void updateProduct10() { // test update light fixture - CCT
        // given
        LightFixture lightFixture = lightFixtureService.create("AppTest10", "Lithonia",
                "2X2", "White", 3500, 3000, 80, 91.25f);
        String productToUpdate = "Light Fixture";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("AppTest10");
        fieldAndNewInput.add("CCT");
        String expectedString = "4000";
        fieldAndNewInput.add(expectedString);
        int expected = Integer.parseInt(expectedString);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        int actual = lightFixtureService.findLightFixture("AppTest10").getColorCCT();
        Assert.assertEquals(expected, actual);
        // clear
        lightFixtureService.deleteLightFixture("AppTest10");
    }
}

// test update light fixture - lumen output
// test update light fixture - quantity
// test update light fixture - price