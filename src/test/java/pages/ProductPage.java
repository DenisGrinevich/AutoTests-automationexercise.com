package pages;

import basic.BasePage;
import component.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productName;

    @FindBy(xpath = "//button[contains(@class, 'cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement quantityField;

    @FindBy(xpath="//input[@id='product_id']")
    private WebElement productId;

    @FindBy(xpath="//span/span")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    public String getProductName() {
        return waitForVisibleElement(productName).getText().trim().toLowerCase();
    }

    public ProductPage addProductToCart(){
        waitForClickableElement(addToCartButton);
        addToCartButton.click();
        waitForClickableElement(continueShoppingButton);
        continueShoppingButton.click();
        return this;
    }

    public ProductPage setQuantity(int quantity){
        waitForClickableElement(quantityField);
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
        return this;
    }

    public Product parseProductFromProductPage() {
        int id = Integer.parseInt(productId.getAttribute("value"));
        String name = productName.getText();
        int price = Integer.parseInt(productPrice.getText().replace("Rs. ", "").trim());
        return new Product(getDriver(), id, name, price);
    }
}
