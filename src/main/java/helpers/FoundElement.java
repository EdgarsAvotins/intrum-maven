package helpers;

import config.TestConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.BrowserHelper.getDriver;

public class FoundElement {
    private static final Duration DEFAULT_TIMEOUT = TestConfig.getDefaultTimeout();
    private WebElement currentElement;

    public FoundElement(WebElement element) {
        this.currentElement = element;
    }

    public FoundElement(By locator) {
        find(locator);
    }

    private void find(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        this.currentElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement getAsSeleniumWebElement() {
        return currentElement;
    }

    public FoundElement findNestedElement(By nestedElementLocator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        this.currentElement = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(currentElement, nestedElementLocator));
        return this;
    }

    public FoundElement click() {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        wait.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
        wait.until(_driver -> {
            currentElement.click();
            return true;
        });
        return this;
    }

    public FoundElement sendKeys(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        wait.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
        wait.until(_driver -> {
            currentElement.sendKeys(text);
            return true;
        });
        return this;
    }

    public FoundElement scrollIntoView() {
        JavascriptExecutor j = (JavascriptExecutor) getDriver();
        j.executeScript ("arguments[0].scrollIntoView({block: 'center'})", currentElement);
        return this;
    }

    public FoundElement validateIsVisible() {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(currentElement));
        return this;
    }

    public FoundElement validateIsRGBColor(String rgb) {
        String actualHex = getAsSeleniumWebElement().getCssValue("color");
        assert(rgb.equals(actualHex));
        return this;
    }
}