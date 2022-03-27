package models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {

    @Test
    public void constructorTest() {
        // given
        String expectedName = "Chocolate Chip";
        List<String> expectedIngredients = new ArrayList<>(Arrays.asList("chocolate chips",
                "flour", "sugar"));
        int expectedCalories = 100;
        boolean expectedContainsNuts = true;
        int expectedQuantity = 50;
        double expectedPrice = 1.50;
        // when
        Cookie testCookie = new Cookie(expectedName, expectedIngredients, expectedCalories,
                expectedContainsNuts, expectedQuantity, expectedPrice);
        // then
        Assert.assertEquals(expectedName, testCookie.getName());
        Assert.assertEquals(expectedIngredients, testCookie.getIngredients());
        Assert.assertEquals(expectedCalories, testCookie.getCalories());
        Assert.assertEquals(expectedContainsNuts, testCookie.getContainsNuts());
        Assert.assertEquals(expectedQuantity, testCookie.getQuantity());
        Assert.assertEquals(expectedPrice, testCookie.getPrice(), .001);
    }

    @Test
    public void setNameTest() {
        // given
        String expected = "Chocolate Chip";
        // when
        Cookie testCookie = new Cookie();
        testCookie.setName(expected);
        // then
        Assert.assertEquals(expected, testCookie.getName());
    }

    @Test
    public void setIngredientsTest() {
        // given
        List<String> expected = new ArrayList<>();
        expected.add("chocolate chips");
        expected.add("flour");
        expected.add("sugar");
        // when
        Cookie testCookie = new Cookie();
        testCookie.setIngredients(expected);
        // then
        Assert.assertEquals(expected, testCookie.getIngredients());
    }

    @Test
    public void setCaloriesTest() {
        // given
        int expected = 100;
        // when
        Cookie testCookie = new Cookie();
        testCookie.setCalories(expected);
        // then
        Assert.assertEquals(expected, testCookie.getCalories());
    }

    @Test
    public void setContainsNutsTest() {
        // given
        boolean expected = true;
        // when
        Cookie testCookie = new Cookie();
        testCookie.setContainsNuts(expected);
        // then
        Assert.assertEquals(expected, testCookie.getContainsNuts());
    }

    @Test
    public void setQuantityTest() {
        // given
        int expected = 50;
        // when
        Cookie testCookie = new Cookie();
        testCookie.setQuantity(expected);
        // then
        Assert.assertEquals(expected, testCookie.getQuantity());
    }

    @Test
    public void setPriceTest() {
        // given
        double expected = 1.50;
        // when
        Cookie testCookie = new Cookie();
        testCookie.setPrice(expected);
        // then
        Assert.assertEquals(expected, testCookie.getPrice(), .001);
    }
}