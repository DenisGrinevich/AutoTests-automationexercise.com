package basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private WebDriver driver;

    protected void startDriver() {
        driver = ChromeUtils.createDriver();

    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void getWeb() {
        driver.get("https://automationexercise.com/");
    }

    private void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeMethod
    protected void beforeMethod() {
        startDriver();
        getWeb();
    }

    @AfterMethod
    protected void afterMethod() {
        closeDriver();
    }


}
