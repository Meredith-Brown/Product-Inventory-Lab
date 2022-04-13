package io;

import models.Cookie;
import models.LightFixture;

import java.util.ArrayList;
import java.util.Scanner;

public class Console<T> { // TODO - error handling for this class

    public static void printWelcome() {
        System.out.println("**************************************************" + "\n" +
                "***           Welcome and Bienvenue            ***" + "\n" +
                "***                    to                      ***" + "\n" +
                "***          ZipCo Inventory Manager           ***" + "\n" +
                "**************************************************" + "\n");
    }

    public static String printMainMenu() {
        System.out.println("Please select from one of the following options:" + "\n"
                + "Create New Product" + "\n"
                + "View Existing Products" + "\n"
                + "Update Products" + "\n"
                + "Delete Products" + "\n"
                + "Get Report" + "\n"
                + "Exit" + "\n");
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
        while (true) {
            String input = getStringInput();
            if (input.equalsIgnoreCase("done")) {
                break;
            } else {
                ingredients.add(input);
            }
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

    public static <T> void printAll(T[] array) {
        String product = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Cookie) {
                product = ((Cookie) array[i]).getName();
            } else if (array[i] instanceof LightFixture) {
                product = ((LightFixture) array[i]).getPartNumber();
            }
            System.out.println(product + "\n");
        }
    }

    public static ArrayList<String> cookieUpdateInformation() {
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        System.out.println("Please enter the name of the cookie you would like to update:");
        String input = getStringInput();
        fieldAndNewInput.add(input);
        System.out.println("Please enter the field you would like to update: Name, Calories, " +
                "Contains Nuts?, Quantity In Stock, Price");
        input = getStringInput();
        fieldAndNewInput.add(input);
        if (input.equalsIgnoreCase("Name")) {
            System.out.println("Enter name:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Calories")) {
            System.out.println("Enter calories:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Contains Nuts?")) {
            System.out.println("Enter True or False:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Quantity In Stock")) {
            System.out.println("Enter quantity:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Price")) {
            System.out.println("Enter price:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        }
        return fieldAndNewInput;
    }

    public static ArrayList<String> lightFixtureUpdateInformation() {
        ArrayList<String> fieldAndNewInput = new ArrayList<>();
        System.out.println("Please enter the name of the light fixture you would like to update:");
        String input = getStringInput();
        fieldAndNewInput.add(input);
        System.out.println("Please enter the field you would like to update: Part Number, Manufacturer, " +
                "Type, Finish, CCT, Lumen Output, Quantity In Stock, Price");
        input = getStringInput();
        fieldAndNewInput.add(input);
        if (input.equalsIgnoreCase("Part Number")) {
            System.out.println("Enter part number:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Manufacturer")) {
            System.out.println("Enter manufacturer:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Type")) {
            System.out.println("Enter type:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Finish")) {
            System.out.println("Enter finish:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("CCT")) {
            System.out.println("Enter CCT:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Lumen Output")) {
            System.out.println("Enter lumen output:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Quantity In Stock")) {
            System.out.println("Enter quantity:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        } else if (input.equalsIgnoreCase("Price")) {
            System.out.println("Enter price:");
            input = getStringInput();
            fieldAndNewInput.add(input);
        }
        return fieldAndNewInput;
    }

    public static int requestReportType(String string) {
        if (string.equalsIgnoreCase("Cookie")) {
            System.out.println("Select report type: 'List Nut-Free Cookies'");
        } else if (string.equalsIgnoreCase("Light Fixture")) {
            System.out.println("Select report type: 'Get Fixtures By Type'");
        }
        String input = getStringInput();
        String completeInput = (string + ", " + input);
        switch (completeInput) {
            case "Cookie, List Nut-Free Cookies": return 1;
            case "Light Fixture, Get Fixtures By Type": return 2;
        }
        return 0;
    }

    public static String deleteInput() {
        System.out.println("Please enter the name of the product you would like to delete:");
        String input = getStringInput();
        return input;
    }

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
