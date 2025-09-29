package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public abstract class BaseModel {
    protected WebDriver driver;
    private WebDriverWait wait1;
    private WebDriverWait wait5;
    private WebDriverWait wait10;
//    protected String url;
    public BaseModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public WebDriver getDriver(){
        return driver;

    }
    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            System.out.println("Ожидание - 10 секунд");
        }

        return wait10;
    }
    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            System.out.println("Ожидание - 5 секунд");
        }

        return wait5;
    }
    protected WebDriverWait getWait1() {
        if (wait1 == null) {
            wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(1));
            System.out.println("Ожидание - 1 секунда");
        }

        return wait1;
    }

}
