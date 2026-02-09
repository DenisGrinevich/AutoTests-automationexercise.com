package pages;

import basic.base.BaseProductsPage;
import basic.tools.Logging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BaseProductsPage<ProductsPage> {

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    public static final String URL = ("/products");

    public ProductsPage(WebDriver driver) {
        super(driver);
        Logging.info("Открыта страница со всеми продуктами");
    }

    @Override
    protected ProductsPage self() {
        return this;
    }

    public ProductsPage enterProductName(String searchRequest) {
        waitForVisibleElement(searchBox)
                .sendKeys(searchRequest.trim().toLowerCase());
        searchButton.click();
        return this;
    }

    public ProductsPage checkAllProductsPage() {
        try {
            getWait().until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//h2[@class='title text-center'][contains(text(),'All Products')]"))).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new NullPointerException("Элемент не найден");
        }
    }

    public ProductsPage checkSearchResultPage() {

        if (!waitForVisibleElement(By.xpath("//h2[@class='title text-center'][contains(text(),'Searched Products')]")).isDisplayed())
            throw new AssertionError("Текст \"Searched Products\" не найден");

        return this;
    }


    public boolean checkSearchRequestInProductName(String request) {
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

}
