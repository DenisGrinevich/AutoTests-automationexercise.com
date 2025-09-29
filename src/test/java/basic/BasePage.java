package basic;

import component.HeaderComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public abstract class BasePage extends BaseModel {


    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, String url) {
        super(driver);
        PageFactory.initElements(driver, this);


    }
    public HeaderComponent getHeader() {
        return new HeaderComponent(getDriver());
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


//    public void removeBannerWithJS() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//        try {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", driver.findElement(By.xpath("//ins[@data-ad-status='filled']")));
//            System.out.println("Баннер удален");
//        } catch (NoSuchElementException e) {
//            System.out.println("Рекламный баннер не найден — продолжаем выполнение.");
//        } finally {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        }
//
//    }

}




