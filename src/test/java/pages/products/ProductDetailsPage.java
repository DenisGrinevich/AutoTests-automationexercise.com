package pages.products;

import basic.base.BasePage;
import component.products.ProductDetailsPageProduct;
import org.openqa.selenium.By;
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

    @FindBy(css = "button#button-review")
    private WebElement submitReview;

    @FindBy(css = "input#name")
    private WebElement reviewNameField;

    @FindBy(css = "input#email")
    private WebElement reviewEmailField;

    @FindBy(css = "textarea#review")
    private WebElement reviewTextField;

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

    public ProductDetailsPage enterReviewName(String name){
        waitForClickableElement(reviewNameField).clear();
        reviewNameField.sendKeys(name);
        return this;
    }

    public ProductDetailsPage enterReviewEmail(String name){
        waitForClickableElement(reviewEmailField).clear();
        reviewEmailField.sendKeys(name);
        return this;
    }

    public ProductDetailsPage enterReviewText(String name){
        waitForClickableElement(reviewTextField).clear();
        reviewTextField.sendKeys(name);
        return this;
    }

    public ProductDetailsPage clickSubmitReview(){
        waitForClickableElement(submitReview).click();
        return this;
    }

    public boolean isReviewMessageDisplayed(){
        return (waitForVisibleElement(By.xpath("//div/span[contains(text(), 'Thank you for your review.')]")).isDisplayed());

    }


}
