package component;

import basic.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.contact.ContactUsPage;
import pages.login.LoginPage;
import pages.main.HomePage;
import pages.products.ProductsPage;

public class HeaderComponent extends BaseComponent {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "i.fa.fa-home")
    protected WebElement homeButton;

    @FindBy(css = "i.material-icons.card_travel']")
    protected WebElement productsButton;

    @FindBy(xpath = "//a[@href='/login']")
    protected WebElement loginButton;

    @FindBy(xpath = "//a[@href='/logout']")
    protected WebElement logoutButton;

    @FindBy(xpath = "//a[@href='/delete_account']")
    protected WebElement deleteAccountButton;

    @FindBy(xpath = "//a[@href='/contact_us']")
    protected WebElement contactUsButton;

    public HomePage clickSiteLogo() {
        getWait10().until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@class='logo pull-left']"))).click();
        return new HomePage(getDriver());
    }

    public ProductsPage clickProductsButton() {
        getWait10().until(ExpectedConditions
                .elementToBeClickable(productsButton)).click();
        return new ProductsPage(getDriver());
    }

    public HomePage clickHomeButton() {
        getWait10().until(ExpectedConditions.elementToBeClickable(homeButton)).click();
        return new HomePage(getDriver());

    }

    public LoginPage clickSignupLoginButton() {
        getWait10().until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new LoginPage(getDriver());
    }

    public ContactUsPage clickContactUsButton() {
        getWait10().until(ExpectedConditions.elementToBeClickable(contactUsButton)).click();
        return new ContactUsPage(getDriver());
    }

    public LoginPage clickLogoutButton() {
        getWait10().until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        return new LoginPage(getDriver());
    }

    public String getUserName() {
        return getWait10().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[last()]/a/b"))).getText();
    }





}
