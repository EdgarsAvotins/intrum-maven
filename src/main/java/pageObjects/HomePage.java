package pageObjects;

import config.TestConfig;
import helpers.Element;
import org.openqa.selenium.By;

import static helpers.BrowserHelper.navigateTo;
//import static helpers.InteractionHelper.*;

public class HomePage {
    private static final String DOMAIN_URL = TestConfig.getDomainUrl();

    private static final Element rejectCookiesButton = new Element(By.id("onetrust-reject-all-handler"));
    private static final Element formButton = new Element(By.xpath("//a[@data-popup-template='popup_ArticlePage']"));
    private static final Element wrongButton = new Element(By.xpath("ugabugaaaaa"));
    private static final Element nameField = new Element(By.xpath("//div[contains(@class,'vārdsuzvārds')]//input"));

    public static void openHomepage() {
        navigateTo(DOMAIN_URL);
    }

    public static void rejectCookies() {
//        el(REJECT_COOKIES_BUTTON_ID).click();
        rejectCookiesButton.click();
    }

    public static void clickFormButton() {
        formButton.scrollIntoView();
        formButton.click();
    }

    public static void clickWrongButton() {
        wrongButton.click();
    }

    public static void fillName(String name) {
        nameField.sendKeys(name);
    }
}
