package basic.tools;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class Navigate {

    private static final String MAIN_URL = "https://automationexercise.com";

    public static LoginPage toLoginPage(WebDriver driver) {
        driver.navigate().to(MAIN_URL + LoginPage.URL);
        Logging.info("Открыта страница логина");
        return new LoginPage(driver);
    }

    public static HomePage toHomePage(WebDriver driver) {
        driver.navigate().to(MAIN_URL);
        Logging.info("Открыта главная страница");
        return new HomePage(driver);
    }

    public static ProductsPage toProductsPage(WebDriver driver) {
        driver.navigate().to(MAIN_URL + ProductsPage.URL);
        Logging.info("Открыта страница со всеми продуктами");
        return new ProductsPage(driver);
    }

    public static CartPage toCartPage(WebDriver driver) {
        driver.navigate().to(MAIN_URL + CartPage.URL);
        Logging.info("Открыта страница корзины");
        return new CartPage(driver);
    }
}
