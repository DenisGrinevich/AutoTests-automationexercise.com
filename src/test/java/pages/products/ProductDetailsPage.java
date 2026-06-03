/*
Page Object класс для страницы конкретного товара
 */

package pages.products;

import basic.base.BasePage;
import basic.model.Product;
import basic.tools.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement quantityField;

    @FindBy(css = "button#button-review")
    private WebElement submitReview;

    @FindBy(css = "input#name")
    private WebElement reviewNameField;

    @FindBy(css = "input#email")
    private WebElement reviewEmailField;

    @FindBy(css = "textarea#review")
    private WebElement reviewTextField;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage addProductToCart(){
        WaitUtils.waitForClickableElement(driver,addToCartButton);
        addToCartButton.click();
        WaitUtils.waitForClickableElement(driver,continueShoppingButton);
        continueShoppingButton.click();
        log.info("Товар добавлен в корзину");

        return this;
    }

    public ProductDetailsPage setQuantity(int quantity){
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
        return this;
    }

    public Product parseData() {
        return new Product(Integer.parseInt(WaitUtils.waitForLoadedElement(driver, By.xpath("//input[@id='product_id']")).getAttribute("value")),
        WaitUtils.waitForVisibleElement(driver, By.xpath("//div[@class='product-information']/h2")).getText(),
        Integer.parseInt(WaitUtils.waitForClickableElement(driver, By.xpath("//span/span")).getText().replace("Rs. ", "").trim()));

    }

    public ProductDetailsPage enterReviewName(String name){
        WaitUtils.waitForClickableElement(driver, reviewNameField).clear();
        reviewNameField.sendKeys(name);
        return this;
    }

    public ProductDetailsPage enterReviewEmail(String name){
        WaitUtils.waitForClickableElement(driver, reviewEmailField).clear();
        reviewEmailField.sendKeys(name);
        return this;
    }

    public ProductDetailsPage enterReviewText(String name){
        WaitUtils.waitForClickableElement(driver, reviewTextField).clear();
        reviewTextField.sendKeys(name);
        return this;
    }

    public ProductDetailsPage clickSubmitReview(){
       WaitUtils.waitForClickableElement(driver, submitReview).click();
        return this;
    }

    public boolean isReviewMessageDisplayed(){
        return (WaitUtils.waitForVisibleElement(driver, By.xpath("//div/span[contains(text(), 'Thank you for your review.')]")).isDisplayed());

    }

}
