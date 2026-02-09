package pages;

import basic.base.BasePage;
import component.products.ProductDetailsPageProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    private List<ProductDetailsPageProduct> addedProducts = new ArrayList<>();

    ProductDetailsPageProduct product = new ProductDetailsPageProduct(getDriver());

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage addProductToCart(){
        waitForClickableElement(addToCartButton);
        addToCartButton.click();
        waitForClickableElement(continueShoppingButton);
        continueShoppingButton.click();
        addedProducts.add(product);
        return this;
    }

    public List<ProductDetailsPageProduct> getProductAddedToCart() {
        if (addedProducts.get(0) == null)
            throw new IllegalStateException("Нет товаров в корзине");

        return addedProducts;
    }

    public ProductDetailsPage setQuantity(int quantity){
        product.setQuantity(quantity);
        return this;
    }


}
