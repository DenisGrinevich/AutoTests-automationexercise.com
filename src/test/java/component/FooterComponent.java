package component;

import basic.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterComponent extends BaseComponent {
    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    protected WebElement subscribeEmailField;

    @FindBy(xpath = "//button[@id='subscribe']")
    protected WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    protected WebElement texAfterSubscribing;

    public FooterComponent verifySubscriptionFormName() {

        try {
            if (waitForVisibleElement(By.xpath("//div[@class='single-widget']/*[contains(text(), 'Subscription')]"))
                    .isDisplayed()){
                return this;
            }
            else {return null;}
        } catch (Exception e) {
            throw new NullPointerException("Название формы \"Subscription\" не отображается на странице ");
        }
    }

    public FooterComponent enterEmailToSubscribe(String email) {
        subscribeEmailField.clear();
        subscribeEmailField.sendKeys(email);
        return this;
    }

    public FooterComponent clickOnSubscribeButton() {
        waitForClickableElement(subscribeButton).click();
        return this;
    }

    public String getTextAfterSubscribing() {
        return waitForVisibleElement(texAfterSubscribing).getText();
    }
}
