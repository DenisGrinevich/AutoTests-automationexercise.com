package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.main.HomePage;

public class ProductsPage extends HomePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    private WebElement productName;

    public ProductsPage enterProductName(String searchRequest) {
        getWait5().until(ExpectedConditions.visibilityOf(searchBox))
                .sendKeys(searchRequest.trim().toLowerCase());
        searchButton.click();
        return this;
    }

    public String checkProductsListName() {
        return getWait5().until(ExpectedConditions
                .visibilityOf(productName))
                .getText().trim().toLowerCase();
    }
    public HomePage clickOnHomeButton() {
        getWait10().until(ExpectedConditions
                        .elementToBeClickable(homeButton))
                .click();
        return new HomePage(getDriver());

    }

}
