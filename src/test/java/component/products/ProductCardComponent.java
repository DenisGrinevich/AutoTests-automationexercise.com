package component.products;

/*
Класс для взаимодействия с карточкой товара в листинге
*/

import basic.base.BaseComponent;
import basic.model.Product;
import basic.tools.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.products.ProductDetailsPage;

import java.time.Duration;

@Slf4j
public class ProductCardComponent extends BaseComponent {

    private final WebElement container;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    public ProductCardComponent(WebDriver driver, WebElement container) {
        super(driver);
        this.container = container;
    }

    public void clickOnAddToCartButton() {
        WaitUtils.waitForClickableElement(driver, container.findElement(By.xpath(".//div[@class='overlay-content']/a"))).click();
    }

    public ProductDetailsPage clickOnViewProductButton() {
        WaitUtils.waitForClickableElement(driver, container.findElement(By.className("choose")))
                .click();
        return new ProductDetailsPage(driver);
    }

    public ProductCardComponent addProductsToCart() {
        scrollAndHoverToProduct();
        clickOnAddToCartButton();
        WaitUtils.waitForVisibleElement(driver, continueShoppingButton).click();
        log.info("Товар добавлен в корзину");

        return this;
    }

    public void scrollAndHoverToProduct() {
        Actions actions = new Actions(driver);
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

    public Product parseData() {
        return new Product(
                Integer.parseInt(container.findElement(By.xpath(".//div[@class='productinfo text-center']/a[contains(@class, 'add-to-cart')]")).getAttribute("data-product-id")),
                container.findElement(By.xpath(".//div[@class='productinfo text-center']/p")).getText(),
                Integer.parseInt(container.findElement(By.xpath(".//div[@class='productinfo text-center']/h2")).getText().replace("Rs. ", "").trim())
        );
    }
}
