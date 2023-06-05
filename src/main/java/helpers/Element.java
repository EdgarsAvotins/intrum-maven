package helpers;

import org.openqa.selenium.By;

public class Element {
    private final By locator;

    public Element(By locator) {
        this.locator = locator;
    }

    public ExistingElement find() {
        return new ExistingElement(locator);
    }

    public ExistingElement findNestedElement(By nestedLocator) {
        return new ExistingElement(locator).findNestedElement(nestedLocator);
    }
}