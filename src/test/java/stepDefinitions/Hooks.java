package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static helpers.BrowserHelper.*;
import static pageObjects.FormPage.*;

public class Hooks {
    @Before
    public static void setup() {
        initializeDriver();
    }

    @After
    public static void teardown(Scenario scenario) {
        if (getDriver() != null) {
            addScreenshot(scenario);
            closeDriver();
        }
    }

    private static void addScreenshot(Scenario scenario) {
        WebDriver driver = getDriver();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "SCREENSHOT");
    }
}