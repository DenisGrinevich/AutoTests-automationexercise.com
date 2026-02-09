package basic.base;

import basic.ChromeUtils;
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

    private void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod() {
        startDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        closeDriver();
    }

}
