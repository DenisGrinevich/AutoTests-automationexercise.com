package component.products;

import basic.base.BaseProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class ProductsPageProduct extends BaseProduct {
    private final WebElement container;
    private int id;
    private String name;
    private int price;

    public ProductsPageProduct(WebElement container, WebDriver driver) {
        super(driver);
        this.container = container;
        parseData();
    }

    @Override
    protected void parseData() {
        id = Integer.parseInt(container.findElement(By.xpath(".//div[@class='productinfo text-center']/a[contains(@class, 'add-to-cart')]")).getAttribute("data-product-id"));
        name = container.findElement(By.xpath(".//div[@class='productinfo text-center']/p")).getText();
        price = Integer.parseInt(container.findElement(By.xpath(".//div[@class='productinfo text-center']/h2")).getText().replace("Rs. ", "").trim());
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

    public void clickOnAddToCartButton() {
        waitForClickableElement(container.findElement(By.xpath(".//div[@class='overlay-content']/a"))).click();
    }

    public void scrollAndHoverToProduct() {
        Actions actions = new Actions(getDriver());
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'nearest' });",
                container.findElement((By.xpath(
                        ".//div[@class='productinfo text-center']/a"))));

        actions
                .moveToElement(container.findElement(By.xpath(
                        ".//div[@class='productinfo text-center']/a")))
                .pause(Duration.ofMillis(500))
                .perform();
    }
}
