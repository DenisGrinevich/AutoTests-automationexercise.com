/*
Page Object класс для страницы корзины, в нем элементы и методы для взаимодействия со страницей
 */

package pages.checkout;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import component.products.CartProductComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.register.LoginPage;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CartPage extends BasePage {

    public static final String URL = ("/view_cart");

    @FindBy(xpath = "//a[contains(text(), 'Proceed To Checkout')]")
    private WebElement proceedButton;

    @FindBy(xpath = "//button[contains(@class, 'close-checkout-modal')]")
    private WebElement continueToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'show')]//a[contains(@href, 'login')]")
    private WebElement loginLink;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage checkCartPage() {
        try {
            WaitUtils.waitForVisibleElement(driver, By.xpath("//a[@href='/view_cart' and @style='color: orange;']")).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new AssertionError("Открыта не страница корзины");
        }
    }

    public CartPage clickProceedButton() {
        WaitUtils.waitForClickableElement(driver,proceedButton).click();
        return this;
    }

    public LoginPage clickLoginLink() {
        WaitUtils.waitForClickableElement(driver, loginLink).click();
        return new LoginPage(driver);
    }

    public List<CartProductComponent> getAllProductsFromCart() {
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@id]"));
        if (rows.isEmpty())
            throw new NullPointerException("В корзине нет товаров");

        return rows.stream()
                .map(row -> new CartProductComponent(row, driver))
                .toList();
    }

    public CartPage removeProduct(int productId) {
        CartProductComponent product = getAllProductsFromCart().stream()
                .filter(p -> p.parseData().getId() == productId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Товар с id=" + productId + " не найден в корзине"));
        product.clickOnDeleteButton();
        WaitUtils.waitForInvisibleElement(driver,(By.id("product-" + productId)));
        log.info("Товар с id = {} удален из корзины", productId);
        return this;
    }

    public boolean isProductInCart(int productId) {
        return getAllProductsFromCart()
                .stream()
                .anyMatch(p -> p.parseData().getId() == productId);
    }
}
