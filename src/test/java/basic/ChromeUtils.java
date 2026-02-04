package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeUtils {
    public static WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--window-size=1540,900");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        return driver;
    }
}
