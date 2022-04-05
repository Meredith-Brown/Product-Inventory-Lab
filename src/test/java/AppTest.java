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
    Cookie cookie = cookieService.create("Sugar", ingredientsList, 150, false,
            23, 2.00f);
    LightFixtureService lightFixtureService = new LightFixtureService();
    LightFixture lightFixture = lightFixtureService.create("2BLT2", "Lithonia",
            "2X2", "White", 3500, 3000, 80, 91.25f);


    // test update cookie - contains nuts
    // test update cookie - quantity
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
        String productToUpdate = "Cookie";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("Sugar");
        fieldAndNewInput.add("Name");
        String expected = "Sugar - Unfrosted";
        fieldAndNewInput.add(expected);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        String actual = cookieService.findCookie(expected).getName();
        Assert.assertEquals(expected, actual);
        // clear
        cookieService.deleteCookie(expected);
    }

    @Test
    void updateProduct2() { // test update cookie - calories
        // given
        String productToUpdate = "Cookie";
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        fieldAndNewInput.add("Sugar");
        fieldAndNewInput.add("Calories");
        String expectedString = "225";
        fieldAndNewInput.add(expectedString);
        int expected = Integer.parseInt(expectedString);
        // when
        app.updateProduct(productToUpdate, fieldAndNewInput);
        // then
        int actual = cookieService.findCookie("Sugar").getCalories();
        Assert.assertEquals(expected, actual);
        // clear
        cookieService.deleteCookie("Sugar");
    }
}