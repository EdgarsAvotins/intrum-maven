package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserHelper {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void initializeDriver() {
        if (driverThreadLocal.get() == null) {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true); //DEPRECATED?
//            options.addArguments("--headless=new"); // Doesn't work, version too low?
            System.out.println("===INITIALIZING");
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
//            driver = new ChromeDriver();
            driverThreadLocal.set(new FirefoxDriver(options));
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    public static void closeDriver() {
        if (driverThreadLocal.get() != null) {
            System.out.println("===QUITTING");
            driverThreadLocal.get().quit();
            driverThreadLocal.set(null);
        }
    }

//        public void addScreenshotAfterTest(ExtensionContext context) throws Exception {
//        WebDriver driver = BrowserHelper.getDriver();
//        if (driver != null) {
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            saveScreenshot(screenshotFile, context.getDisplayName());
//            attachScreenshotToReport(screenshotFile, context);
//
//            String currentUrl = driver.getCurrentUrl();
//            Allure.addAttachment("Current URL", currentUrl);
//        }
//    }
}