/*
Page Object класс для промежуточной страницы с сообщением об удалении аккаунта
 */

package pages.register;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class AccountDeletePage extends BasePage {
    public AccountDeletePage(WebDriver driver) {
        super(driver);
    }

    public AccountDeletePage checkAccountDeletedPageText() {
        if (!WaitUtils.waitForClickableElement(driver, By.xpath("//*[.='Account Deleted!']")).isDisplayed())
            throw new AssertionError("Это не страница удаления аккаунта");

        return this;
    }

    public HomePage clickContinueButton() {
        WaitUtils.waitForClickableElement(driver, By.cssSelector("[data-qa='continue-button']")).click();
        return new HomePage(driver);
    }
}
