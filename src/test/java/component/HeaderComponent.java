/*
Класс для компонента хедера, чтобы была возможность вызывать его на любой странице, т.к. он одинаковый для большинства страниц
 */

package component;

import basic.base.BaseComponent;
import basic.model.User;
import basic.tools.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TestCasesPage;
import pages.checkout.CartPage;
import pages.products.ProductsPage;
import pages.register.AccountDeletePage;
import pages.register.LoginPage;

public class HeaderComponent extends BaseComponent {

    @FindBy(css = "i.fa.fa-home")
    protected WebElement homeButton;

    @FindBy(css = "i.material-icons.card_travel")
    protected WebElement productsButton;

    @FindBy(xpath = "//a[@href='/login']")
    protected WebElement loginButton;

    @FindBy(xpath = "//a[@href='/logout']")
    protected WebElement logoutButton;

    @FindBy(xpath = "//a[@href='/delete_account']")
    protected WebElement deleteAccountButton;

    @FindBy(xpath = "//a[@href='/contact_us']")
    protected WebElement contactUsButton;

    @FindBy(xpath = "//a[@href='/test_cases']")
    public WebElement testCasesButton;

    @FindBy(xpath = "//a[@href='/view_cart']")
    protected WebElement cartButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public HomePage clickSiteLogo() {
        WaitUtils.waitForClickableElement(driver, By.xpath(("//div[@class='logo pull-left']"))).click();
        return new HomePage(driver);
    }

    public ProductsPage clickProductsButton() {
        WaitUtils.waitForClickableElement(driver, productsButton).click();
        return new ProductsPage(driver);
    }

    public HomePage clickHomeButton() {
        WaitUtils.waitForClickableElement(driver, homeButton).click();
        return new HomePage(driver);

    }

    public CartPage clickCartButton() {
        WaitUtils.waitForClickableElement(driver,cartButton).click();
        return new CartPage(driver);
    }

    public LoginPage clickSignupLoginButton() {
        WaitUtils.waitForClickableElement(driver,loginButton).click();
        return new LoginPage(driver);
    }

    public ContactUsPage clickContactUsButton() {
        WaitUtils.waitForClickableElement(driver,contactUsButton).click();
        return new ContactUsPage(driver);
    }

    public LoginPage clickLogoutButton() {
        WaitUtils.waitForClickableElement(driver,logoutButton).click();
        return new LoginPage(driver);
    }

    public String getUserName() {
        return WaitUtils.waitForClickableElement(driver,By.xpath("//li[last()]/a/b")).getText();
    }

    public HeaderComponent checkUserLogin(User user) {
        String userName = WaitUtils.waitForClickableElement(driver, By.xpath("//li[last()]/a/b")).getText();
        if (!getUserName().equals(userName)) {
            throw new AssertionError(String.format("Данный пользователь не авторизован. Имя пользователя: %s, отображаемое имя: %s", getUserName(), userName));
        }
        return this;
    }

    public TestCasesPage clickTestCasesButton() {
        WaitUtils.waitForClickableElement(driver,testCasesButton).click();
        return new TestCasesPage(driver);
    }

    public AccountDeletePage clickDeleteAccountButton() {
        WaitUtils.waitForClickableElement(driver,deleteAccountButton).click();
        return new AccountDeletePage(driver);
    }


}
