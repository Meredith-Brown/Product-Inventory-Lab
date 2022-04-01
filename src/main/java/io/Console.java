package io;

import java.util.ArrayList;
import java.util.Scanner;

public class Console { // TODO - error handling for this class

    public static void printWelcome() {
        System.out.println("**************************************************" + "\n" +
                "***           Welcome and Bienvenue            ***" + "\n" +
                "***                    to                      ***" + "\n" +
                "***          ZipCo Inventory Manager           ***" + "\n" +
                "**************************************************");
    }

    public static String printMainMenu() {
        System.out.println("Please select from one of the following options:" + "\n"
                + "Create New Product" + "\n"
                + "View Existing Products" + "\n"
                + "Update Products" + "\n"
                + "Delete Products" + "\n"
                + "Get Report" + "\n"
                + "Exit");
        String input = getStringInput();
        return input;
    }

    public static String cookieOrLightFixture() {
        System.out.println("Please select the product type:" + "\n"
                + "Cookie" + "\n"
                + "Light Fixture");
        String input = getStringInput();
        return input;
    }

    public static String cookieOrLightFixtureOrAll() {
        System.out.println("Please select the product type:" + "\n"
                + "Cookie" + "\n"
                + "Light Fixture" + "\n"
                + "All Products");
        String input = getStringInput();
        return input;
    }

    public static ArrayList<String> cookieCreationInformation() {
        String[] prompt = {"Name", "Calories", "Does this product contain nuts? True/False",
                "Quantity In Stock", "Price"};
        ArrayList<String> allInputs = new ArrayList<>();
        System.out.println("Please enter the following information about the cookie:");
        for (int i = 0; i < prompt.length; i++) {
            System.out.println(prompt[i]);
            String input = getStringInput();
            allInputs.add(input);
        }
        return allInputs;
    }

    public static ArrayList<String> cookieIngredients() {
        ArrayList<String> ingredients = new ArrayList<>();
        System.out.println("Please list all ingredients, with each ingredient on a new line. Enter " +
                "'done' when complete.");
        String input = getStringInput();
        while (!input.equalsIgnoreCase("done")) {
            ingredients.add(input);
        }
        return ingredients;
    }

    public static ArrayList<String> lightFixtureCreationInformation() {
        String[] prompt = {"Part Number", "Manufacturer", "Type", "Finish", "CCT", "Lumen Output",
                "Quantity In Stock", "Price"};
        ArrayList<String> allInputs = new ArrayList<>();
        System.out.println("Please enter the following information about the light fixture:");
        for (int i = 0; i < prompt.length; i++) {
            System.out.println(prompt[i]);
            String input = getStringInput();
            allInputs.add(input);
        }
        return allInputs;
    }

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
