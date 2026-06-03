/*
Page Object класс для промежуточной страницы с сообщением об создании аккаунта
 */

package pages.register;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountCreatedText(){
        return WaitUtils.waitForClickableElement(driver,By.xpath("//*[.='Account Created!']")).getText();

    }
    public HomePage clickContinueButton(){
        WaitUtils.waitForClickableElement(driver,By.cssSelector("[data-qa='continue-button']")).click();
        return new HomePage(driver);
    }
}
