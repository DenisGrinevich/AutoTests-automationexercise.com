/*
Класс для компонента футера, чтобы была возможность вызывать его на любой странице, т.к. он одинаковый для большинства страниц
 */

package component;

import basic.base.BaseComponent;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterComponent extends BaseComponent {

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    protected WebElement subscribeEmailField;

    @FindBy(xpath = "//button[@id='subscribe']")
    protected WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    protected WebElement texAfterSubscribing;

    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    public FooterComponent verifySubscriptionFormName() {

        try {
            WaitUtils.waitForVisibleElement(driver, By.xpath("//div[@class='single-widget']/*[contains(text(), 'Subscription')]"))
                    .isDisplayed();
                return this;
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
        WaitUtils.waitForClickableElement(driver,subscribeButton).click();
        return this;
    }

    public String getTextAfterSubscribing() {
        return WaitUtils.waitForVisibleElement(driver,texAfterSubscribing).getText();
    }
}
