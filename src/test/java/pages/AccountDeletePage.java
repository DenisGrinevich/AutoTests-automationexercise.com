package pages;

import basic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletePage extends BasePage {
    public AccountDeletePage(WebDriver driver) {
        super(driver);
    }

    public AccountDeletePage checkAccountDeletedPageText() {
        if (!waitForClickableElement(By.xpath("//*[.='Account Deleted!']")).isDisplayed())
            throw new AssertionError("Это не страница удаления аккаунта");

        return this;
    }

    public HomePage clickContinueButton() {
        waitForClickableElement((By.cssSelector("[data-qa='continue-button']"))).click();
        return new HomePage(getDriver());
    }
}
