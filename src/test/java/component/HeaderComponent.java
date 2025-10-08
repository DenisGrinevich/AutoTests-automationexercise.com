package component;

import basic.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.contact.ContactUsPage;
import pages.login.LoginPage;
import pages.main.HomePage;
import pages.products.ProductsPage;
import pages.testcases.TestCasesPage;

public class HeaderComponent extends BaseComponent {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

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


}
