package pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import basic.BasePage;

import static basic.Constants.Urls.URL_MAIN;

public class MainPage extends BasePage {


    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;

    @FindBy(className = "choose")
    private WebElement viewProductButton;

    public MainPage(WebDriver driver) {
        super(driver, URL_MAIN);
    }


    public MainPage clickOnViewProductButton() {
        viewProductButton.click();

        return this;
    }
}
