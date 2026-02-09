package pages;

import basic.base.BasePage;
import basic.tools.Logging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        Logging.info("Открыта страница подтверждения создания аккаунта");

    }

    public String getAccountCreatedText(){
        return waitForClickableElement(By.xpath("//*[.='Account Created!']")).getText();

    }
    public HomePage clickContinueButton(){
        waitForClickableElement((By.cssSelector("[data-qa='continue-button']"))).click();
        return new HomePage(getDriver());
    }
}
