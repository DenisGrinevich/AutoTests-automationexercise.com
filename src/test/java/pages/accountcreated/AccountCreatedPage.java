package pages.accountcreated;

import basic.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.main.HomePage;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountCreatedText(){
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Account Created!']"))).getText();

    }
    public HomePage clickContinueButton(){
        getWait10().until(ExpectedConditions.elementToBeClickable((By.cssSelector("[data-qa='continue-button']")))).click();
        return new HomePage(getDriver());
    }
}
