package pages;

import basic.base.BaseProductsPage;
import basic.tools.Logging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BaseProductsPage {

    @FindBy(className = "choose")
    private WebElement viewProductButton;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    protected WebElement homeButton;

    private int amountOfProducts;

    public HomePage(WebDriver driver) {
        super(driver);
        Logging.info("Открыта главная страница");
    }

    @Override
    protected HomePage self() {
        return this;
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
