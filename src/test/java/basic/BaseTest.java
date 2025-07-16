package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver startDriver() {
        driver = ProjectUtils.createDriver();
        return driver;
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
        @BeforeMethod
        protected void beforeMethod (){
            startDriver();
        }

        @AfterMethod
        protected void afterMethod (){
            closeDriver();
        }


    }
