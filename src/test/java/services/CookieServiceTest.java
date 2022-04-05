package services;

import models.Cookie;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CookieServiceTest {
    CookieService cookieService = CookieService.shared();

    @Test
    public void createTest() {
        // given
        String expectedName = "Chocolate Chip";
        List<String> expectedIngredients = new ArrayList<>(Arrays.asList("chocolate chips",
                "flour", "sugar"));
        int expectedCalories = 100;
        boolean expectedContainsNuts = true;
        int expectedQuantity = 50;
        float expectedPrice = 1.50f;
        // when
        Cookie testCookie = cookieService.create(expectedName, expectedIngredients, expectedCalories,
                expectedContainsNuts, expectedQuantity, expectedPrice);
        String actualName = testCookie.getName();
        List<String> actualIngredients = testCookie.getIngredients();
        int actualCalories = testCookie.getCalories();
        boolean actualContainsNuts = testCookie.getContainsNuts();
        int actualQuantity = testCookie.getQuantity();
        float actualPrice = testCookie.getPrice();
        // then
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedIngredients, actualIngredients);
        Assert.assertEquals(expectedCalories, actualCalories);
        Assert.assertEquals(expectedContainsNuts, actualContainsNuts);
        Assert.assertEquals(expectedQuantity, actualQuantity);
        Assert.assertEquals(expectedPrice, actualPrice, .001);
        // clear
        cookieService.getInventory().clear();
    }

    @Test
    void findCookie() {
        // given
        List<String> ingredientsCC = new ArrayList<>(Arrays.asList("chocolate chips",
                "flour", "sugar"));
        List<String> ingredientsPB = new ArrayList<>(Arrays.asList("flour", "sugar", "peanut butter"));
        // when
        Cookie cookiePeanutButter = cookieService.create("peanut butter",
                ingredientsPB, 105, true, 40, 1.50f);
        // then
        Assert.assertEquals(cookiePeanutButter, cookieService.findCookie("peanut butter"));
        Assert.assertEquals(null, cookieService.findCookie("sugar"));
        // clear
        cookieService.getInventory().clear();
    }

    @Test
    void findAllCookies() {
        // given
        List<String> ingredientsCC = new ArrayList<>(Arrays.asList("chocolate chips",
                "flour", "sugar"));
        List<String> ingredientsPB = new ArrayList<>(Arrays.asList("flour", "sugar", "peanut butter"));
        // when
        Cookie cookieChocolateChip = cookieService.create("chocolate chip",
                ingredientsCC, 100, true, 50, 1.50f);
        Cookie cookiePeanutButter = cookieService.create("peanut butter",
                ingredientsPB, 105, true, 40, 1.50f);
        Cookie[] expectedArray = {cookieChocolateChip, cookiePeanutButter};
        Cookie[] actualArray = cookieService.findAllCookies();
        // then
        Assert.assertEquals(expectedArray, actualArray);
        // clear
        cookieService.getInventory().clear();
    }

    @Test
    void deleteCookie() {
        // given
        List<String> ingredientsCC = new ArrayList<>(Arrays.asList("chocolate chips",
                "flour", "sugar"));
        List<String> ingredientsPB = new ArrayList<>(Arrays.asList("flour", "sugar", "peanut butter"));
        // when
        Cookie cookiePeanutButter = cookieService.create("peanut butter",
                ingredientsPB, 105, true, 40, 1.50f);
        // then
        Assert.assertFalse(cookieService.deleteCookie("sugar"));
        Assert.assertTrue(cookieService.deleteCookie("peanut butter"));
        Assert.assertEquals(0, cookieService.getInventory().size());
        // clear
        cookieService.getInventory().clear();
    }
}