package helpers;

import org.openqa.selenium.By;

public class ElementList {
    private final By locator;

    public ElementList(By locator) {
        this.locator = locator;
    }

    public FoundElementList findList() {
        return new FoundElementList(locator);
    }
}