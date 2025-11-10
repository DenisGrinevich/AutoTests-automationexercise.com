package basic;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BaseModel {
    protected WebDriver driver;
    private WebDriverWait wait;


    public BaseModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebDriver getDriver() {
        return driver;

    }


    protected WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }
        return wait;
    }

    public WebElement waitForClickableElement(By locator) {
        try {
            return getWait().until(ExpectedConditions.elementToBeClickable(locator));
        } catch (NoSuchElementException | TimeoutException e) {
            Logging.error("Элемент " + locator + " не найден");
            return null;
        }
    }

    public WebElement waitForClickableElement(WebElement element) {
        try {
            return getWait().until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException | TimeoutException e) {
            Logging.error("Элемент " + element + " не найден");
            return null;
        }
    }

    public WebElement waitForVisibleElement(WebElement element) {
        try {
            return getWait().until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException e) {
            Logging.error("Элемент " + element + " не найден");
            return null;
        }
    }

    public WebElement waitForVisibleElement(By locator) {
        try {
            return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException e) {
            Logging.error("Элемент " + locator + " не найден");
            return null;
        }
    }
}
