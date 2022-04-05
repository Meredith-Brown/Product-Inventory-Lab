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
    LightFixtureService lightFixtureService = new LightFixtureService();
    LightFixture lightFixture = lightFixtureService.create("2BLT2Test", "Lithonia",
            "2X2", "White", 3500, 3000, 80, 91.25f);


    // test update cookie - price
    // test update light fixture - part number
    // test update light fixture - manufacturer
    // test update light fixture - type
    // test update light fixture - finish
    // test update light fixture - cct
    // test update light fixture - lumen output
    // test update light fixture - quantity
    // test update light fixture - price

    // product to update, field, new input

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
}