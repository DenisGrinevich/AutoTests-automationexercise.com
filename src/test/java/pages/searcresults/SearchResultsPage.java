package pages.searcresults;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.main.MainPage;

public class SearchResultsPage extends MainPage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    private WebDriver productName;



}
