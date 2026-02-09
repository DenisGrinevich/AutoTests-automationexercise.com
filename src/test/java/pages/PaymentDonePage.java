package pages;

import basic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
            waitForVisibleElement(By.xpath("//*[.='Order Placed!']")).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new AssertionError("Открыта не страница корзины");
        }
    }

    public HomePage clickContinueButton() {
        waitForClickableElement(continueButton).click();
        return new HomePage(getDriver());
    }
}

