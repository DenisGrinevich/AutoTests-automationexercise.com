package pages.base;

import basic.BaseModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static basic.Constants.TimeoutVariable.EXPLICIT_WAIT_FIVE;
import static basic.Constants.Urls.URL_MAIN;

public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        openPage(url);
    }
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {

        return driver.getCurrentUrl();
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT_FIVE).until(ExpectedConditions.visibilityOf(element));
        return element;

    }

}
