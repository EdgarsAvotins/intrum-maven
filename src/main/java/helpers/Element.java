package helpers;

import org.openqa.selenium.By;

public class Element {
    private final By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    public FoundElement find() {
        return new FoundElement(locator);
    }

    public FoundElement findNestedElement(By nestedLocator) {
        return new FoundElement(locator).findNestedElement(nestedLocator);
    }
}