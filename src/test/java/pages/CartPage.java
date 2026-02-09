package pages;

import basic.base.BasePage;
import basic.tools.Logging;
import component.products.CartProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


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
        Logging.info("Открыта страница корзины");
    }

    public CartPage checkCartPage() {
        try {
            waitForVisibleElement(By.xpath("//a[@href='/view_cart' and @style='color: orange;']")).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new AssertionError("Открыта не страница корзины");
        }
    }

    public CartPage clickProceedButton() {
        waitForClickableElement(proceedButton).click();
        return this;
    }

    public LoginPage clickLoginlink() {
        waitForClickableElement(loginLink).click();
        return new LoginPage(getDriver());
    }


    public List<CartProduct> getAllProductsFromCart() {
        List<WebElement> rows = getDriver().findElements(By.xpath("//tr[@id]"));
        if (rows.isEmpty())
            throw new NullPointerException("В корзине нет товаров");

        return rows.stream()
                .map(row -> new CartProduct(row, getDriver()))
                .collect(Collectors.toList());
    }

    public CartPage removeProduct(int productId) {
        CartProduct product = getAllProductsFromCart().stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Товар с id=" + productId + " не найден в корзине"));
        product.clickOnDeleteButton();
        waitForInvisibleElement((By.id("product-" + productId)));
        Logging.info("Товар с id = " + productId + " удален из корзины");
        return this;
    }

    public boolean isProductInCart(int productId) {
        return getAllProductsFromCart()
                .stream()
                .anyMatch(p -> p.getId() == productId);
    }
}
