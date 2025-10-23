package pages.products;

import basic.BasePage;
import component.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='overlay-content']/a")
    private WebElement addToCartOverlayButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']/a")
    private WebElement addCartButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    private List<WebElement> productCards;


    public ProductsPage enterProductName(String searchRequest) {
        waitForVisibleElement(searchBox)
                .sendKeys(searchRequest.trim().toLowerCase());
        searchButton.click();
        return this;
    }

    public ProductsPage checkAllProductsPage() {
        try {
            getWait10().until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//h2[@class='title text-center'][contains(text(),'All Products')]"))).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new NullPointerException("Элемент не найден");
        }
    }

    public ProductsPage checkSearchResultPage() {
        try {
            if (waitForVisibleElement(By.xpath("//h2[@class='title text-center'][contains(text(),'Searched Products')]")).isDisplayed()) {
                return this;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new NullPointerException("Текст \"Searched Products\" не найден");
        }
    }

    public String checkProductName() {
        return getWait5().until(ExpectedConditions
                        .visibilityOf(productName))
                .getText().trim().toLowerCase();
    }

    public boolean checkRequestInProductName(String request) {
        List<String> text = getDriver().findElements(By.xpath("//div[@class='productinfo text-center']/p"))
                .stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .toList();

        if (text.stream().allMatch(name -> name.contains(request.toLowerCase()))) {
            return true;
        } else {
            return false;
        }
    }

    public int PRODUCTS_QUANTITY;

    public List<WebElement> getAllProductsWebElementsFromPage() {
        return productCards;
    }


    public List<WebElement> getProductsWebElementsFromPage() {
        List<WebElement> list = new ArrayList<>();
        for (int i = 0; i <= PRODUCTS_QUANTITY - 1; i++) {
            list.add(i, getAllProductsWebElementsFromPage().get(i));
        }
        return list;
    }

    //
    public ProductsPage addProductToCart(int x) {
        PRODUCTS_QUANTITY = x;
        Actions actions = new Actions(getDriver());
        for (WebElement element : getProductsWebElementsFromPage()) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'nearest' });",
                    element.findElement((By.xpath(".//div[@class='productinfo text-center']/a"))));
            actions
                    .moveToElement(element.findElement(By.xpath(".//div[@class='productinfo text-center']/a")))
                    .pause(Duration.ofSeconds(1))
                    .perform();
            waitForVisibleElement(element.findElement(By.xpath(".//div[@class='overlay-content']/a"))).click();
            waitForVisibleElement(continueShoppingButton).click();
        }
        return this;
    }

    public List<Product> getProductsAddedToCart() {
        System.out.println("Товары в корзине");
        return getProductsWebElementsFromPage().stream().map(this::productParserOnProductsPage).toList();
    }


    public Product productParserOnProductsPage(WebElement element) {
        int id = Integer.parseInt(element.findElement(By.xpath(".//div[@class='productinfo text-center']/a[contains(@class, 'add-to-cart')]")).getAttribute("data-product-id"));
        String name = element.findElement(By.xpath(".//div[@class='productinfo text-center']/p")).getText();
        int price = Integer.parseInt(element.findElement(By.xpath(".//div[@class='productinfo text-center']/h2")).getText().replace("Rs. ", "").trim());
        return new Product(getDriver(), id, name, price);
    }

    public WebElement getProduct(int i) {
        return getAllProductsWebElementsFromPage().get(i);
    }


    //    public ProductsPage clickContinueShoppingButton() {
//        waitForVisibleElement(continueShoppingButton).click();
//        return this;
//    }

}
