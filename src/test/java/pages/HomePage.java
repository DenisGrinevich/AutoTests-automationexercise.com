package pages;

import basic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {

    private int amountOfProducts;

    @FindBy(className = "choose")
    private WebElement viewProductButton;

    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    protected WebElement homeButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage clickOnViewProductButton(int productIndex) {
        waitForClickableElement(chooseProductCard(productIndex))
                .click();
        return new ProductDetailsPage(getDriver());
    }

    private WebElement chooseProductCard(int index) {
        return productCards.get(index - 1)
                .findElement(By.className("choose"));
    }

    public HomePage checkHomePage() {
        if (!waitForVisibleElement(By.xpath("//li[1]/a[@style='color: orange;']")).isDisplayed())
            throw new AssertionError("Это не главная страница");

        return this;
    }

    public boolean isHomepageDisplayed() {
        return waitForVisibleElement(By.xpath("//li[1]/a[@style='color: orange;']")).isDisplayed();

    }




}
