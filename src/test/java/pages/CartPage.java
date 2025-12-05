package pages;

import basic.base.BasePage;
import component.products.CartProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static final String URL = ("/view_cart");

    @FindBy (xpath = "//a[contains(text(), 'Proceed To Checkout')]")
    private WebElement proceedButton;

    @FindBy (xpath = "//button[contains(@class, 'close-checkout-modal')]")
    private WebElement continueToCartButton;

    @FindBy (xpath = "//div[contains(@class, 'show')]//a[contains(@href, 'login')]")
    private WebElement loginLink;


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


    public List<CartProduct> getAllProductsFromCart(){
        List<WebElement> rows = getDriver().findElements(By.xpath("//tr[@id]"));
        if (rows.isEmpty())
            throw new NullPointerException("В корзине нет товаров");

        return rows.stream()
                .map(row -> new CartProduct(row, getDriver()))
                .collect(Collectors.toList());

    }

    public CartPage clickOnDeleteButton(CartProduct product){
        product.clickOnDeleteButton();
        return this;
    }

}
