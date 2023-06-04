package helpers;

import config.TestConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.BrowserHelper.getDriver;

public class Element {
    private static final Duration DEFAULT_TIMEOUT = TestConfig.getDefaultTimeout();
    private final By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    public WebElement find() {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click() {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        wait.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
        wait.until(_driver -> {
            find().click();
            return true;
        });
    }

    public void sendKeys(String text) {
        find().sendKeys(text);
    }

    public void scrollIntoView() {
        JavascriptExecutor j = (JavascriptExecutor) getDriver();
        j.executeScript ("arguments[0].scrollIntoView({block: 'center'})", find());
    }
}