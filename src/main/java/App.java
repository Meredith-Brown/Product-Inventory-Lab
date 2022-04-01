import io.Console;
import services.CookieService;
import services.LightFixtureService;

import java.util.ArrayList;

public class App {
    private CookieService cookieService = new CookieService();
    private LightFixtureService lightFixtureService = new LightFixtureService();

    public static void main(String... args) {
        App application = new App();
        Console.printWelcome();
        application.initialize();
    }

    public void initialize() { // TODO - flesh this out
        // application logic here
        // call methods to take user input and interface with services
        String mainMenuInput = Console.printMainMenu();
        if (mainMenuInput.equalsIgnoreCase("Create New Product")) {
            String cookieOrLightFixture = Console.cookieOrLightFixture();
            if (cookieOrLightFixture.equalsIgnoreCase("Cookie")) {
                ArrayList<String> inputs = Console.lightFixtureCreationInformation();
                ArrayList<String> ingredients = Console.cookieIngredients();
                cookieService.create(inputs.get(0), ingredients, Integer.parseInt(inputs.get(1)),
                        Boolean.parseBoolean(inputs.get(2)), Integer.parseInt(inputs.get(3)),
                        Float.parseFloat(inputs.get(4)));
            } else {
                ArrayList<String> allInputs = Console.lightFixtureCreationInformation();
                lightFixtureService.create(allInputs.get(0), allInputs.get(1), allInputs.get(2),
                        allInputs.get(3), Integer.parseInt(allInputs.get(4)),
                        Integer.parseInt(allInputs.get(5)), Integer.parseInt(allInputs.get(6)),
                        Float.parseFloat(allInputs.get(7)));
            }
        } else if (mainMenuInput.equalsIgnoreCase("View Existing Products")) {
            String cookieOrLightFixtureOrAll = Console.cookieOrLightFixtureOrAll();
            // call method
        }
        else if (mainMenuInput.equalsIgnoreCase("Update Products")) {
            String cookieOrLightFixture = Console.cookieOrLightFixture();
            // call method
        }
        else if (mainMenuInput.equalsIgnoreCase("Delete Products")) {
            String cookieOrLightFixture = Console.cookieOrLightFixture();
            // call method
        }
        else if (mainMenuInput.equalsIgnoreCase("Get Report")) {
            String cookieOrLightFixtureOrAll = Console.cookieOrLightFixtureOrAll();
            // call method
        } else {
            // call method to exit
        }

    }

}
