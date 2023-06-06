package helpers;

import config.TestConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static helpers.BrowserHelper.getDriver;

public class FoundElementList {
    private static final Duration DEFAULT_TIMEOUT = TestConfig.getDefaultTimeout();
    private List<WebElement> currentElementList;

    public FoundElementList(By locator) {
        findList(locator);
    }

    private void findList(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_TIMEOUT);
        this.currentElementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public FoundElement get(int index) {
        return new FoundElement(currentElementList.get(index));
    }

    public void forEach(Consumer<FoundElement> action) {
        currentElementList.forEach(element -> {
            FoundElement elementObject = new FoundElement(element);
            action.accept(elementObject);
        });
    }
}