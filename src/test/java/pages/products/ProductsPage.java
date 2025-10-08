package pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.main.HomePage;

import java.util.List;

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

    public ProductsPage checkAllProductsPage() {
        try {
            getWait10().until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//h2[@class='title text-center'][contains(text(),'All Products')]"))).isDisplayed();
            return this;
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            throw new RuntimeException(e);
        }
    }

    public ProductsPage checkSearchResultPage() {
        try {
            getWait10().until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//h2[@class='title text-center'][contains(text(),'Searched Products')]"))).isDisplayed();
            return this;
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            throw new RuntimeException(e);
        }
    }


    public String checkProductName() {
        return getWait5().until(ExpectedConditions
                        .visibilityOf(productName))
                .getText().trim().toLowerCase();
    }

    public HomePage clickOnHomeButton() {
        waitForClickableElement(homeButton).click();
        return new HomePage(getDriver());

    }


    public boolean checkRequestInProductName(String request) {
        List<String> text = getDriver().findElements(By.xpath("//div[@class='productinfo text-center']/p")).stream()
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
