package pages;

import basic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "[name='name_on_card']")
    private WebElement nameField;

    @FindBy (css = "[name='card_number']")
    private WebElement cardNumberField;

    @FindBy (css = "[name='cvc']")
    private WebElement cvcField;

    @FindBy (css = "[name='expiry_month]")
    private WebElement monthField;

    @FindBy (css = "[name='expiry_year']")
    private WebElement yearField;

    @FindBy (css = "button.submit-button")
    private WebElement confirmButton;

    public PaymentPage checkPaymentPage() {
        try {
            waitForVisibleElement(By.xpath("//li[@class='active' and contains(text(), 'Checkout')]")).isDisplayed();
            return this;
        } catch (Exception e) {
            throw new AssertionError("Открыта не страница оплаты");
        }
    }

    public PaymentPage sendName(String text) {
        nameField.clear();
        nameField.sendKeys(text);
        return this;
    }

    public PaymentPage sendCardNumber(String text) {
        cardNumberField.clear();
        cardNumberField.sendKeys(text);
        return this;
    }

    public PaymentPage sendCVC(String text) {
        cvcField.clear();
        cvcField.sendKeys(text);
        return this;
    }

    public PaymentPage sendMonth(String text) {
        monthField.clear();
        monthField.sendKeys(text);
        return this;
    }

    public PaymentPage sendYear(String text) {
        yearField.clear();
        yearField.sendKeys(text);
        return this;
    }

    public PaymentDonePage clickConfirmButton() {
        waitForClickableElement(confirmButton).click();
        return new PaymentDonePage(getDriver());
    }


}
