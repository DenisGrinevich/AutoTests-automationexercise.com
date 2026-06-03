/*
Page Object класс для промежуточной страницы подтверждения оплаты, в нем элементы и методы для взаимодействия со страницей
 */

package pages.checkout;

import basic.base.BasePage;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;

public class PaymentDonePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Download Invoice')]")
    private WebElement continueButton;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement proceedButton;

    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

    public PaymentDonePage checkPaymentDonePage() {
        try {
            WaitUtils.waitForVisibleElement(driver,By.xpath("//*[.='Order Placed!']")).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new AssertionError("Открыта не страница корзины");
        }
    }

    public HomePage clickContinueButton() {
        WaitUtils.waitForClickableElement(driver,continueButton).click();
        return new HomePage(driver);
    }
}

