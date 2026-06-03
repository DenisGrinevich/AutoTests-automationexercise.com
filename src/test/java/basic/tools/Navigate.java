/*
Утилитный класс со статическими методами для навигации по сайту
 */

package basic.tools;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.checkout.CartPage;
import pages.products.ProductsPage;
import pages.register.LoginPage;

import static basic.Config.MAIN_URL;

@Slf4j
public class Navigate {

    public static LoginPage toLoginPage(WebDriver driver) {
        driver.navigate().to(String.format("%s%s", MAIN_URL, LoginPage.URL));
        log.info("Открыта страница логина");
        return new LoginPage(driver);
    }

    public static HomePage toHomePage(WebDriver driver) {
        driver.navigate().to(MAIN_URL);
        log.info("Открыта главная страница");
        return new HomePage(driver);
    }

    public static ProductsPage toProductsPage(WebDriver driver) {
        driver.navigate().to(String.format("%s%s", MAIN_URL, ProductsPage.URL));
        log.info("Открыта страница листинга продуктов");
        return new ProductsPage(driver);
    }

    public static CartPage toCartPage(WebDriver driver) {
        driver.navigate().to(String.format("%s%s", MAIN_URL, CartPage.URL));
        log.info("Открыта страница корзины");
        return new CartPage(driver);
    }

    public void openPage(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

}
