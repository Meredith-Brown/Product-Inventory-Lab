package services;

import models.LightFixture;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LightFixtureServiceTest {

    @Test
    public void createTest() {
        // given
        String expectedPartNumber = "2BLT2-35K-3000-WH";
        String expectedManufacturer = "Lithonia";
        String expectedType = "2X2";
        String expectedFinish = "white";
        int expectedColorCCT = 3500;
        int expectedLumenOutput = 3000;
        int expectedQuantity = 6;
        float expectedPrice = 91.50f;
        // when
        LightFixtureService lightFixtureService = new LightFixtureService();
        LightFixture testLightFixture = lightFixtureService.create(expectedPartNumber, expectedManufacturer,
                expectedType, expectedFinish, expectedColorCCT, expectedLumenOutput, expectedQuantity,
                expectedPrice);
        String actualPartNumber = testLightFixture.getPartNumber();
        String actualManufacturer = testLightFixture.getManufacturer();
        String actualType = testLightFixture.getType();
        String actualFinish = testLightFixture.getFinish();
        int actualColorCCT = testLightFixture.getColorCCT();
        int actualLumenOutput = testLightFixture.getLumenOutput();
        int actualQuantity = testLightFixture.getQuantity();
        float actualPrice = testLightFixture.getPrice();
        // then
        Assert.assertEquals(expectedPartNumber, actualPartNumber);
        Assert.assertEquals(expectedManufacturer, actualManufacturer);
        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(expectedFinish, actualFinish);
        Assert.assertEquals(expectedColorCCT, actualColorCCT);
        Assert.assertEquals(expectedLumenOutput, actualLumenOutput);
        Assert.assertEquals(expectedQuantity, actualQuantity);
        Assert.assertEquals(expectedPrice, actualPrice, .001);
    }

    @Test
    void findLightFixture() {
        // when
        LightFixtureService lightFixtureService = new LightFixtureService();
        LightFixture lightFixture2X2 = lightFixtureService.create("2BLT2-35K-3000-WH",
                "Lithonia", "2X2", "white",3500, 3000,
                6, 91.50f);
        // then
        Assert.assertEquals(lightFixture2X2,
                lightFixtureService.findLightFixture("2BLT2-35K-3000-WH"));
        Assert.assertEquals(null, lightFixtureService.findLightFixture("2BLT4"));
    }

    @Test
    void findAllLightFixtures() {
        // when
        LightFixtureService lightFixtureService = new LightFixtureService();
        LightFixture lightFixture2X2 = lightFixtureService.create("2BLT2-35K-3000-WH",
                "Lithonia", "2X2", "white",3500, 3000,
                6, 91.50f);
        LightFixture lightFixture2X4 = lightFixtureService.create("2BLT4-35K-5000-WH",
                "Lithonia", "2X4", "white",3500, 5000,
                16, 101.50f);
        LightFixture[] expectedArray = {lightFixture2X2, lightFixture2X4};
        LightFixture[] actualArray = lightFixtureService.findAllLightFixtures();
        // then
        Assert.assertEquals(expectedArray, actualArray);
    }

    @Test
    void deleteLightFixture() {
        // when
        LightFixtureService lightFixtureService = new LightFixtureService();
        LightFixture lightFixture2X2 = lightFixtureService.create("2BLT2-35K-3000-WH",
                "Lithonia", "2X2", "white",3500, 3000,
                6, 91.50f);
        // then
        Assert.assertFalse(lightFixtureService.deleteLightFixture("2BLT4-35K-5000-WH"));
        Assert.assertTrue(lightFixtureService.deleteLightFixture("2BLT2-35K-3000-WH"));
        Assert.assertEquals(0, lightFixtureService.inventory.size());
    }
}