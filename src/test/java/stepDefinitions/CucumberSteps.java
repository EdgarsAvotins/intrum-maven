package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static helpers.BrowserHelper.*;
import static pageObjects.HomePage.*;

public class CucumberSteps {
    @Before
    public static void setup() {
        initializeDriver();
    }

    @Given("I open the page")
    public static void i_open_the_page() throws InterruptedException {
        openHomepage();
        rejectCookies();
        clickFormButton();
        fillName("MrAnderson");
        Thread.sleep(500);
    }

    @Given("I do something else")
    public static void i_do_something_else() {
        clickWrongButton();
    }

    @When("I wait")
    public static void i_wait() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("End");
    }

    @After
    public static void teardown() {
        if (getDriver() != null) {
            closeDriver();
        }
    }
}