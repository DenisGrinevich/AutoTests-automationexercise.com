/*
Утилитный класс c явными ожиданиями элементов (видимость, кликабильность, наличие в DOM)
 */

package basic.tools;

import basic.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@Slf4j
public class WaitUtils {

    public static WebDriverWait createWait(WebDriver driver, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public static WebElement waitForClickableElement(WebDriver driver, By locator) {
        try {
            return new WebDriverWait(driver, Config.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            log.error("Элемент {} некликабельный", locator, e);
            throw e;
        }
    }

    public static WebElement waitForClickableElement(WebDriver driver, WebElement element) {
        try {
            return new WebDriverWait(driver,
                    Config.DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            log.error("Элемент {} некликабельный", element, e);
            throw e;
        }
    }

    public static WebElement waitForVisibleElement(WebDriver driver, WebElement element) {
        try {
            return new WebDriverWait(driver, Config.DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            log.error("Элемент {} не видим на странице", element, e);
            throw e;
        }
    }

    public static WebElement waitForVisibleElement(WebDriver driver, By locator) {
        try {
            return new WebDriverWait(driver,
                    Config.DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            log.error("Элемент {} не видим на странице", locator, e);
            throw e;
        }
    }

    public static WebElement waitForLoadedElement(WebDriver driver, By locator) {
        try {
            return new WebDriverWait(driver,
                    Config.DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            log.error("Элемент {} отсутствует в DOM ", locator, e);
            throw e;
        }
    }

    public static void waitForInvisibleElement(WebDriver driver, By locator) {
        try {
            new WebDriverWait(driver,
                    Config.DEFAULT_TIMEOUT).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            log.error("Элемент {}есть на странице", locator,e);
            throw e;
        }
    }
}
