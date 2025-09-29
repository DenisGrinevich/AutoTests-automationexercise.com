package pages.product;

import basic.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement productName;

    public String checkProductName() {
        return getWait5().until(ExpectedConditions.visibilityOf(productName)).getText().trim().toLowerCase();

    }


}
