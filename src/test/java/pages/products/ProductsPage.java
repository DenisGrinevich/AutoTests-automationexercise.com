/*
Page Object класс для страницы листинга всех товаров
 */

package pages.products;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import component.ProductsListComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingButton;

    public static final String URL = ("/products");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsListComponent getProductList() {
        return new ProductsListComponent(driver);
    }

    public ProductsPage enterSearchRequest(String searchRequest) {
        WaitUtils.waitForVisibleElement(driver, searchBox)
                .sendKeys(searchRequest.trim().toLowerCase());
        searchButton.click();
        return this;
    }

    public ProductsPage checkAllProductsPage() {
        try {
            WaitUtils.createWait(driver, 10).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//h2[@class='title text-center'][contains(text(),'All Products')]"))).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new NullPointerException("Элемент не найден");
        }
    }

    public ProductsPage checkSearchResultPage() {

        if (!WaitUtils.waitForVisibleElement(driver, By.xpath("//h2[@class='title text-center'][contains(text(),'Searched Products')]")).isDisplayed())
            throw new AssertionError("Текст \"Searched Products\" не найден");

        return this;
    }


    public boolean checkSearchRequestInProductName(String request) {
        List<String> text = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"))
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
