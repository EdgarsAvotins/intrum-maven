package pageObjects;

import config.TestConfig;
import helpers.Element;
import org.openqa.selenium.By;

import static helpers.BrowserHelper.navigateTo;
//import static helpers.InteractionHelper.*;

public class FormPage {
    private static final String DOMAIN_URL = TestConfig.getDomainUrl();

    private static final Element rejectCookiesButton = new Element(By.id("onetrust-reject-all-handler"));
    private static final Element formButton = new Element(By.xpath("//a[@data-popup-template='popup_ArticlePage']"));
    private static final Element nameFieldBox = new Element(By.xpath("//div[contains(@class,'vārdsuzvārds')]"));
    private static final Element personalCodeFieldBox = new Element(By.xpath("//div[contains(@class,'personaskods')]"));
    private static final Element issueNumberFieldBox = new Element(By.xpath("//div[contains(@class,'lietasnumursnavobligāts')]"));
    private static final Element contactNumberFieldBox = new Element(By.xpath("//div[contains(@class,'kontakttālrunis')]"));
    private static final Element emailAddressFieldBox = new Element(By.xpath("//div[contains(@class,'epastaadrese')]"));
    private static final Element personalAddressFieldBox = new Element(By.xpath("//div[contains(@class,'adrese')]"));
    private static final Element commentFieldBox = new Element(By.xpath("//div[contains(@class,'komentāraiebildumubūtība')]"));
    private static final Element answerThroughOptionsBox = new Element(By.xpath("//div[contains(@class,'kāvēlossaņemtatbildi')]"));
//    private static final Element answerThroughEmailDropdownButton = new Element(By.xpath("//div[contains(@class,'kāvēlossaņemtatbildi')]//select//option[@value='E-pasts']"));

    //div[@class="umbraco-forms-page"]//div[contains(@class,"umbraco-forms-container")]/div[not(contains(@class,"lietasnumursnavobligāts"))]//span[@class="field-validation-error"]

    public static void openHomepage() {
        navigateTo(DOMAIN_URL);
    }

    public static void rejectCookies() {
        rejectCookiesButton.find().click();
    }

    public static void clickFormButton() {
        formButton.find().scrollIntoView().click();
    }

    public static void fillName(String inputText) {
        nameFieldBox.findNestedElement(By.tagName("input")).sendKeys(inputText);
    }

    public static void fillPersonalCodeField(String inputText) {
        personalCodeFieldBox.findNestedElement(By.tagName("input")).sendKeys(inputText);
    }

    public static void fillIssueNumberField(String inputText) {
        issueNumberFieldBox.findNestedElement(By.tagName("input")).sendKeys(inputText);
    }

    public static void fillContactNumberField(String inputText) {
        contactNumberFieldBox.findNestedElement(By.tagName("input")).sendKeys(inputText);
    }

    public static void fillEmailAddressField(String inputText) {
        emailAddressFieldBox.findNestedElement(By.tagName("input")).sendKeys(inputText);
    }

    public static void fillPersonalAddressField(String inputText) {
        personalAddressFieldBox.findNestedElement(By.tagName("input")).sendKeys(inputText);
    }

    public static void fillCommentField(String inputText) {
        commentFieldBox.findNestedElement(By.tagName("textarea")).sendKeys(inputText);
    }

    public static void chooseAnswerOptionEmail() {
        answerThroughOptionsBox.find().click();
        answerThroughOptionsBox.findNestedElement(By.xpath(".//select//option[@value='E-pasts']")).click();
    }
}
