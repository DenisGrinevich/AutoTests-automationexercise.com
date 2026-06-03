/*
Page Object класс для главной страницы
 */

package pages;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import component.ProductsListComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public ProductsListComponent productList;

    @FindBy(className = "choose")
    private WebElement viewProductButton;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    protected WebElement homeButton;

    private int amountOfProducts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductsListComponent getProductList(){
        return new ProductsListComponent(driver);
    }

    public HomePage checkHomePage() {
        if (!WaitUtils.waitForVisibleElement(driver, By.xpath("//li[1]/a[@style='color: orange;']")).isDisplayed())
            throw new AssertionError("Это не главная страница");

        return this;
    }

    public boolean isHomepageDisplayed() {
        return WaitUtils.waitForVisibleElement(driver,By.xpath("//li[1]/a[@style='color: orange;']")).isDisplayed();
    }

}
