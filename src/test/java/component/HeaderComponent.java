package component;

import basic.base.BaseComponent;
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
    protected WebElement testCasesButton;

    @FindBy(xpath = "//a[@href='/view_cart']")
    protected WebElement cartButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public HomePage clickSiteLogo() {
        waitForClickableElement(By.xpath(("//div[@class='logo pull-left']"))).click();
        return new HomePage(getDriver());
    }

    public ProductsPage clickProductsButton() {
        waitForClickableElement(productsButton).click();
        return new ProductsPage(getDriver());
    }

    public HomePage clickHomeButton() {
        waitForClickableElement(homeButton).click();
        return new HomePage(getDriver());

    }

    public CartPage clickCartButton() {
        waitForClickableElement(cartButton).click();
        return new CartPage(getDriver());
    }

    public LoginPage clickSignupLoginButton() {
        waitForClickableElement(loginButton).click();
        return new LoginPage(getDriver());
    }

    public ContactUsPage clickContactUsButton() {
        waitForClickableElement(contactUsButton).click();
        return new ContactUsPage(getDriver());
    }

    public LoginPage clickLogoutButton() {
        waitForClickableElement(logoutButton).click();
        return new LoginPage(getDriver());
    }

    public String getUserName() {
        return waitForClickableElement(By.xpath("//li[last()]/a/b")).getText();
    }

    public TestCasesPage clickTestCasesButton() {
        waitForClickableElement(testCasesButton).click();
        return new TestCasesPage(getDriver());
    }

    public AccountDeletePage clickDeleteAccountButton() {
        waitForClickableElement(deleteAccountButton).click();
        return new AccountDeletePage(getDriver());
    }


}
