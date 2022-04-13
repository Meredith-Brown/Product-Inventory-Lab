import io.Console;
import models.Cookie;
import models.LightFixture;
import services.CookieService;
import services.LightFixtureService;
import services.ReportGenerator;

import java.io.IOException;
import java.util.ArrayList;

// TODO - BEYOND MVP:
//  - add "return to main menu" option
//  - Create New Product - add "create another product" option
//  - Update Products - add "update another product" option
//  - if cookie or light fixture with same name already exists, prevent creation/ask for new name
//  - implement switch statements to condense code
//  - add a way to update cookie ingredients
//  - add more reports

public class App { // TODO - confirm adequate test coverage
    private CookieService cookieService = CookieService.shared();
    private LightFixtureService lightFixtureService = LightFixtureService.shared();

    public static void main(String... args) throws IOException {
        App application = new App();
        Console.printWelcome();
        application.initialize();
    }

    public void initialize() throws IOException {
        cookieService.loadNextID();
        cookieService.loadCookies();
        lightFixtureService.loadNextID();
        lightFixtureService.loadLightFixtures();
        while (true) {
            String mainMenuInput = Console.printMainMenu();
            if (mainMenuInput.equalsIgnoreCase("Create New Product")) {
                String cookieOrLightFixture = Console.cookieOrLightFixture();
                if (cookieOrLightFixture.equalsIgnoreCase("Cookie")) {
                    ArrayList<String> inputs = Console.cookieCreationInformation();
                    ArrayList<String> ingredients = Console.cookieIngredients();
                    // if cookie with that name already exists, print error
                    cookieService.create(inputs.get(0), ingredients, Integer.parseInt(inputs.get(1)),
                            Boolean.parseBoolean(inputs.get(2)), Integer.parseInt(inputs.get(3)),
                            Float.parseFloat(inputs.get(4)));
                } else {
                    ArrayList<String> allInputs = Console.lightFixtureCreationInformation();
                    // if cookie with that name already exists, print error
                    lightFixtureService.create(allInputs.get(0), allInputs.get(1), allInputs.get(2),
                            allInputs.get(3), Integer.parseInt(allInputs.get(4)),
                            Integer.parseInt(allInputs.get(5)), Integer.parseInt(allInputs.get(6)),
                            Float.parseFloat(allInputs.get(7)));
                }
            } else if (mainMenuInput.equalsIgnoreCase("View Existing Products")) {
                String cookieOrLightFixtureOrAll = Console.cookieOrLightFixtureOrAll();
                if (cookieOrLightFixtureOrAll.equalsIgnoreCase("Cookie")) {
                    Cookie[] allCookies = cookieService.findAllCookies();
                    Console.printAll(allCookies);
                } else if (cookieOrLightFixtureOrAll.equalsIgnoreCase("Light Fixture")) {
                    LightFixture[] allLightFixtures = lightFixtureService.findAllLightFixtures();
                    Console.printAll(allLightFixtures);
                } else {
                    Cookie[] allCookies = cookieService.findAllCookies();
                    Console.printAll(allCookies);
                    LightFixture[] allLightFixtures = lightFixtureService.findAllLightFixtures();
                    Console.printAll(allLightFixtures);
                }
            }
            else if (mainMenuInput.equalsIgnoreCase("Update Products")) {
                String cookieOrLightFixture = Console.cookieOrLightFixture();
                if (cookieOrLightFixture.equalsIgnoreCase("Cookie")) {
                    ArrayList<String> fieldAndNewInput = Console.cookieUpdateInformation();
                    updateProduct(cookieOrLightFixture, fieldAndNewInput);
                } else {
                    ArrayList<String> fieldAndNewInput = Console.lightFixtureUpdateInformation();
                    updateProduct(cookieOrLightFixture, fieldAndNewInput);
                }
            }
            else if (mainMenuInput.equalsIgnoreCase("Delete Products")) {
                String cookieOrLightFixture = Console.cookieOrLightFixture();
                if (cookieOrLightFixture.equalsIgnoreCase("Cookie")) {
                    String cookieToDelete = Console.deleteInput();
                    cookieService.deleteCookie(cookieToDelete);
                } else {
                    String lightFixtureToDelete = Console.deleteInput();
                    lightFixtureService.deleteLightFixture(lightFixtureToDelete);
                }
            }
            else if (mainMenuInput.equalsIgnoreCase("Get Report")) {
                ReportGenerator generator = new ReportGenerator();
                String cookieOrLightFixtureOrAll = Console.cookieOrLightFixtureOrAll();
                int report = Console.requestReportType(cookieOrLightFixtureOrAll);
                switch (report) {
                    case 1: generator.listNutFreeCookies();
                    case 2: generator.getFixturesByType();
                }
            } else {
                cookieService.writeNextIDToFile();
                cookieService.writeJSON();
                lightFixtureService.writeNextIDToFile();
                lightFixtureService.writeJSON();
                break;
            }

        }

    }

    public void updateProduct(String productToUpdate, ArrayList<String> fieldAndNewInput) {
        if (productToUpdate.equalsIgnoreCase("Cookie")) {
            if (fieldAndNewInput.get(1).equalsIgnoreCase("Name")) {
                cookieService.findCookie(fieldAndNewInput.get(0)).setName(fieldAndNewInput.get(2));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Calories")) {
                cookieService.findCookie(fieldAndNewInput.get(0)).setCalories(Integer.parseInt
                        (fieldAndNewInput.get(2)));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Contains Nuts?")) {
                cookieService.findCookie(fieldAndNewInput.get(0)).setContainsNuts(Boolean.parseBoolean
                        (fieldAndNewInput.get(2)));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Quantity In Stock")) {
                cookieService.findCookie(fieldAndNewInput.get(0)).setQuantity(Integer.parseInt
                        (fieldAndNewInput.get(2)));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Price")) {
                cookieService.findCookie(fieldAndNewInput.get(0)).setPrice(Float.parseFloat
                        (fieldAndNewInput.get(2)));
            }
        } else {
            if (fieldAndNewInput.get(1).equalsIgnoreCase("Part Number")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setPartNumber
                        (fieldAndNewInput.get(2));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Manufacturer")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setManufacturer
                        (fieldAndNewInput.get(2));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Type")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setType
                        (fieldAndNewInput.get(2));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Finish")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setFinish
                        (fieldAndNewInput.get(2));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("CCT")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setColorCCT
                        (Integer.parseInt(fieldAndNewInput.get(2)));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Lumen Output")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setLumenOutput
                        (Integer.parseInt(fieldAndNewInput.get(2)));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Quantity In Stock")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setQuantity(Integer.parseInt(fieldAndNewInput.get(2)));
            } else if (fieldAndNewInput.get(1).equalsIgnoreCase("Price")) {
                lightFixtureService.findLightFixture(fieldAndNewInput.get(0)).setPrice(Float.parseFloat(fieldAndNewInput.get(2)));
            }
        }
    }
}
