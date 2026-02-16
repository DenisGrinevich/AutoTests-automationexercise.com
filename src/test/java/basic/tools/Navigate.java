package basic.tools;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.checkout.CartPage;
import pages.products.ProductsPage;
import pages.register.LoginPage;

public class Navigate {

    private static final String MAIN_URL = "https://automationexercise.com";

    public static LoginPage toLoginPage(WebDriver driver) {
        driver.navigate().to(MAIN_URL + LoginPage.URL);
        return new LoginPage(driver);
    }

    public static HomePage toHomePage(WebDriver driver) {
        driver.navigate().to(MAIN_URL);
        return new HomePage(driver);
    }

    public static ProductsPage toProductsPage(WebDriver driver) {
        driver.navigate().to(MAIN_URL + ProductsPage.URL);
        return new ProductsPage(driver);
    }

    public static CartPage toCartPage(WebDriver driver) {
        driver.navigate().to(MAIN_URL + CartPage.URL);
        return new CartPage(driver);
    }
}
