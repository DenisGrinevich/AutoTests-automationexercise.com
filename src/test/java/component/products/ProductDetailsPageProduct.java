package component.products;

import basic.base.BaseProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageProduct extends BaseProduct {
    private int id;
    private String name;
    private int price;
    private int quantity;

    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement quantityField;

    public ProductDetailsPageProduct(WebDriver driver) {
        super(driver);
        parseData();
    }

    @Override
    protected void parseData() {
        id = Integer.parseInt(waitForLoadedElement(By.xpath("//input[@id='product_id']")).getAttribute("value"));
        name = waitForVisibleElement(waitForClickableElement(By.xpath("//div[@class='product-information']/h2"))).getText();
        price = Integer.parseInt(waitForClickableElement(By.xpath("//span/span")).getText().replace("Rs. ", "").trim());
        quantity = Integer.parseInt(waitForClickableElement(quantityField).getAttribute("value"));
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        waitForClickableElement(quantityField);
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(quantity));
    }
}