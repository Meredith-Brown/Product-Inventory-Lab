package models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LightFixtureTest {

    @Test
    public void constructorTest() {
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
        LightFixture testLightFixture = new LightFixture(expectedPartNumber, expectedManufacturer,
                expectedType, expectedFinish, expectedColorCCT, expectedLumenOutput, expectedQuantity,
                expectedPrice, 1);
        // then
        Assert.assertEquals(expectedPartNumber, testLightFixture.getPartNumber());
        Assert.assertEquals(expectedManufacturer, testLightFixture.getManufacturer());
        Assert.assertEquals(expectedType, testLightFixture.getType());
        Assert.assertEquals(expectedFinish, testLightFixture.getFinish());
        Assert.assertEquals(expectedColorCCT, testLightFixture.getColorCCT());
        Assert.assertEquals(expectedLumenOutput, testLightFixture.getLumenOutput());
        Assert.assertEquals(expectedQuantity, testLightFixture.getQuantity());
        Assert.assertEquals(expectedPrice, testLightFixture.getPrice(), .001);
    }

    @Test
    public void setPartNumberTest() {
        // given
        String expected = "2BLT2-35K-3000-WH";
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setPartNumber(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getPartNumber());
    }

    @Test
    public void setManufacturerTest() {
        // given
        String expected = "Lithonia";
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setManufacturer(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getManufacturer());
    }

    @Test
    public void setTypeTest() {
        // given
        String expected = "2X2";
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setType(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getType());
    }

    @Test
    public void setFinishTest() {
        // given
        String expected = "white";
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setFinish(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getFinish());
    }

    @Test
    public void setColorCCT() {
        // given
        int expected = 3500;
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setColorCCT(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getColorCCT());
    }

    @Test
    public void setLumenOutputTest() {
        // given
        int expected = 3000;
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setLumenOutput(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getLumenOutput());
    }

    @Test
    public void setQuantityTest() {
        // given
        int expected = 6;
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setQuantity(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getQuantity());
    }

    @Test
    public void setPriceTest() {
        // given
        float expected = 91.50f;
        // when
        LightFixture testLightFixture = new LightFixture();
        testLightFixture.setPrice(expected);
        // then
        Assert.assertEquals(expected, testLightFixture.getPrice(), .001);
    }
}