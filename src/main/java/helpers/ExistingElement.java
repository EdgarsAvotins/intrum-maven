package helpers;

import config.TestConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.BrowserHelper.getDriver;

public class ExistingElement {
    private static final Duration DEFAULT_TIMEOUT = TestConfig.getDefaultTimeout();
    private WebElement currentElement;

    public ExistingElement(WebElement element) {
        this.currentElement = element;
    }

    public ExistingElement(By locator) {
        find(locator);
    }

    private void find(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        this.currentElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement getCurrentElement() {
        return currentElement;
    }

    public ExistingElement findNestedElement(By nestedElementLocator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        this.currentElement = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(currentElement, nestedElementLocator));
        return this;
    }

    public ExistingElement click() {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        wait.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
        wait.until(_driver -> {
            currentElement.click();
            return true;
        });
        return this;
    }

    public ExistingElement sendKeys(String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        wait.ignoring(ElementClickInterceptedException.class, ElementNotInteractableException.class);
        wait.until(_driver -> {
            currentElement.sendKeys(text);
            return true;
        });
        return this;
    }

    public ExistingElement scrollIntoView() {
        JavascriptExecutor j = (JavascriptExecutor) getDriver();
        j.executeScript ("arguments[0].scrollIntoView({block: 'center'})", currentElement);
        return this;
    }
}