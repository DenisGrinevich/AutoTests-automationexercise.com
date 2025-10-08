package pages.main;

import basic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.product.ProductPage;

import java.util.List;


public class HomePage extends BasePage {
    private int amountOfProducts;

    @FindBy(className = "choose")
    private WebElement viewProductButton;

    @FindBy(xpath = "//div[@class='features_items']//div[@class='product-image-wrapper']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    protected WebElement homeButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage(WebDriver driver, String url) {
        super(driver, url);
    }

    public ProductPage clickOnViewProductButton(int productIndex) {
        waitForClickableElement(chooseProductButton(productIndex))
                .click();
        return new ProductPage(getDriver());
    }

    private WebElement chooseProductButton(int index) {
        return listOfProducts.get(index - 1)
                .findElement(By.className("choose"));
    }

    public HomePage checkHomePage() {
        try {
            getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]/a[@style='color: orange;']"))).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public HomePage login(String email, String password) {
        getHeader()
                .clickSignupLoginButton()
                .enterLogin(email).enterPassword(password)
                .clickLoginButton()
                .checkHomePage();
        return this;
    }


//    private int getAmountOfProducts() {
//        return listOfProducts.size();
//    }


}
